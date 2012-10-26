package azienda;

import java.awt.EventQueue;

import javax.swing.JFrame;

import modello.Dipendente;
import modello.Ordine;
import java.awt.BorderLayout;
import java.io.IOException;

public class GestioneOrdine {

	private JFrame frame;
	private LogAzienda logAzienda;
	private Dipendente impiegato;
	private Ordine[] ordini;
	private boolean ok = false;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Gestione delle spedizione");
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
	 * @return the ordini
	 */
	public Ordine[] getOrdini() {
		return ordini;
	}

	/**
	 * @param ordini
	 *            the ordini to set
	 */
	public void setOrdini(Ordine[] ordini) {
		this.ordini = ordini;
	}

	/**
	 * @return the impiegato
	 */
	public Dipendente getImpiegato() {
		return impiegato;
	}

	/**
	 * @param impiegato
	 *            the impiegato to set
	 */
	public void setImpiegato(Dipendente impiegato) {
		this.impiegato = impiegato;
	}

	public void refreshOrdini() {
		frame.getContentPane().removeAll();
		setOrdini(enlistaOrdini());
		PanelPrincipalGestione panelPrincipale = new PanelPrincipalGestione(
				ordini, this);
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
