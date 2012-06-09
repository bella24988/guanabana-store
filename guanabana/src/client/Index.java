package client;

import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

/**
 * @author Lele Classe Index: Applet che contiene tutti i pannelli
 *         dell'applicazione lato client. Implementa l'interfaccia Collegare che
 *         contiene tutti i metodi di connessione.
 */
public class Index extends JApplet {

	/**
	 * Dichiarazione delle variabili degli elementi della finestra
	 */
	private static final long serialVersionUID = 1L; // serializzazione
	public JPanel contentPane; // Pannello principale che contiene tutti gli
								// altri pannelli in ogni momento
	public MenuPanel menuPanel; // Pannello contenente i tipi di computer
								// acquistabili (Des, Lap, Ser) sempre presente
								// in contentPane
	public LogPanel logPanel; // Pannello di login (mostra login, logout e
								// registrati)
	private ContenutoPanel contenuto; // Pannello contenitore, sempre presente,
										// in cui sono visualizzati
										// dinamicamente tutti i pannelli

	// public String host = getCodeBase().getHost(); //host del client

	/**
	 * Costruttore della classe Index
	 */
	public Index() {

		contentPane = new JPanel(); // nuovo contentPane
		contentPane.setBackground(Color.WHITE); // inizializza colore del
												// contentPane
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // inizializza
															// dimensioni del
															// contentPane

		contenuto = new ContenutoPanel(); // nuovo contenuto

		logPanel = new LogPanel(contenuto); // nuovo logPanel: passaggio di
											// contenuto per visualizzare il
											// pannello registrazione
		logPanel.setBackground(Color.WHITE);
		logPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		menuPanel = new MenuPanel(contenuto); // nuovo menuAcquista: passaggio
												// di contenuto per visualizzare
												// il pannello ModelloView

		// suddivide in griglia contentPane e posiziona i tre pannelli logPanel,
		// menuAcquista e contenuto in contentPane
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addComponent(menuPanel,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																logPanel,
																GroupLayout.PREFERRED_SIZE,
																770,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																contenuto,
																GroupLayout.PREFERRED_SIZE,
																799,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addComponent(logPanel,
												GroupLayout.PREFERRED_SIZE, 70,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																contenuto,
																GroupLayout.PREFERRED_SIZE,
																452,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																menuPanel,
																GroupLayout.PREFERRED_SIZE,
																452,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		// suddivisione
		// in griglia
		logPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { logPanel.txtUser, logPanel.txtPassword,
						logPanel.btnLog, logPanel.btnRegistrati }));
		contentPane.setLayout(gl_contentPane);
		this.setSize(900, 500); // dimensione di tutta l'applet

	} // fine costruttore

	/**
	 * inizializza l'applet ed inserisce contentPane in index
	 */
	public void init() {
		getContentPane().add(contentPane);

	}

	public void paint(Graphics g) {
		super.paint(g);
	}

	/**
	 * @uml.property name="menuPanel"
	 * @uml.associationEnd inverse="index:client.MenuPanel"
	 * @uml.association name="menu"
	 */

	// inizio getters and setters
	/**
	 * Getter of the property <tt>menuPanel</tt>
	 * 
	 * @return Returns the menuPanel.
	 * @uml.property name="menuPanel"
	 */
	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	/**
	 * Setter of the property <tt>menuPanel</tt>
	 * 
	 * @param menuPanel
	 *            The menuPanel to set.
	 * @uml.property name="menuPanel"
	 */
	public void setMenuPanel(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	/**
	 * @uml.property name="panelLog"
	 * @uml.associationEnd inverse="index:client.LogPanel"
	 * @uml.association name="mostra"
	 */

	/**
	 * Getter of the property <tt>panelLog</tt>
	 * 
	 * @return Returns the panelLog.
	 * @uml.property name="panelLog"
	 */
	public LogPanel getPanelLog() {
		return logPanel;
	}

	/**
	 * Setter of the property <tt>panelLog</tt>
	 * 
	 * @param panelLog
	 *            The panelLog to set.
	 * @uml.property name="panelLog"
	 */
	public void setPanelLog(LogPanel panelLog) {
		this.logPanel = panelLog;
	}

	/**
	 * @uml.property name="contenuto"
	 * @uml.associationEnd inverse="index:client.ContenutoPanel"
	 * @uml.association name="mostra"
	 */

	/**
	 * Getter of the property <tt>contenuto</tt>
	 * 
	 * @return Returns the contenuto.
	 * @uml.property name="contenuto"
	 */
	public ContenutoPanel getContenuto() {
		return contenuto;
	}

	/**
	 * Setter of the property <tt>contenuto</tt>
	 * 
	 * @param contenuto
	 *            The contenuto to set.
	 * @uml.property name="contenuto"
	 */
	public void setContenuto(ContenutoPanel contenuto) {
		this.contenuto = contenuto;
	}

	/**
	 * @uml.property name="contenuto"
	 * @uml.associationEnd inverse="index:client.ContenutoPanel"
	 * @uml.association name="mostra"
	 */
	// fine getters and setters
}
