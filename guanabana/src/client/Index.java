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

/*<applet CODE=client.Index.class archive="jars/mailapi.jar, jars/dsn.jar, jars/mysql-connector-java-5.0.8-bin.jar, 
	jars/pop3.jar, jars/imap.jar, jars/index.jar ,jars/itext-pdfa-5.3.4-javadoc.jar, jars/smtp.jar, jars/itextpdf-5.3.4.jar" 
 	WIDTH=1200 HEIGHT=800>
   	questo browser non soporta gli applet, vi preghiamo cambiare browser
	</applet>
 */

/**
 * Classe Index: Applet che contiene tutti i pannelli dell'applicazione lato
 * client. Implementa l'interfaccia cliente che contiene tutti i metodi di
 * connessione.
 * Extends JApplet.
 * @author Gabriele
 * @author Veronica
 * @version 3.0 Jan 3, 2013.
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

	/**
	 * Costruttore della classe Index
	 */
	public void inizializzareComponenti() {
		contentPane = new JPanel(); // nuovo contentPane
		contentPane.setBackground(Color.WHITE); // inizializza colore del
												// contentPane
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // inizializza
															// dimensioni del
														// contentPane

		contenuto = new ContenutoPanel(); // nuovo
											// contenuto

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
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addComponent(menuPanel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_contentPane
										.createParallelGroup(
												Alignment.TRAILING, false)
										.addComponent(logPanel,
												Alignment.LEADING,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(contenuto,
												Alignment.LEADING,
												GroupLayout.DEFAULT_SIZE, 700,
												Short.MAX_VALUE)).addGap(26)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.TRAILING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addComponent(logPanel, GroupLayout.PREFERRED_SIZE, 100,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addComponent(contenuto,
												GroupLayout.DEFAULT_SIZE, 700,
												Short.MAX_VALUE)
										.addComponent(menuPanel,
												GroupLayout.PREFERRED_SIZE,
												536, Short.MAX_VALUE))
						.addContainerGap()));
		// suddivisione
		// in griglia
		logPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { logPanel.txtUser, logPanel.txtPassword,
						logPanel.btnLog, logPanel.btnRegistrati }));
		contentPane.setLayout(gl_contentPane);
		this.setSize(1200, 800); // dimensione di tutta l'applet
		getContenuto().setHost(getCodeBase().getHost());
		
	} // fine costruttore

	/**
	 * inizializza l'applet ed inserisce contentPane in index
	 */
	public void init() {
		 try
	        {
	            java.awt.EventQueue.invokeAndWait(new Runnable()
	            {
	                public void run()
	                {
	                    inizializzareComponenti();
	                    getContentPane().add(contentPane);
	                }
	            });
	        } catch (Exception ex)
	        {
	            ex.printStackTrace();
	        }
		

	}

	public void paint(Graphics g) {
		super.paint(g);
	}

	

	// inizio getters and setters
	
	/**
	 * Getter del pannello di menu
	 * @return menuPanel
	 */
	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	/**
	 * Setter del pannello dei menu
	 * @param menuPanel
	 */
	public void setMenuPanel(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	/** 
	 * Getter del pannello di login
	 * @return logPanel
	 */
	public LogPanel getPanelLog() {
		return logPanel;
	}

	/**
	 * Setter del pannello di login
	 * @param panelLog
	 */
	public void setPanelLog(LogPanel panelLog) {
		this.logPanel = panelLog;
	}

	
	/**
	 * Getter del pannello contenitore
	 * @return contenuto
	 */
	public ContenutoPanel getContenuto() {
		return contenuto;
	}

	/**
	 * Setter del pannello contenitore
	 * @param contenuto
	 */
	public void setContenuto(ContenutoPanel contenuto) {
		this.contenuto = contenuto;
	}
	// fine getters and setters
}
