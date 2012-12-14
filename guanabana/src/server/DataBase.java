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
 * @author  Veronica
 */
public class DataBase {
	
	/* Global variables definition*/
	private Connection con;
	/**
	 * @uml.property  name="st"
	 */
	private Statement st;
	/**
	 * @uml.property  name="stConsultaLog"
	 */
	private PreparedStatement stConsultaLog;
	/**
	 * @uml.property  name="stNuevoCliente"
	 */
	private PreparedStatement stNuevoCliente;
	/**
	 * @uml.property  name="stNuovaOrdine"
	 */
	private PreparedStatement stNuovaOrdine;
	/**
	 * @uml.property  name="stConsultaComputer"
	 */
	private PreparedStatement stConsultaComputer;
	/**
	 * @uml.property  name="stConsultaUltimaOrd"
	 */
	private PreparedStatement stConsultaUltimaOrd;
	/**
	 * @uml.property  name="stConta"
	 */
	private PreparedStatement stConta;
	/**
	 * @uml.property  name="stMaxPagamento"
	 */
	private PreparedStatement stMaxPagamento;
	/**
	 * @uml.property  name="stInsertPagamento"
	 */
	private PreparedStatement stInsertPagamento;
	/**
	 * @uml.property  name="stAggiornaStatoOrdine"
	 */
	private PreparedStatement stAggiornaStatoOrdine;
	/**
	 * @uml.property  name="stConsultaDipendente"
	 */
	private PreparedStatement stConsultaDipendente;
	private Statement stModello;
	/**
	 * @uml.property  name="stConsultaOrdini"
	 */
	private Statement stConsultaOrdini;
	private Statement stCliente;
	
	/*Begin of the constructor*/
	public DataBase() throws SQLException, ClassNotFoundException{
		/* DataBase Connection */
		Class.forName("com.mysql.jdbc.Driver"); //MySQL driver
		String nomeDb="jdbc:mysql://localhost:3306/guanabanadb"; //Data base URL
		String user="programmatori"; //Data base user
		String password="12345";	//Data base password
		con = DriverManager.getConnection(nomeDb, user, password); //DataBase connection definition
		setSt(con.createStatement()); 
		stModello=con.createStatement();
		
		
		/*Prepared Statement*/
		setStConsultaLog(con.prepareStatement("select * from clienti where email = UPPER(?) and password = ? ;"));
		setStNuevoCliente(con.prepareStatement("INSERT INTO clienti VALUES(UPPER(?) ,UPPER(?) ,UPPER(?),UPPER(?), UPPER(?), UPPER(?), UPPER(?));"));
		setStConsultaComputer(con.prepareStatement("select nome,prezzo from standard_computer where nome like concat(?,'%')"));
		setStConta(con.prepareStatement("select count(*) from standard_computer where nome like concat(?,'%')"));	
		setStConsultaUltimaOrd(con.prepareStatement("select max(codice) from ordini;"));
		setStMaxPagamento(con.prepareStatement("select max(codice) from pagamenti;"));
		setStInsertPagamento(con.prepareStatement("insert into pagamenti (codice, ordine_codice, totale,tipo, data) values (?,?,?,UPPER(?),NOW())"));
		setStAggiornaStatoOrdine(con.prepareStatement("Update ordini set stato = ? where codice=?;"));
		setStConsultaDipendente(con.prepareStatement("select nome, cognome, dipartimento from dipendenti where iduser=? and password=?;"));
		
	}/*End of the constructor*/
	
	/*Function to look for a client in the DB
	 * return the client found*/
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
	
	public void insertCliente(String cf, String nome, String cognome, String email,
			String indirizzo, String telefono, String password) throws SQLException{
		
		//ResultSet insert;
		stNuevoCliente.setString(1, cf);
		stNuevoCliente.setString(2, nome);
		stNuevoCliente.setString(3, cognome);
		stNuevoCliente.setString(4, email);
		stNuevoCliente.setString(5,indirizzo);
		stNuevoCliente.setString(6,telefono);
		stNuevoCliente.setString(7,password);
		stNuevoCliente.executeUpdate();
	}
	
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
	
