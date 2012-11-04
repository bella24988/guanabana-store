package client;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import client.MenuController;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

/**
 * @author Lele Classe MenuPanel: contiene 3 bottoni per selezionare l'acquisto
 *         di Ser, Lap, Des
 */
public class MenuPanel extends JPanel {

	/**
	 * Dichiarazioni delle variabili
	 */
	private static final long serialVersionUID = 1L; // serializzazione
	public JButton btnLaptop; // Bottone Acquista Laptop
	public JButton btnServer; // Bottone Acquista Server
	public JButton btnDesktop;// Bottone Acquista Desktop
	/**
	 * @uml.property name="contenuto"
	 * @uml.associationEnd
	 */
	private ContenutoPanel contenuto; // Pannello contenuto
	/**
	 * @uml.property name="menuController"
	 * @uml.associationEnd
	 */
	private MenuController menuController; // Controllore di questo pannello

	/**
	 * Costruttore della classe: crea il pannello e passa il riferimento a
	 * contenuto
	 */
	public MenuPanel(ContenutoPanel contenuto) {

		// Definisce aspetto MenuPanel e lo suddivide in griglia
		setBackground(Color.WHITE);
		this.setContenuto(contenuto);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 70, 70, 70, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);
		// fine definizione aspetto

		// dichiarazione, definizione aspetto e posizionamento in griglia del
		// bottone Acquista Laptop
		btnLaptop = new JButton("Acquista Laptop");
		btnLaptop.setForeground(new Color(0, 0, 0));
		btnLaptop.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_btnAcquistaLaptop = new GridBagConstraints();
		gbc_btnAcquistaLaptop.fill = GridBagConstraints.BOTH;
		gbc_btnAcquistaLaptop.insets = new Insets(0, 0, 5, 0);
		gbc_btnAcquistaLaptop.gridx = 0;
		gbc_btnAcquistaLaptop.gridy = 0;
		add(btnLaptop, gbc_btnAcquistaLaptop);

		// dichiarazione, definizione aspetto e posizionamento in griglia del
		// bottone Acquista Desktop
		btnDesktop = new JButton("Acquista Desktop");
		btnDesktop.setForeground(new Color(0, 0, 0));
		btnDesktop.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_btnAcquistaDesktop = new GridBagConstraints();
		gbc_btnAcquistaDesktop.fill = GridBagConstraints.BOTH;
		gbc_btnAcquistaDesktop.insets = new Insets(0, 0, 5, 0);
		gbc_btnAcquistaDesktop.gridx = 0;
		gbc_btnAcquistaDesktop.gridy = 1;
		add(btnDesktop, gbc_btnAcquistaDesktop);

		// dichiarazione, definizione aspetto e posizionamento in griglia del
		// bottone Acquista Server
		btnServer = new JButton("Acquista Server");
		btnServer.setForeground(new Color(0, 0, 0));
		btnServer.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_btnAcquistaServer = new GridBagConstraints();
		gbc_btnAcquistaServer.fill = GridBagConstraints.BOTH;
		gbc_btnAcquistaServer.gridx = 0;
		gbc_btnAcquistaServer.gridy = 2;
		add(btnServer, gbc_btnAcquistaServer);

		// Controllori: listeners dei tre bottoni
		menuController = new MenuController(this, contenuto);
		btnLaptop.addActionListener(menuController);
		btnDesktop.addActionListener(menuController);
		btnServer.addActionListener(menuController);
	}

	// inizio getter and setter
	/**
	 * @return the contenuto
	 * @uml.property name="contenuto"
	 */
	public ContenutoPanel getContenuto() {
		return contenuto;
	}

	/**
	 * @param contenuto
	 *            the contenuto to set
	 * @uml.property name="contenuto"
	 */
	public void setContenuto(ContenutoPanel contenuto) {
		this.contenuto = contenuto;
	}
	// fine getter and setter

}
