package client;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import conexionInterface.Collegare;
import server.DataBase;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Index extends JApplet implements Collegare {

	/**
	 * Dichiarazione delle Variabile degli elementi della finestra
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane; // Panel principale contiene tutto
	public MenuPanel menuAcquista; // Panels contenitori
	public JScrollPane scrollPane;
	public LogPanel panelLog;
	private ContenutoPanel contenuto;

	public Index() {
		getContentPane().setBackground(Color.WHITE);
		// setTitle("Negozio On line");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 491);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(contentPane);

		contenuto = new ContenutoPanel();
		// panelLog
		panelLog = new LogPanel(contenuto);
		panelLog.setBackground(Color.WHITE);
		panelLog.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		// Menu Acquista
		menuAcquista = new MenuPanel(contenuto);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				menuAcquista,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				contenuto,
																				GroupLayout.PREFERRED_SIZE,
																				799,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																panelLog,
																GroupLayout.PREFERRED_SIZE,
																641,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addComponent(panelLog,
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
																menuAcquista,
																GroupLayout.PREFERRED_SIZE,
																452,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		panelLog.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { panelLog.txtUser, panelLog.txtPassword,
						panelLog.btnLog, panelLog.btnRegistrati }));
		contentPane.setLayout(gl_contentPane);

		this.setSize(900, 500);

	}

	public void init() {
		getContentPane().add(contentPane);

	}

	public void paint(Graphics g) {
		super.paint(g);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		BufferedReader in = null;
		PrintStream out = null;
		Socket socket = null;
		String message;

		try {
			// open a socket connection
			socket = new Socket("localhost", 4000);
			// Apre i canali I/O
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream(), true);
			try {
				UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Throwable e) {
				e.printStackTrace();
			}
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Index index = new Index();
						index.setSize(900, 500);
						index.setVisible(true);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			/** Legge dal server */
			message = in.readLine();
			System.out.print("Messaggio Ricevuto : " + message);
			out.close();
			in.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public DataBase collegareDB() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @uml.property name="menuPanel"
	 * @uml.associationEnd inverse="index:client.MenuPanel"
	 * @uml.association name="menu"
	 */
	private MenuPanel menuPanel;

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
		return panelLog;
	}

	/**
	 * Setter of the property <tt>panelLog</tt>
	 * 
	 * @param panelLog
	 *            The panelLog to set.
	 * @uml.property name="panelLog"
	 */
	public void setPanelLog(LogPanel panelLog) {
		this.panelLog = panelLog;
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

}