	public int countComponentiModello(String tipo) throws SQLException{
		int num = 0;
		ResultSet result;
		result = stModello.executeQuery("select id, nome, prezzo from componenti where "+tipo+" = 1");
		result.last();
		num = result.getRow();
		System.out.println(num); //test
		return num;
	}
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
	 * @param nome
	 * @param tipo
	 * @return config, variabile locale di tipo Array di String, la sua lunghezza varia a seconda della variabile tipo.
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
	
	
	public int creaNuovaOrdine(Computer comp, float prezzoTotale, Cliente cliente) throws SQLException{
		
		ResultSet result = null;
		int numOrdineMax = 1;
		if(comp.getTipo().compareTo("SERVER")==0){
			setStNuovaOrdine(con.prepareStatement("insert into ordini (data_modifica, codice, totale, stato, cliente_CF, indirizzo_invio, nome_computer, " +
					"ram, cpu,pci, mlc, hd1, hd2, hd3, hd4, dvd, war) " +
					"VALUES(NOW(),?, ?, UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), " +
					"UPPER(?), UPPER(?));"));
		}else if(comp.getTipo().compareTo("DESKTOP")==0){
			setStNuovaOrdine(con.prepareStatement("insert into ordini (data_modifica, codice, totale, stato, cliente_CF, indirizzo_invio, nome_computer, " +
					"ram, cpu,mou, hd1, hd2,gpu, dvd, war, kei, mon) " +
					"VALUES(NOW(),?, ?, UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), " +
					"UPPER(?), UPPER(?));"));
		}else{
			setStNuovaOrdine(con.prepareStatement("insert into ordini (data_modifica, codice, totale, stato, cliente_CF, indirizzo_invio, nome_computer, " +
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
			stNuovaOrdine.setInt(1, numOrdineMax);
			stNuovaOrdine.setFloat(2, prezzoTotale);
			stNuovaOrdine.setString(3, "ORDINATO");
			stNuovaOrdine.setString(4, cliente.getCf());
			stNuovaOrdine.setString(5, cliente.getIndirizzo());
			stNuovaOrdine.setString(6, comp.getNome());
			
			int i;
			for(i=0; i<comp.getConfigurazione().getComponentiScelti().length;i++){
				stNuovaOrdine.setString(i+7, comp.getConfigurazione().getComponentiScelti()[i].getCodice());
			}
			
			stNuovaOrdine.executeUpdate();
		} catch (SQLException e) {
			System.out.print("Errore al db "+e);
			e.printStackTrace();
		}
		
		return numOrdineMax;
	}
	
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
	
	/**
	 * @return  the st
	 * @uml.property  name="st"
	 */
	public Statement getSt() {
		return st;
	}

	/**
	 * @param st  the st to set
	 * @uml.property  name="st"
	 */
	public void setSt(Statement st) {
		this.st = st;
	}

	/**
	 * @return  the stConsultaLog
	 * @uml.property  name="stConsultaLog"
	 */
	public PreparedStatement getStConsultaLog() {
		return stConsultaLog;
	}

	/**
	 * @param stConsultaLog  the stConsultaLog to set
	 * @uml.property  name="stConsultaLog"
	 */
	public void setStConsultaLog(PreparedStatement stConsultaLog) {
		this.stConsultaLog = stConsultaLog;
	}

	/**
	 * @return  the stNuevoCliente
	 * @uml.property  name="stNuevoCliente"
	 */
	public PreparedStatement getStNuevoCliente() {
		return stNuevoCliente;
	}

	/**
	 * @param stNuevoCliente  the stNuevoCliente to set
	 * @uml.property  name="stNuevoCliente"
	 */
	public void setStNuevoCliente(PreparedStatement stNuevoCliente) {
		this.stNuevoCliente = stNuevoCliente;
	}

	/**
	 * @return  the stConsultaComputer
	 * @uml.property  name="stConsultaComputer"
	 */
	public PreparedStatement getStConsultaComputer() {
		return stConsultaComputer;
	}

	/**
	 * @param stConsultaComputer  the stConsultaComputer to set
	 * @uml.property  name="stConsultaComputer"
	 */
	public void setStConsultaComputer(PreparedStatement stConsultaComputer) {
		this.stConsultaComputer = stConsultaComputer;
	}

	/**
	 * @return  the stConta
	 * @uml.property  name="stConta"
	 */
	public PreparedStatement getStConta() {
		return stConta;
	}

	/**
	 * @param stConta  the stConta to set
	 * @uml.property  name="stConta"
	 */
	public void setStConta(PreparedStatement stConta) {
		this.stConta = stConta;
	}

	/**
	 * @return  the stNuovaOrdine
	 * @uml.property  name="stNuovaOrdine"
	 */
	public PreparedStatement getStNuovaOrdine() {
		return stNuovaOrdine;
	}

	/**
	 * @param stNuovaOrdine  the stNuovaOrdine to set
	 * @uml.property  name="stNuovaOrdine"
	 */
	public void setStNuovaOrdine(PreparedStatement stNuovaOrdine) {
		this.stNuovaOrdine = stNuovaOrdine;
	}

	/**
	 * @return  the stConsultaUltimaOrd
	 * @uml.property  name="stConsultaUltimaOrd"
	 */
	public PreparedStatement getStConsultaUltimaOrd() {
		return stConsultaUltimaOrd;
	}

	/**
	 * @param stConsultaUltimaOrd  the stConsultaUltimaOrd to set
	 * @uml.property  name="stConsultaUltimaOrd"
	 */
	public void setStConsultaUltimaOrd(PreparedStatement stConsultaUltimaOrd) {
		this.stConsultaUltimaOrd = stConsultaUltimaOrd;
	}

	public int registrarePagamento(int numeroOrdine, float prezzo,
			String tipoPagamento) {
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
		
		return numMaxPago;
	}

	public void aggiornaStatoOrdine(String stato, int numeroOrdine) throws SQLException {
		stAggiornaStatoOrdine.setString(1, stato);
		stAggiornaStatoOrdine.setInt(2,numeroOrdine);
		stAggiornaStatoOrdine.executeUpdate();
		
	}

	/**
	 * @return  the stMaxPagamento
	 * @uml.property  name="stMaxPagamento"
	 */
	public PreparedStatement getStMaxPagamento() {
		return stMaxPagamento;
	}

	/**
	 * @param stMaxPagamento  the stMaxPagamento to set
	 * @uml.property  name="stMaxPagamento"
	 */
	public void setStMaxPagamento(PreparedStatement stMaxPagamento) {
		this.stMaxPagamento = stMaxPagamento;
	}

	/**
	 * @return  the stInsertPagamento
	 * @uml.property  name="stInsertPagamento"
	 */
	public PreparedStatement getStInsertPagamento() {
		return stInsertPagamento;
	}

	/**
	 * @param stInsertPagamento  the stInsertPagamento to set
	 * @uml.property  name="stInsertPagamento"
	 */
	public void setStInsertPagamento(PreparedStatement stInsertPagamento) {
		this.stInsertPagamento = stInsertPagamento;
	}

	/**
	 * @return  the stConsultaOrdini
	 * @uml.property  name="stConsultaOrdini"
	 */
	public Statement getStConsultaOrdini() {
		return stConsultaOrdini;
	}

	/**
	 * @param stConsultaOrdini the stConsultaOrdini to set
	 */
	public void setStConsultaOrdini(PreparedStatement stConsultaOrdini) {
		this.stConsultaOrdini = stConsultaOrdini;
	}

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
			ordini = new String[j][7];
			result = stConsultaOrdini.executeQuery("select distinct(ordini.codice), ordini.data, ordini.totale, stato, tipo, nome_computer," +
					" pagamenti.codice from pagamenti, ordini where stato<>'ANNULLATO' and stato<>'ORDINATO' and ordini.codice = ordine_codice and cliente_CF = '"+cf+"' order by ordini.data");
			j=0;
			while(result.next()){
				ordini[j][0]=String.valueOf(result.getInt(1)); //ordine.codice � un intero
				ordini[j][1]=String.valueOf(result.getTimestamp(2));//ordini.data � un timestamp
				ordini[j][2]=String.valueOf(result.getFloat(3));//ordini.totale � un float
				ordini[j][3]=result.getString(4);//stato � un string
				ordini[j][4]=result.getString(5); // tipo � un string
				ordini[j][5]=result.getString(6);// nomecomputer � un string
				ordini[j][6]=String.valueOf(result.getInt(7));//pagamenti.codice � un float
				j++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ordini;
	}

	public String[][] cercaOrdiniNonPagate(String cf){

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
						ordini[j][0]=String.valueOf(result.getInt(1)); //ordine.codice � un intero
						ordini[j][1]=String.valueOf(result.getTimestamp(2));//ordini.data � un timestamp
						ordini[j][2]=String.valueOf(result.getFloat(3));//ordini.totale � un float
						ordini[j][3]=result.getString(4);//stato � un string
						ordini[j][4]=result.getString(5);// nomecomputer � un string
						System.out.println(ordini[j][0]);
						j++;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				return ordini;
	}
	/**
	 * @return  the stAggiornaStatoOrdine
	 * @uml.property  name="stAggiornaStatoOrdine"
	 */
	public PreparedStatement getStAggiornaStatoOrdine() {
		return stAggiornaStatoOrdine;
	}

	/**
	 * @param stAggiornaStatoOrdine  the stAggiornaStatoOrdine to set
	 * @uml.property  name="stAggiornaStatoOrdine"
	 */
	public void setStAggiornaStatoOrdine(PreparedStatement stAggiornaStatoOrdine) {
		this.stAggiornaStatoOrdine = stAggiornaStatoOrdine;
	}

	/**
	 * @return  the stConsultaDipendente
	 * @uml.property  name="stConsultaDipendente"
	 */
	public PreparedStatement getStConsultaDipendente() {
		return stConsultaDipendente;
	}

	/**
	 * @param stConsultaDipendente  the stConsultaDipendente to set
	 * @uml.property  name="stConsultaDipendente"
	 */
	public void setStConsultaDipendente(PreparedStatement stConsultaDipendente) {
		this.stConsultaDipendente = stConsultaDipendente;
	}
	
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
		
		return datiImpiegato;
		
	}

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
					ordini = new String[j][9];
					result = stConsultaOrdini.executeQuery("select distinct(ordini.codice), ordini.data, ordini.totale, stato, tipo, nome_computer," +
							"pagamenti.codice, cliente_CF, confermato from pagamenti, ordini where stato='"+stato+"' and ordini.codice = ordine_codice order by ordini.data");
					j=0;
					while(result.next()){
						ordini[j][0]=String.valueOf(result.getInt(1)); //ordine.codice � un intero
						ordini[j][1]=String.valueOf(result.getTimestamp(2));//ordini.data � un timestamp
						ordini[j][2]=String.valueOf(result.getFloat(3));//ordini.totale � un float
						ordini[j][3]=result.getString(4);//stato � un string
						ordini[j][4]=result.getString(5); // tipo � un string
						ordini[j][5]=result.getString(6);// nomecomputer � un string
						ordini[j][6]=String.valueOf(result.getInt(7));//pagamenti.codice � un float
						ordini[j][7]=result.getString(8);
						ordini[j][8]=String.valueOf(result.getByte(9));
						j++;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				return ordini;
	}
	
	public String[] cercaCliente(String cf){
		String[] cliente = null;
		try {
			cliente= new String[5];
			stCliente = con.createStatement();
			ResultSet result =stCliente.executeQuery("select CF,nome,cognome,indirizzo,telefono from clienti where CF='"+cf+"';");
			while(result.next()){
				for (int i = 0; i < 5; i++) {
					cliente[i]=result.getString(i+1);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
		
	}

	public void confermaPagamento(boolean valore, int codiceOrdine) throws SQLException {
		Statement stConferma = con.createStatement();
		stConferma.executeUpdate("update pagamenti set confermato="+valore+" where ordine_codice='"+codiceOrdine+"';");
	}
}