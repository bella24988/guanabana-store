package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import modello.Cliente;
import modello.Computer;
import modello.Ordine;

public class DataBase {
	
	/* Global variables definition*/
	private Connection con;
	private Statement st;
	private PreparedStatement stConsultaLog;
	private PreparedStatement stNuevoCliente, stNuovaOrdine;
	private PreparedStatement stConsultaComputer, stConsultaUltimaOrd;
	private PreparedStatement stConta;
	private Statement stModello;
	
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
		setStNuovaOrdine(con.prepareStatement("insert into ordini (codice, totale, stato, cliente, indirizzo_invio, data_modifica, nome_computer, " +
				"ram, cpu, mlc, hd1, hd2, hd3, hd4, dvd, war) " +
				"VALUES(?, ?, UPPER(?), UPPER(?), UPPER(?), ?, UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?), UPPER(?));"));
		setStConsultaUltimaOrd(con.prepareStatement("select max(codice) from ordini;"));
		
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
		if (tipo=="ser"){
			result = stStandardPC.executeQuery("select ram, cpu, pci, mlc, hd1, hd2,hd3,hd4,dvd,war from standard_computer where nome ='"+nome+"'");
			max=10;
		}else if(tipo=="lap"){
			result = stStandardPC.executeQuery("select ram, hd1, cpu, war, gpu from standard_computer where nome ='"+nome+"'");
			max=5;
		}else if(tipo=="des"){
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
	
	
	public String creaNuovaOrdine(Computer comp, float prezzoTotale, Cliente cliente){
		
		ResultSet result = null;
		int numOrdineMax = 0;
		
		try {
			result = stConsultaUltimaOrd.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * @return the st
	 */
	public Statement getSt() {
		return st;
	}

	/**
	 * @param st the st to set
	 */
	public void setSt(Statement st) {
		this.st = st;
	}

	/**
	 * @return the stConsultaLog
	 */
	public PreparedStatement getStConsultaLog() {
		return stConsultaLog;
	}

	/**
	 * @param stConsultaLog the stConsultaLog to set
	 */
	public void setStConsultaLog(PreparedStatement stConsultaLog) {
		this.stConsultaLog = stConsultaLog;
	}

	/**
	 * @return the stNuevoCliente
	 */
	public PreparedStatement getStNuevoCliente() {
		return stNuevoCliente;
	}

	/**
	 * @param stNuevoCliente the stNuevoCliente to set
	 */
	public void setStNuevoCliente(PreparedStatement stNuevoCliente) {
		this.stNuevoCliente = stNuevoCliente;
	}

	/**
	 * @return the stConsultaComputer
	 */
	public PreparedStatement getStConsultaComputer() {
		return stConsultaComputer;
	}

	/**
	 * @param stConsultaComputer the stConsultaComputer to set
	 */
	public void setStConsultaComputer(PreparedStatement stConsultaComputer) {
		this.stConsultaComputer = stConsultaComputer;
	}

	/**
	 * @return the stConta
	 */
	public PreparedStatement getStConta() {
		return stConta;
	}

	/**
	 * @param stConta the stConta to set
	 */
	public void setStConta(PreparedStatement stConta) {
		this.stConta = stConta;
	}

	/**
	 * @return the stNuovaOrdine
	 */
	public PreparedStatement getStNuovaOrdine() {
		return stNuovaOrdine;
	}

	/**
	 * @param stNuovaOrdine the stNuovaOrdine to set
	 */
	public void setStNuovaOrdine(PreparedStatement stNuovaOrdine) {
		this.stNuovaOrdine = stNuovaOrdine;
	}

	/**
	 * @return the stConsultaUltimaOrd
	 */
	public PreparedStatement getStConsultaUltimaOrd() {
		return stConsultaUltimaOrd;
	}

	/**
	 * @param stConsultaUltimaOrd the stConsultaUltimaOrd to set
	 */
	public void setStConsultaUltimaOrd(PreparedStatement stConsultaUltimaOrd) {
		this.stConsultaUltimaOrd = stConsultaUltimaOrd;
	}
}