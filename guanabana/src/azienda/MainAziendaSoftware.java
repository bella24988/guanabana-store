package azienda;

import java.awt.EventQueue;

import javax.swing.JFrame;

import modello.Dipendente;
import modello.Ordine;
import java.awt.BorderLayout;
import java.io.IOException;

/**
 * @author  Veronica
 */
public class MainAziendaSoftware {

	private JFrame frame;
	/**
	 * @uml.property  name="logAzienda"
	 * @uml.associationEnd  
	 */
	private LogAzienda logAzienda;
	/**
	 * @uml.property  name="impiegato"
	 * @uml.associationEnd  
	 */
	private Dipendente impiegato;
	/**
	 * @uml.property  name="ordini"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private Ordine[] ordini;
	private boolean ok = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainAziendaSoftware window = new MainAziendaSoftware();
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
	public MainAziendaSoftware() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Guanabana INC - Gestione Vendite");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inizializza();
	}

	private void inizializza() {
		frame.setResizable(false);
		frame.setBounds(100, 100, 300, 120);
		setLogAzienda(new LogAzienda(this));
		frame.getContentPane().add(logAzienda, BorderLayout.CENTER);
	}

	public void mostraPanelPrincipale(Dipendente impiegato) {
		frame.getContentPane().removeAll();
		setImpiegato(impiegato);
		refreshOrdini();
	}

	public void logOut() {
		frame.getContentPane().removeAll();
		inizializza();
		setImpiegato(null);
	}

	/**
	 * @return  the logAzienda
	 * @uml.property  name="logAzienda"
	 */
	public LogAzienda getLogAzienda() {
		return logAzienda;
	}

	/**
	 * @param logAzienda  the logAzienda to set
	 * @uml.property  name="logAzienda"
	 */
	public void setLogAzienda(LogAzienda logAzienda) {
		this.logAzienda = logAzienda;
	}

	/**
	 * @return  the ordini
	 * @uml.property  name="ordini"
	 */
	public Ordine[] getOrdini() {
		return ordini;
	}

	/**
	 * @param ordini  the ordini to set
	 * @uml.property  name="ordini"
	 */
	public void setOrdini(Ordine[] ordini) {
		this.ordini = ordini;
	}

	/**
	 * @return  the impiegato
	 * @uml.property  name="impiegato"
	 */
	public Dipendente getImpiegato() {
		return impiegato;
	}

	/**
	 * @param impiegato  the impiegato to set
	 * @uml.property  name="impiegato"
	 */
	public void setImpiegato(Dipendente impiegato) {
		this.impiegato = impiegato;
	}

	public void refreshOrdini() {
		frame.getContentPane().removeAll();
		setOrdini(enlistaOrdini());
		MagazinoPanel panelPrincipale = new MagazinoPanel(ordini, this);
		frame.getContentPane().add(panelPrincipale);
		if (ok) {
			frame.setBounds(100, 100, 800, 500);
			ok = false;
		}
		if (!ok) {
			frame.setBounds(100, 100, 800, 501);
			ok = true;
		}
		panelPrincipale.setVisible(true);
	}

	public Ordine[] enlistaOrdini() {
		ClientAzienda servizioClientAzienda = new ClientAzienda();
		Ordine[] ordini = null;
		try {
			ordini = servizioClientAzienda.cercaOrdini();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordini;
	}

}
