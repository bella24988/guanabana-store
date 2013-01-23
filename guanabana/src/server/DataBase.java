package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import modello.Cliente;
import modello.Computer;


/**
 * Classe DataBase: Classe contenente tutte i metodi per connettersi al DataBase del sito.
 * @author Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class DataBase {
	
	/**
	 * Dichiarazione delle variabili
	 */
	private Connection con;
	private Statement st;
	private PreparedStatement stConsultaLog;
	private PreparedStatement stNuovoCliente;
	private PreparedStatement stNuovoOrdine;
	private PreparedStatement stConsultaComputer;
	private PreparedStatement stConsultaUltimaOrd;
	private PreparedStatement stConta;
	private PreparedStatement stMaxPagamento;
	private PreparedStatement stInsertPagamento;
	private PreparedStatement stAggiornaStatoOrdine;
	private PreparedStatement stConsultaDipendente;
	private Statement stModello, stInsertDettagliPagamento;
	private Statement stConsultaOrdini;
	private Statement stCliente;
	
	/**
	 * Costruttore della classe DataBase
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public DataBase() throws SQLException, ClassNotFoundException{
		/* DataBase Connection */
		Class.forName("com.mysql.jdbc.Driver"); //MySQL driver
		String nomeDb="jdbc:mysql://localhost:3306/guanabanadb"; //Data base URL
		String user="programmatori"; //Data base user
		String password="12345";	//Data base password
		con = DriverManager.getConnection(nomeDb, user, password); //DataBase connection definition
		setSt(con.createStatement()); 
		stModello=con.createStatement();
		
		
		/*Prepared Statements*/
		setStConsultaLog(con.prepareStatement("select * from clienti where email = UPPER(?) and password = ? ;"));
		setStNuovoCliente(con.prepareStatement("INSERT INTO clienti VALUES(UPPER(?) ,UPPER(?) ,UPPER(?),UPPER(?), UPPER(?), UPPER(?), ?);"));
		setStConsultaComputer(con.prepareStatement("select nome,prezzo from standard_computer where nome like concat(?,'%')"));
		setStConta(con.prepareStatement("select count(*) from standard_computer where nome like concat(?,'%')"));	
		setStConsultaUltimaOrd(con.prepareStatement("select max(codice) from ordini;"));
		setStMaxPagamento(con.prepareStatement("select max(codice) from pagamenti;"));
		setStInsertPagamento(con.prepareStatement("insert into pagamenti (codice, ordine_codice, totale,tipo, data) values (?,?,?,UPPER(?),NOW())"));
		setStAggiornaStatoOrdine(con.prepareStatement("Update ordini set stato = ? where codice=?;"));
		setStConsultaDipendente(con.prepareStatement("select nome, cognome, dipartimento from dipendenti where iduser=? and psw=?;"));
		
	}/*End of the constructor*/
	
	/**
	 * Metodo per cercare un cliente nel DataBase
	 * @param email				Email del cliente
	 * @param password			Password del cliente
	 * @return cliente			Il cliente trovato
	 * @throws SQLException
	 */
	public String[] consultaLog(String email, String password) throws SQLException{
		
		//Cliente in DB
		int maxCol=7;
		String[] clienteTrovato = new String[maxCol];
		
		stConsultaLog.setString(1, email);
		stConsultaLog.setString(2, password);
		
		ResultSet result = stConsultaLog.executeQuery();
		
		while(result.next()){
			for(int i = 0; i<maxCol; i++){
				clienteTrovato[i]=result.getString(i+1);
			}
		}
		
		
		return clienteTrovato;
	}//End of Function consultaLog
	
	/**
	 * Metodo per inserire un nuovo cliente nel DataBase
	 * @param cf			Codice fiscale del cliente
	 * @param nome			Nome del cliente
	 * @param cognome		Cognome del cliente
	 * @param email			Email del cliente
	 * @param indirizzo		Indirizzo del cliente
	 * @param telefono		Telefono del cliente
	 * @param password		Password del cliente
	 * @throws SQLException
	 */
	public void insertCliente(String cf, String nome, String cognome, String email,
			String indirizzo, String telefono, String password) throws SQLException{
		
		//ResultSet insert;
		stNuovoCliente.setString(1, cf);
		stNuovoCliente.setString(2, nome);
		stNuovoCliente.setString(3, cognome);
		stNuovoCliente.setString(4, email);
		stNuovoCliente.setString(5,indirizzo);
		stNuovoCliente.setString(6,telefono);
		stNuovoCliente.setString(7,password);
		stNuovoCliente.executeUpdate();
	}
	
	/**
	 * Metodo che restituisce i modelli disponibili in base al tipo di computer
	 * selezionato (Laptop, desktop o server)
	 * @param tipoComputer			Tipo di computer
	 * @param maxCol
	 * @return modelli				Modelli disponibili
	 * @throws SQLException
	 */
	public String[][] cercaModelli(String tipoComputer, int maxCol) throws SQLException{
		
		int maxRig=2;
		
		ResultSet result;
		
		String[][] modelli = new String[maxRig][maxCol];
		
		stConsultaComputer.setString(1, tipoComputer);
		result = stConsultaComputer.executeQuery();
		
		int i=0;
		while(result.next()){
			modelli[i][0]=result.getString(1);
			modelli[i][1]=result.getString(2);
			i++;
		}
		result.close();
		return modelli;
	}

	/**
	 * Metodo che permette di contare
	 * @param str
	 * @return integer
	 * @throws SQLException
	 */
	public int conta(String str) throws SQLException{
		int numero=0;
		ResultSet result;
		
		stConta.setString(1, str);
		result = stConta.executeQuery();
		
		while(result.next()){
			numero = result.getInt(1);
			}
		result.close();
		return numero;
	}
	
	/**
	 * Metodo che permette di contare i componenti configurabili di 
	 * un particolare modello di computer.
	 * @param tipo				Tipo di computer
	 * @return num				Numero di componenti configurabili
	 * @throws SQLException
	 */
	public int countComponentiModello(String tipo) throws SQLException{
		int num = 0;
		ResultSet result;
		result = stModello.executeQuery("select id, nome, prezzo from componenti where "+tipo+" = 1");
		result.last();
		num = result.getRow();
		return num;
	}
	
	/**
	 * Metodo che restituisce i componenti configurabili per un determinato tipo di computer.
	 * @param tipo				Tipo di computer
	 * @return components		Componenti configurabili
	 * @throws SQLException
	 */
	public String[][] getComponentiModello(String tipo) throws SQLException{
		ResultSet result;
		int i=0;
		int maxCol=3;
		
		result = stModello.executeQuery("select id, nome, prezzo from componenti where "+tipo+" = 1");
		
		result.last();
		String [][] components = new String[result.getRow()][maxCol];
		result.beforeFirst();
		
		while(result.next()){
			components[i][0]= result.getString(1);
			components[i][1]= result.getString(2);
			components[i][2]= result.getString(3);
			i++;
		}
		result.close();
		
		return components;
	
		
	}
	
	/**
	 * Metodo che permette di trovare la configurazione standard di un tipo di computer.
	 * @param nome				Nome computer
	 * @param tipo				Tipo di computer
	 * @return config           Lista di componenti costituenti la configurazione standard
	 * @throws SQLException
	 */
	public String[] cercaConfigurazioneDefault(String nome, String tipo) throws SQLException{
		
		ResultSet result = null;
		int max = 0;
		Statement stStandardPC = con.createStatement();
		if (tipo.compareTo("SER")==0){//{"RAM", "CPU", "MLC", "HD0", "HDD", "HDD", "HDD", "DVD", "PCI", "WAR"}
			result = stStandardPC.executeQuery("select ram, cpu, mlc, hd1, hd2, hd3, hd4,dvd, pci,war from standard_computer where nome ='"+nome+"'");
			max=10;
		}else if(tipo.compareTo("LAP")==0){//{"RAM", "CPU", "HD0", "GPU", "DVD", "WAR" },
			result = stStandardPC.executeQuery("select ram, cpu, hd1, gpu, dvd, war from standard_computer where nome ='"+nome+"'");
			max=6;
		}else if(tipo.compareTo("DES")==0){//{"RAM", "CPU", "MOU", "HD0", "HDD", "GPU", "DVD", "WAR", "KEY", "MON"},
			result = stStandardPC.executeQuery("select ram, cpu, mou, hd1, hd2, gpu, dvd, war, kei, mon from standard_computer where nome ='"+nome+"'");
			max=10;
		}
		
		String[] config = new String[max];
		while(result.next()){
			for(int i=0;i<max;i++){
				config[i]=result.getString(i+1);
				}
		}
		return config;
	}
	
	
	/**
	 * Metodo che restituisce la configurazione scelta per un particolare computer ordinato.
	 * @param numOrdine				Numero dell'ordine
	 * @param tipoComputer			Tipo di computer
	 * @return config				Lista di componenti costituenti la configurazione scelta
	 * @throws SQLException
	 */
	public String[][] cercaConfigurazioneScelta(int numOrdine, String tipoComputer) throws SQLException{
		Statement stCercaNomePrezzo = con.createStatement();
		ResultSet result = null, result1 = null;
		int max = 0;
		Statement stStandardPC = con.createStatement();
		if (tipoComputer.compareTo("SER")==0){//{"RAM", "CPU", "MLC", "HD0", "HDD", "HDD", "HDD", "DVD", "PCI", "WAR"}
			result = stStandardPC.executeQuery("select ram, cpu, mlc, hd1, hd2, hd3, hd4,dvd, pci,war from ordini where codice ="+numOrdine);
			max=10;
		}else if(tipoComputer.compareTo("LAP")==0){//{"RAM", "CPU", "HD0", "GPU", "DVD", "WAR" },
			result = stStandardPC.executeQuery("select ram, cpu, hd1, gpu, dvd, war from ordini where codice ="+numOrdine);
			max=6;
		}else if(tipoComputer.compareTo("DES")==0){//{"RAM", "CPU", "MOU", "HD0", "HDD", "GPU", "DVD", "WAR", "KEY", "MON"},
			result = stStandardPC.executeQuery("select ram, cpu, mou, hd1, hd2, gpu, dvd, war, kei, mon from ordini where codice ="+numOrdine);
			max=10;
		}
		
		String[][] config = new String[max][3];
		while(result.next()){
			for(int i=0;i<max;i++){
				config[i][0]=result.getString(i+1);
				result1 = stCercaNomePrezzo.executeQuery("SELECT nome, prezzo from componenti where id='"+config[i][0]+"';");
				while(result1.next()){
					config[i][1]=result1.getString(1);
					config[i][2]=result1.getString(2);
				}
				}
		}
		
		return config;
	}
	
	/**
	 * Metodo che crea un nuovo ordine e lo inserisce nel DataBase
	 * @param comp					Computer ordinato
	 * @param prezzoTotale			Prezzo totale
	 * @param cliente				Cliente che ha effettuato l'ordine
	 * @return numOrdineMax			Numero dell'ordine creato
	 * @throws SQLException
	 */
	public int creaNuovaOrdine(Computer comp, float prezzoTotale, Cliente cliente) throws SQLException{
		
		ResultSet result = null;
		int numOrdineMax = 1;
		if(comp.getTipo().compareTo("SERVER")==0){
			setStNuovoOrdine(con.prepareStatement("insert into ordini (data_modifica, codice, totale, stato, cliente_CF, indirizzo_invio, nome_computer, " +
					"ram, cpu,pci, mlc, hd1, hd2, hd3, hd4, dvd, war) " +
					"VALUES(NOW(),?, ?, UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), " +
					"UPPER(?), UPPER(?));"));
		}else if(comp.getTipo().compareTo("DESKTOP")==0){
			setStNuovoOrdine(con.prepareStatement("insert into ordini (data_modifica, codice, totale, stato, cliente_CF, indirizzo_invio, nome_computer, " +
					"ram, cpu,mou, hd1, hd2,gpu, dvd, war, kei, mon) " +
					"VALUES(NOW(),?, ?, UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), " +
					"UPPER(?), UPPER(?));"));
		}else{
			setStNuovoOrdine(con.prepareStatement("insert into ordini (data_modifica, codice, totale, stato, cliente_CF, indirizzo_invio, nome_computer, " +
					"ram, cpu,hd1,gpu, dvd, war) " +
					"VALUES(NOW(),?, ?, UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?));"));
		}
		
		/*{ "RAM", "CPU", "HD0", "GPU", "DVD", "WAR" },
			{ "RAM", "CPU", "MOU", "HD0", "HDD", "GPU", "DVD", "WAR", "KEY",
					"MON" },
		 * 
		 * */
		try {
			result = stConsultaUltimaOrd.executeQuery();
			if (result!=null){
			while(result.next()){
				numOrdineMax = result.getInt(1)+1;
			}
			}
			stNuovoOrdine.setInt(1, numOrdineMax);
			stNuovoOrdine.setFloat(2, prezzoTotale);
			stNuovoOrdine.setString(3, "ORDINATO");
			stNuovoOrdine.setString(4, cliente.getCf());
			stNuovoOrdine.setString(5, cliente.getIndirizzo());
			stNuovoOrdine.setString(6, comp.getNome());
			
			int i;
			for(i=0; i<comp.getConfigurazione().getComponentiScelti().length;i++){
				stNuovoOrdine.setString(i+7, comp.getConfigurazione().getComponentiScelti()[i].getCodice());
			}
			
			stNuovoOrdine.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return numOrdineMax;
	}
	
	/**
	 * Metodo che permette di ottenere la data di un ordine
	 * @param codice		Numero d'ordine
	 * @return data			Data dell'ordine
	 * @throws SQLException
	 */
	public String[] getDataOrdine(int codice) throws SQLException{
		String data[] = new String[2];
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery("select data, stato from ordini where codice="+codice+";");
		while(result.next()){
			data[0] = result.getString(1);
			data[1] = result.getString(2);
		}
		
		return data;
	}
	public int registrarePagamento(int numeroOrdine, float prezzo,
			String tipoPagamento, String arg1, String arg2) {
		ResultSet result = null;
		int numMaxPago = 1;
		
		try {
			result = stMaxPagamento.executeQuery();
			if (result!=null){
			while(result.next()){
				numMaxPago = result.getInt(1)+1;
			}
			}
			
			stInsertPagamento.setInt(1, numMaxPago);
			stInsertPagamento.setInt(2, numeroOrdine);
			stInsertPagamento.setFloat(3, prezzo);
			stInsertPagamento.setString(4, tipoPagamento);
			
			
			stInsertPagamento.executeUpdate();
			aggiornaStatoOrdine("VENDUTO", numeroOrdine);
			
		} catch (SQLException e) {
			System.out.print("Errore al db "+e);
			e.printStackTrace();
		}
		
		try {
			registraDettagliPagamento(numMaxPago, tipoPagamento, arg1, arg2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numMaxPago;
	}
	
	/**
	 * Metodo per registrare nel DataBase i dettagli di un pagamento.
	 * @param numPagamento			Numero del pagamento
	 * @param tipoPagamento			Tipo di pagamento
	 * @param arg1
	 * @param arg2
	 * @throws SQLException
	 */
	private void registraDettagliPagamento(int numPagamento, String tipoPagamento, String arg1, String arg2) throws SQLException{
		stInsertDettagliPagamento = con.createStatement();
		if(tipoPagamento.compareTo("Bonifico")==0){
			stInsertDettagliPagamento.executeUpdate("Insert into bonifico values('"+numPagamento+"','"+arg1+"','"+arg2+"'); ");
		}else if (tipoPagamento.compareTo("Carta di Credito")==0){
			stInsertDettagliPagamento.executeUpdate("Insert into carta_credito values('"+numPagamento+"', '"+arg2+"', '"+arg1+"'); ");
		}
	}
	
	/**
	 * Metodo che restituisce i dettagli di un certo pagamento.
	 * @param numPagamento			Numero di pagamento
	 * @param tipoPagamento			Tipo di pagamento
	 * @return args					Dettagli del pagamento
	 * @throws SQLException
	 */
	public String[] cercaDettagliPagamento(int numPagamento, String tipoPagamento) throws SQLException{
		String[] args = new String[2];
		Statement stCercaDetagliPagamento = con.createStatement();
		ResultSet result = null;
		if (tipoPagamento.compareTo("BONIFICO")==0){
			result = stCercaDetagliPagamento.executeQuery("SELECT numeroBonifico, banca FROM bonifico where numeroPagamento="+numPagamento+";");
		}else if (tipoPagamento.compareTo("CARTA DI CREDITO")==0){
			result = stCercaDetagliPagamento.executeQuery("select numeroCarta, intestatario from carta_credito where numeroPagamento="+numPagamento+";");
		}
		
		while(result.next()){
			args[0] = result.getString(1);
			args[1] = result.getString(2);
		}
		
		return args;
	}

	/**
	 * Metodo per aggiornare lo stato di un ordine
	 * @param stato				Stato dell'ordine
	 * @param numeroOrdine		Numero dell'ordine
	 * @throws SQLException
	 */
	public void aggiornaStatoOrdine(String stato, int numeroOrdine) throws SQLException {
		stAggiornaStatoOrdine.setString(1, stato);
		stAggiornaStatoOrdine.setInt(2,numeroOrdine);
		stAggiornaStatoOrdine.executeUpdate();
		
	}
	
	/**
	 * Metodo che restituisce gli ordini effettuati da un cliente
	 * @param cf			Codice fiscale del cliente
	 * @return ordini		Ordini effettuati dal cliente
	 */
	public String[][] consultaOrdini(String cf) {
		//ordini.codice, ordini.data, ordini.totale, stato, tipo, nome_computer, pagamenti.codice
		String[][] ordini = null;
			
		try {
			//Conta righe
			stConsultaOrdini = con.createStatement();
			ResultSet result = stConsultaOrdini.executeQuery("select count(*) from pagamenti, ordini where stato<>'ANNULLATO' and stato<>'ORDINATO'" +
					"and ordini.codice = ordine_codice and cliente_CF = '"+cf+"';");
			int j=0;
			while(result.next()){
				j= result.getInt(1);
			}
			
			//chiama lista di ordini
			ordini = new String[j][9];
			result = stConsultaOrdini.executeQuery("select distinct(ordini.codice), ordini.data, ordini.totale, stato, tipo, nome_computer," +
					" pagamenti.codice, standard_computer.prezzo, confermato from pagamenti, ordini, standard_computer where stato<>'ANNULLATO' and stato<>'ORDINATO' and ordini.codice = ordine_codice " +
					"and nome = nome_computer and cliente_CF = '"+cf+"' order by ordini.data");
			j=0;
			while(result.next()){
				ordini[j][0]=String.valueOf(result.getInt(1)); //ordine.codice e' un intero
				ordini[j][1]=String.valueOf(result.getTimestamp(2));//ordini.data e' un timestamp
				ordini[j][2]=String.valueOf(result.getFloat(3));//ordini.totale e' un float
				ordini[j][3]=result.getString(4);//stato e' un string
				ordini[j][4]=result.getString(5); // tipo e' un string
				ordini[j][5]=result.getString(6);// nomecomputer e' un string
				ordini[j][6]=String.valueOf(result.getInt(7));//pagamenti.codice 
				ordini[j][7]=result.getString(8);
				ordini[j][8]=result.getString(9);
				j++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ordini;
	}

	/**
	 * Metodo che restituisce gli ordini non ancora pagati da un cliente.
	 * @param cf			Codice fiscale del cliente
	 * @return ordini		Ordini non ancora pagati
	 */
	public String[][] cercaOrdiniNonPagati(String cf){

				String[][] ordini = null;
					
				try {
					//Conta righe
					stConsultaOrdini = con.createStatement();//select count(*) from ordini where stato='NON PAGATO' and cliente_CF = 'KJDFS' order by data
					ResultSet result = stConsultaOrdini.executeQuery("select count(*) from ordini where stato='ORDINATO' and cliente_CF = '"+cf+"';");
					int j=0;
					while(result.next()){
						j= result.getInt(1);
					}
					
					//chiama lista di ordini
					ordini = new String[j][5];
					result = stConsultaOrdini.executeQuery("select distinct(codice), data, totale, stato, nome_computer" +
							" from ordini where stato='ORDINATO' and cliente_CF = '"+cf+"' order by data");
					j=0;
					while(result.next()){
						ordini[j][0]=String.valueOf(result.getInt(1)); //ordine.codice e' un intero
						ordini[j][1]=String.valueOf(result.getTimestamp(2));//ordini.data e' un timestamp
						ordini[j][2]=String.valueOf(result.getFloat(3));//ordini.totale e' un float
						ordini[j][3]=result.getString(4);//stato e' un string
						ordini[j][4]=result.getString(5);// nomecomputer e' un string
						
						j++;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				return ordini;
	}
	
	/**
	 * Metodo che restituisce i dati di un dipendente dell'azienda
	 * @param id				Numero identificativo del dipendente
	 * @param password			Password del dipendente
	 * @return datiImpiegato	Dati del dipendente
	 * @throws SQLException
	 */
	public String[] cercaDipendente(int id, String password) throws SQLException{
		String[] datiImpiegato = new String[3];
		stConsultaDipendente.setInt(1, id);
		stConsultaDipendente.setString(2, password);
		
		ResultSet result = stConsultaDipendente.executeQuery();
		while(result.next()){
			for (int i = 0; i < 3; i++) {
				datiImpiegato[i]=result.getString(i+1);
			}
			
		}
		System.out.println("Impiegato "+datiImpiegato[0]);
		return datiImpiegato;
		
	}

	/**
	 * Metodo che restituisce una lista degli ordini in base al loro stato
	 * @param stato		Stato dell'ordine
	 * @return ordini	Ordini trovati in base allo stato
	 */
	public String[][] cercaOrdini(String stato) {
		//ordini.codice, ordini.data, ordini.totale, stato, tipo, nome_computer, pagamenti.codice
				String[][] ordini = null;
					
				try {
					//Conta righe
					stConsultaOrdini = con.createStatement();
					ResultSet result = stConsultaOrdini.executeQuery("select count(*) from pagamenti, ordini where stato='"+stato+"'and ordini.codice = ordine_codice;");
					int j=0;
					while(result.next()){
						j= result.getInt(1);
					}
					
					//chiama lista di ordini
					ordini = new String[j][10];
					result = stConsultaOrdini.executeQuery("select distinct(ordini.codice), ordini.data, ordini.totale, stato, tipo, nome_computer," +
							"pagamenti.codice, cliente_CF, confermato, standard_computer.prezzo from pagamenti, ordini, standard_computer where stato='"+stato+"' and " +
									"ordini.codice = ordine_codice and nome_computer = nome order by ordini.data");
					j=0;
					while(result.next()){
						ordini[j][0]=String.valueOf(result.getInt(1)); //ordine.codice e' un intero
						ordini[j][1]=String.valueOf(result.getTimestamp(2));//ordini.data e' un timestamp
						ordini[j][2]=String.valueOf(result.getFloat(3));//ordini.totale e' un float
						ordini[j][3]=result.getString(4);//stato e' un string
						ordini[j][4]=result.getString(5); // tipo e' un string
						ordini[j][5]=result.getString(6);// nomecomputer e' un string
						ordini[j][6]=String.valueOf(result.getInt(7));//pagamenti.codice e' un float
						ordini[j][7]=result.getString(8);
						ordini[j][8]=String.valueOf(result.getByte(9));
						ordini[j][9]=String.valueOf(result.getString(10));
						j++;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				return ordini;
	}
	
	/**
	 * Metodo che restituisce un cliente in base al codice fiscale
	 * @param cf			Codice fiscale del cliente
	 * @return cliente		Cliente trovato
	 */
	public String[] cercaCliente(String cf){
		String[] cliente = null;
		try {
			cliente= new String[6];
			stCliente = con.createStatement();
			ResultSet result =stCliente.executeQuery("select CF,nome,cognome,indirizzo,telefono,email from clienti where CF='"+cf+"';");
			while(result.next()){
				for (int i = 0; i < 6; i++) {
					cliente[i]=result.getString(i+1);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
		
	}

	/**
	 * Metodo per confermare un pagamento
	 * @param valore				True se il pagamento e' confermato, false altrimenti
	 * @param codicePagamento		Codice del pagamento
	 * @throws SQLException
	 */
	public void confermaPagamento(boolean valore, int codicePagamento) throws SQLException {
		Statement stConferma = con.createStatement();
		stConferma.executeUpdate("update pagamenti set confermato="+valore+" where codice='"+codicePagamento+"';");
	}
	
	/**
	 * Metodo che restituisce il codice fiscale del cliente che ha effettuato un certo ordine.
	 * @param numOrdine			Numero dell'ordine
	 * @return cf				Codice fiscale del cliente che ha effettuato l'ordine
	 * @throws SQLException
	 */
	public String cercaClienteDalOrdine(int numOrdine) throws SQLException{
		String cf = null;
		stCliente = con.createStatement();
		ResultSet result =stCliente.executeQuery("select cliente_CF from ordini where codice='"+numOrdine+"';");
		while(result.next()){
			cf=result.getString(1);
			}
		return cf;
	}
	
	/**
	 * Metodo che restituisce la fattura di un certo ordine.
	 * @param codiceOrdine			Numero dell'ordine
	 * @return campiFattura			Contenuto della fattura dell'ordine
	 * @throws SQLException
	 */
	public String[] cercaFattura(int codiceOrdine) throws SQLException{
		String[] campiFattura = new String[2];
		
		Statement stFattura = con.createStatement();
		ResultSet result =stFattura.executeQuery("SELECT numero, data_emissione FROM guanabanadb.fattura where cod_ordine="+codiceOrdine+";");
		while(result.next()){
			campiFattura[0]=result.getString(1);
			campiFattura[1]=result.getString(2);
		}
		
		return campiFattura;
		
	}
	
	/**
	 * Metodo che permette di creare la fattura di un certo ordine.
	 * @param codiceOrdine				Numero d'ordine da fatturare
	 * @return campiFattura				Contenuto della fattura creata
	 * @throws SQLException
	 */
	public String[] creaFattura(int codiceOrdine) throws SQLException{
		
		Statement stFattura = con.createStatement();
		stFattura.executeUpdate("Insert into fattura (cod_ordine) values("+codiceOrdine+");");
		
		return cercaFattura(codiceOrdine);
		
	}

	/**
	 * Metodo per cancellare un pagamento
	 * @param tipoPagamento		Tipo di pagamento
	 * @param numPagamento		Numero di pagamento
	 * @throws SQLException
	 */
	public void cancellaPagamento(String tipoPagamento, int numPagamento) throws SQLException {
		java.sql.CallableStatement cs = null;
		cs = con.prepareCall("{call deleteBonifico(?, ?)}");
		cs.setInt(1, numPagamento);
		cs.setString(2, tipoPagamento);
		cs.executeQuery();
	}
	
	/**
	 * Getter of st
	 * @return st
	 */
	public Statement getSt() {
		return st;
	}

	/**
	 * Setter of st
	 * @param st
	 */
	public void setSt(Statement st) {
		this.st = st;
	}

	/**
	 * Getter of stConsultaLog
	 * @return stConsultaLog
	 */
	public PreparedStatement getStConsultaLog() {
		return stConsultaLog;
	}

	/**
	 * Setter of stConsultaLog
	 * @param stConsultaLog
	 */
	public void setStConsultaLog(PreparedStatement stConsultaLog) {
		this.stConsultaLog = stConsultaLog;
	}

	/**
	 * Getter of stNuovoCliente
	 * @return stNuovoCliente
	 */
	public PreparedStatement getStNuovoCliente() {
		return stNuovoCliente;
	}

	/**
	 * Setter of stNuovoCliente
	 * @param stNuovoCliente
	 */
	public void setStNuovoCliente(PreparedStatement stNuovoCliente) {
		this.stNuovoCliente = stNuovoCliente;
	}

	/**
	 * Getter of stConsultaComputer
	 * @return stConsultaComputer
	 */
	public PreparedStatement getStConsultaComputer() {
		return stConsultaComputer;
	}

	/**
	 * Setter of stConsultaComputer
	 * @param stConsultaComputer
	 */
	public void setStConsultaComputer(PreparedStatement stConsultaComputer) {
		this.stConsultaComputer = stConsultaComputer;
	}

	/**
	 * Getter of stConta
	 * @return stConta
	 */
	public PreparedStatement getStConta() {
		return stConta;
	}

	/**
	 * Setter of stConta
	 * @param stConta
	 */
	public void setStConta(PreparedStatement stConta) {
		this.stConta = stConta;
	}

	/**
	 * Getter of stNuovoOrdine
	 * @return stNuovoOrdine
	 */
	public PreparedStatement getStNuovoOrdine() {
		return stNuovoOrdine;
	}

	/**
	 * Setter of stNuovoOrdine
	 * @param stNuovoOrdine
	 */
	public void setStNuovoOrdine(PreparedStatement stNuovoOrdine) {
		this.stNuovoOrdine = stNuovoOrdine;
	}

	/**
	 * Getter of stConsultaUltimaOrd
	 * @return stConsultaUltimaOrd
	 */
	public PreparedStatement getStConsultaUltimaOrd() {
		return stConsultaUltimaOrd;
	}

	/**
	 * Setter of stConsultaUltimaOrd
	 * @param stConsultaUltimaOrd
	 */
	public void setStConsultaUltimaOrd(PreparedStatement stConsultaUltimaOrd) {
		this.stConsultaUltimaOrd = stConsultaUltimaOrd;
	}

	/**
	 * Getter of stMaxPagamento
	 * @return stMaxPagamento
	 */
	public PreparedStatement getStMaxPagamento() {
		return stMaxPagamento;
	}

	/**
	 * Setter of stMaxPagamento
	 * @param stMaxPagamento
	 */
	public void setStMaxPagamento(PreparedStatement stMaxPagamento) {
		this.stMaxPagamento = stMaxPagamento;
	}

	/**
	 * Getter of stInsertPagamento
	 * @return stInsertPagamento
	 */
	public PreparedStatement getStInsertPagamento() {
		return stInsertPagamento;
	}

	/**
	 * Setter of stInsertPagamento
	 * @param stInsertPagamento
	 */
	public void setStInsertPagamento(PreparedStatement stInsertPagamento) {
		this.stInsertPagamento = stInsertPagamento;
	}

	/**
	 * Getter of stConsultaOrdini
	 * @return stConsultaOrdini
	 */
	public Statement getStConsultaOrdini() {
		return stConsultaOrdini;
	}

	/**
	 * Setter of stConsultaOrdini
	 * @param stConsultaOrdini
	 */
	public void setStConsultaOrdini(PreparedStatement stConsultaOrdini) {
		this.stConsultaOrdini = stConsultaOrdini;
	}

	/**
	 * Getter od stAggiornaStatoOrdine
	 * @return stAggiornaStatoOrdine
	 */
	public PreparedStatement getStAggiornaStatoOrdine() {
		return stAggiornaStatoOrdine;
	}

	/**
	 * Setter of stAggiornaStatoOrdine
	 * @param stAggiornaStatoOrdine
	 */
	public void setStAggiornaStatoOrdine(PreparedStatement stAggiornaStatoOrdine) {
		this.stAggiornaStatoOrdine = stAggiornaStatoOrdine;
	}

	/**
	 * Getter of stConsultaDipendente
	 * @return stConsultaDipendente
	 */
	public PreparedStatement getStConsultaDipendente() {
		return stConsultaDipendente;
	}

	/**
	 * Setter of stConsultaDipendente
	 * @param stConsultaDipendente
	 */
	public void setStConsultaDipendente(PreparedStatement stConsultaDipendente) {
		this.stConsultaDipendente = stConsultaDipendente;
	}

}