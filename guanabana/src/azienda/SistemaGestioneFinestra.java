package azienda;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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

public class SistemaGestioneFinestra extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contenutoPanel;
	private Dipendente dipendente;
	private JMenuBar menuBar;
	private LogControllerAzienda logControllerAzienda;
	private JTextArea txtErrore;
	private Border border;
	private Cursor cursor;
	private boolean ok;

	/**
	 * Create the frame.
	 * 
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
		setBounds(100, 100, 735, 488);
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
		lblUserName.setText("Ruolo: " + dipendente.getDipartimento()
				+ "\r\n Utente: " + dipendente.getNome() + " "
				+ dipendente.getCognome());
		lblUserName.setBackground(SystemColor.menu);
		lblUserName.setEditable(false);
		menuBar.add(lblUserName);

		JButton mntmLogout = new JButton("");
		mntmLogout.setToolTipText("Logout");
		mntmLogout.setIcon(new ImageIcon(SistemaGestioneFinestra.class
				.getResource("/icons/logout-icon.png")));
		border = new LineBorder(SystemColor.menu, 1);
		mntmLogout.setBorder(null);
		mntmLogout.setBackground(SystemColor.menu);
		mntmLogout.setHorizontalAlignment(SwingConstants.RIGHT);
		mntmLogout.setActionCommand("Logout");
		menuBar.add(mntmLogout);
		mntmLogout.addActionListener(logControllerAzienda);
		mntmLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		contenutoPanel = new JPanel();
		contenutoPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenutoPanel.setLayout(new BorderLayout(0, 0));
		getContentPane().add(contenutoPanel, BorderLayout.NORTH);

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

	}

	private void mostraMenuVendita() {
		VenditaDaGestireController venGestireController = new VenditaDaGestireController(
				this);
		JMenu mnVendite = new JMenu("Vendite");
		menuBar.add(mnVendite);
		JMenuItem mntmPagate = new JMenuItem("Ordini da gestire");
		mnVendite.add(mntmPagate);
		mntmPagate.addActionListener(venGestireController);

		JMenuItem mntmPerPagare = new JMenuItem("Ordini evase");
		mnVendite.add(mntmPerPagare);
	}

	private void mostraMenuSpedizione() {
		JButton mntmMagazzino = new JButton("Magazzino");
		menuBar.add(mntmMagazzino);
		mntmMagazzino.setBackground(SystemColor.menu);
		MagazinoController controller = new MagazinoController(this);
		mntmMagazzino.addActionListener(controller);
	}

	private void mostraMenuMagazzino() {
		JButton mntmSpedizione = new JButton("Spedizione");
		menuBar.add(mntmSpedizione);
		mntmSpedizione.setBackground(SystemColor.menu);
	}

	/**
	 * @return the dipendente
	 */
	public Dipendente getDipendente() {
		return dipendente;
	}

	/**
	 * @param dipendente
	 *            the dipendente to set
	 */
	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	public JPanel getContenutoPanel() {
		return contenutoPanel;
	}

	public void setContenutoPanel(JPanel contenutoPanel) {
		this.contenutoPanel = contenutoPanel;
	}

	/**
	 * Getter of the property <tt>logControllerAzienda</tt>
	 * 
	 * @return Returns the controllerAzienda.
	 * @uml.property name="logControllerAzienda"
	 */
	public LogControllerAzienda getLogControllerAzienda() {
		return logControllerAzienda;
	}

	/**
	 * Setter of the property <tt>logControllerAzienda</tt>
	 * 
	 * @param logControllerAzienda
	 *            The controllerAzienda to set.
	 * @uml.property name="logControllerAzienda"
	 */
	public void setLogControllerAzienda(
			LogControllerAzienda logControllerAzienda) {
		this.logControllerAzienda = logControllerAzienda;
	}

	public String getTxtErrore() {
		return txtErrore.getText();
	}

	public void setTxtErrore(String txtErrore) {
		this.txtErrore.setText(txtErrore);
		if (txtErrore == "") {
			this.txtErrore.setVisible(false);
		} else {
			this.txtErrore.setVisible(true);
		}
	}

	public Ordine[] enlistaOrdini(String stato) {
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

	public void Refresh() {
		if (ok) {
			this.setBounds(100, 100, 800, 500);
			ok = false;
		}
		if (!ok) {
			this.setBounds(100, 100, 800, 501);
			ok = true;
		}

	}
}
