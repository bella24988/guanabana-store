package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DataBase {
	
	/* Global variables definition*/
	private Connection con;
	private Statement st;
	private PreparedStatement stConsultaLog;
	private PreparedStatement stNuevoCliente;
	private PreparedStatement stConsultaComputer;
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
		setStConsultaLog(con.prepareStatement("select * from clienti where email = ? and password = ? ;"));
		setStNuevoCliente(con.prepareStatement("INSERT INTO clienti VALUES(UPPER(?) ,UPPER(?) ,UPPER(?),UPPER(?), UPPER(?), UPPER(?), UPPER(?));"));
		setStConsultaComputer(con.prepareStatement("select nome,prezzo from standard_computer where nome like concat(?,'%')"));
		setStConta(con.prepareStatement("select count(*) from standard_computer where nome like concat(?,'%')"));		
		
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
			//test
			System.out.println(components[i][0]);
			System.out.println(components[i][1]);
			System.out.println(components[i][2]);

			i++;
		}
		result.close();
		
		return components;
	
		
	}
//	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		int i =0;
//		DataBase db = new DataBase();		
//		String[][] components=db.getComponentiModello("ser");
//		i = db.countComponentiModello("ser");
//	}
	
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
}