package azienda;

import java.awt.EventQueue;

import javax.swing.JFrame;

import modello.Ordine;

import server.DataBase;

import java.awt.BorderLayout;
import java.sql.SQLException;

public class GestioneOrdine {

	private JFrame frame;
	private LogAzienda logAzienda;
	private DataBase db;
	private String[] impiegato;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneOrdine window = new GestioneOrdine();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestioneOrdine() {
		initialize();
		try {
			db = new DataBase();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLogAzienda(new LogAzienda(this));
		frame.getContentPane().add(logAzienda, BorderLayout.CENTER);
	}

	public void mostraPanelPrincipale(String nome, String cognome,
			String dipartimento, Ordine[] ordini) {
		frame.getContentPane().removeAll();
		frame.setBounds(100, 100, 800, 500);
		PanelPrincipalGestione panelPrincipale = new PanelPrincipalGestione(
				ordini);

		frame.getContentPane().add(panelPrincipale);
	}

	/**
	 * @return the logAzienda
	 */
	public LogAzienda getLogAzienda() {
		return logAzienda;
	}

	/**
	 * @param logAzienda
	 *            the logAzienda to set
	 */
	public void setLogAzienda(LogAzienda logAzienda) {
		this.logAzienda = logAzienda;
	}

	/**
	 * @return the db
	 */
	public DataBase getDb() {
		return db;
	}

	/**
	 * @param db
	 *            the db to set
	 */
	public void setDb(DataBase db) {
		this.db = db;
	}

}
