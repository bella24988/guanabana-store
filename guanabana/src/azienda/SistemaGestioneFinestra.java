package azienda;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import modello.Dipendente;
import modello.Ordine;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.io.IOException;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

/**
 * Classe SistemaGestioneFinestra: Classe che si occupa
 * di gestire l'interfaccia grafica del programma lato azienda
 * in ogni momento, caricando il pannello corrispondente al tipo
 * di dipendente che ha effettuato il login.
 * Estende JFrame
 * @author Gabriele
 * @author Veronica
 * @version 3.0 Jan 3, 2013.
 */
public class SistemaGestioneFinestra extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Dichiarazione delle variabili
	 */
	private Dipendente dipendente;
	private JMenuBar menuBar;
	private JPanel contenutoPanel;
	private LogControllerAzienda logControllerAzienda;
	private JTextArea txtErrore;
	private boolean ok;

	/**
	 * Costruttore del sistema di gestione della finestra
	 * @param logControllerAzienda
	 * @param dipendente
	 */
	public SistemaGestioneFinestra(Dipendente dipendente,
			LogControllerAzienda logControllerAzienda) {
		setResizable(false);
		this.dipendente = dipendente;
		this.setLogControllerAzienda(logControllerAzienda);
		this.setTitle("Gestione ordini - Guanabana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		ok = false;
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		if (dipendente.getDipartimento().compareTo("VENDITA") == 0) {
			mostraMenuVendita();
		} else if (dipendente.getDipartimento().compareTo("MAGAZZINO") == 0) {
			mostraMenuMagazzino();
		} else if (dipendente.getDipartimento().compareTo("SPEDIZIONE") == 0) {
			mostraMenuSpedizione();
		} else {
			mostraMenuVendita();
			mostraMenuMagazzino();
			mostraMenuSpedizione();
		}

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator);

		JTextArea lblUserName = new JTextArea();
		// lblUserName.setEnabled(false);
		lblUserName.setText(" Ruolo: " + dipendente.getDipartimento()
				+ "\r\n Utente: " + dipendente.getNome() + " "
				+ dipendente.getCognome());
		lblUserName.setBackground(SystemColor.menu);
		lblUserName.setEditable(false);
		menuBar.add(lblUserName);

		JButton mntmLogout = new JButton("");
		mntmLogout.setToolTipText("Logout");
		mntmLogout.setIcon(new ImageIcon(SistemaGestioneFinestra.class
				.getResource("/icons/logout-icon.png")));
		mntmLogout.setBorder(null);
		mntmLogout.setBackground(SystemColor.menu);
		mntmLogout.setHorizontalAlignment(SwingConstants.RIGHT);
		mntmLogout.setActionCommand("Logout");
		menuBar.add(mntmLogout);
		mntmLogout.addActionListener(logControllerAzienda);
		mntmLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JPanel panelMessaggio = new JPanel();
		getContentPane().add(panelMessaggio, BorderLayout.SOUTH);

		txtErrore = new JTextArea();
		txtErrore.setColumns(80);
		txtErrore.setBackground(new Color(220, 220, 220));
		txtErrore.setEditable(false);
		txtErrore.setWrapStyleWord(true);
		txtErrore.setVisible(true);
		txtErrore.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtErrore.setForeground(Color.RED);
		txtErrore.setTabSize(100);
		panelMessaggio.add(txtErrore);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		contenutoPanel = new JPanel();
		scrollPane.setViewportView(contenutoPanel);

	}

	/**
	 * Metodo che mostra il menu per gli impiegati
	 * al reparto vendite.
	 */
	private void mostraMenuVendita() {
		VenditeDaGestireController venGestireController = new VenditeDaGestireController(
				this);
		JMenu mnVendite = new JMenu("Vendite");
		menuBar.add(mnVendite);
		mnVendite.setIcon(new ImageIcon(SistemaGestioneFinestra.class
				.getResource("/icons/icona-della-fattura.jpg")));
		mnVendite.setBackground(Color.white);

		JMenuItem mntmPagate = new JMenuItem("Ordini da gestire");
		mnVendite.add(mntmPagate);
		mntmPagate.addActionListener(venGestireController);

		VenditeEvaseController veEvaseController = new VenditeEvaseController(
				this);
		JMenuItem mntmOrdiniEvase = new JMenuItem("Ordini evasi");
		mnVendite.add(mntmOrdiniEvase);

		mntmOrdiniEvase.setBackground(Color.white);
		mntmPagate.setBackground(Color.white);
		mntmOrdiniEvase.addActionListener(veEvaseController);
		mnVendite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmOrdiniEvase.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmPagate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	/**
	 * Metodo che mostra il menu per gli impiegati
	 * al reparto magazzino
	 */
	private void mostraMenuMagazzino() {
		JMenuItem mntmMagazzino = new JMenuItem("Magazzino");
		menuBar.add(mntmMagazzino);
		mntmMagazzino.setBackground(Color.white);
		mntmMagazzino.setIcon(new ImageIcon(SistemaGestioneFinestra.class
				.getResource("/icons/order_icon.jpg")));
		MagazzinoController controller = new MagazzinoController(this);
		mntmMagazzino.addActionListener(controller);
		mntmMagazzino.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	/**
	 * Metodo che mostra il menu per gli impiegati
	 * al reparto spedizioni
	 */
	private void mostraMenuSpedizione() {
		JMenuItem mntmSpedizione = new JMenuItem("Spedizione");
		SpedizioneController spedizioneController = new SpedizioneController(this);
		menuBar.add(mntmSpedizione);
		mntmSpedizione.setIcon(new ImageIcon(SistemaGestioneFinestra.class
				.getResource("/icons/dispatch_order_icon.jpg")));
		mntmSpedizione.setBackground(Color.white);
		mntmSpedizione
				.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmSpedizione
				.setToolTipText("Clicca per vedere le richieste di spedizioni");
		mntmSpedizione.addActionListener(spedizioneController);
	}
	
	/**
	 * Metodo che restituisce la lista degli ordini in base al loro stato
	 * @param stato
	 * @return ordini
	 */
	public Ordine[] elencaOrdini(String stato) {
			
			ClientAzienda servizioClientAzienda = new ClientAzienda();
			Ordine[] ordini = null;
			try {
				ordini = servizioClientAzienda.cercaOrdini(stato);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ordini;
		}
	
	/**
	 * Metodo per aggiornare la pagina.
	 */
	public void Refresh() {
		if (ok) {
			this.setBounds(100, 100, 950, 550);
			ok = false;
		}
		if (!ok) {
			this.setBounds(100, 100, 950, 551);
			ok = true;
		}

	}

	/**
	 * Metodo per pulire lo schermo
	 */
	public void pulisceSchermo() {
		this.getContenutoPanel().removeAll();
		JPanel panelPulito = new JPanel();
		getContenutoPanel().add(panelPulito);
		panelPulito.setSize(800, 800);
		getContenutoPanel().removeAll();
	}
	
	/**
	 * Getter of dipendente
	 * @return dipendente
	 */
	public Dipendente getDipendente() {
		return dipendente;
	}

	/**
	 * Setter of dipendente
	 * @param dipendente
	 */
	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	/**
	 * Getter of contenutoPanel
	 * @return contenutoPanel
	 */
	public JPanel getContenutoPanel() {
		return contenutoPanel;
	}

	/**
	 * Setter of contenutoPanel
	 * @param contenutoPanel
	 */
	public void setContenutoPanel(JPanel contenutoPanel) {
		this.contenutoPanel = contenutoPanel;
	}

	/**
	 * Getter of logControllerAzienda
	 * @return logControllerAzienda.
	 */
	public LogControllerAzienda getLogControllerAzienda() {
		return logControllerAzienda;
	}

	/**
	 * Setter of logControllerAzienda
	 * 
	 * @param logControllerAzienda
	 */
	public void setLogControllerAzienda(
			LogControllerAzienda logControllerAzienda) {
		this.logControllerAzienda = logControllerAzienda;
	}

	/**
	 * Getter of txtErrore
	 * @return txtErrore
	 */
	public String getTxtErrore() {
		return txtErrore.getText();
	}

	/**
	 * Setter of txtErrore
	 * @param txtErrore
	 */
	public void setTxtErrore(String txtErrore) {
		this.txtErrore.setText(txtErrore);
		if (txtErrore == "") {
			this.txtErrore.setVisible(false);
		} else {
			this.txtErrore.setVisible(true);
		}
	}

}
