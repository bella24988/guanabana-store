package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import modello.Configurazione;

/** 
 * Classe ConfigPanel: Pannello che consente di configurare il device scelto
 * @author Gabriele
 * @author Veronica
 * @version 3.0 Jan 3, 2013.
 */
public class ConfigPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/** Controller del pannello del preventivo */
	private PreventivoController preventivoController;
	
	/** Configurazione */
	private Configurazione configurazione;

	
	/** Tipo di computer */
	private int compTipo;
	
	/** 
	 * Doppi array contenente i tipi di componenti configurabili rispettivamente per laptop, desktop e server 
	 */
	private static final String[][] tipoComponenti = {
			{ "RAM", "CPU", "HD0", "GPU", "DVD", "WAR" },
			{ "RAM", "CPU", "MOU", "HD0", "HDD", "GPU", "DVD", "WAR", "KEY",
					"MON" },
			{ "RAM", "CPU", "MLC", "HD0", "HDD", "HDD", "HDD", "DVD", "PCI",
					"WAR" } };
	private static final String[][] labels = {
			{ "Memoria RAM:", "Processore:", "Hard Disk (obbligatorio):",
					"Scheda Grafica:", "Unita' ottica:", "Garanzia:" },
			{ "Memoria RAM:", "Processore:", "Mouse:",
					"Hard Disk (obbligatorio):", "Hard Disk (opzionale):",
					"Scheda Grafica:", "Unita' ottica:", "Garanzia:",
					"Tastiera:", "Monitor:" },
			{ "Memoria RAM:", "Processore:", "Multilevel Cell:",
					"Hard Disk (obbligatorio):", "Hard Disk (opzionale 1):",
					"Hard Disk (opzionale2):", "Hard Disk (opzionale 3):",
					"Unita' ottica:", "Scheda PCI:", "Garanzia:" } };

	private static final String[] lblComp = { "Laptop", "Desktop", "Server" };
	

	/** Costruttore del pannello di configurazione
	 * @param config
	 * @param preventivoController
	 * @param computerType
	 */
	public ConfigPanel(Configurazione config,
			PreventivoController preventivoController, int computerType) {
		super();
		this.setCompTipo(computerType);
		this.setConfigurazione(config);
		this.setPreventivoController(preventivoController);
		int ultimo = 2;

		// Definisco un array di configurazione
		// configurazione = new Configurazione[maxElementiConfig[computerType]];

		// Definizione generale della finestra
		setBackground(Color.WHITE); // Colore di sfondo

		// Griglia generale
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 147, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 25, 25, 25, 25, 25, 25,
				25, 0, 25 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// window style
		JLabel lblTitle = new JLabel("Acquista " + lblComp[computerType]
				+ ": scegli configurazione");
		lblTitle.setForeground(new Color(0, 153, 0));
		lblTitle.setFont(new Font("Toledo", Font.BOLD, 14));
		GridBagConstraints gbc_lbl = new GridBagConstraints();
		gbc_lbl.gridwidth = 2;
		gbc_lbl.insets = new Insets(0, 0, 5, 0);
		gbc_lbl.gridx = 0;
		gbc_lbl.gridy = 0;
		add(lblTitle, gbc_lbl);

		System.out.println("Lunghezza componenti"
				+ tipoComponenti[computerType].length);
		@SuppressWarnings("unused")
		ButtonGroup[] group = new ButtonGroup[tipoComponenti[computerType].length];
		for (int indiceComponenti = 0; indiceComponenti < tipoComponenti[computerType].length; indiceComponenti++) {

			JLabel lblComponents = new JLabel(
					labels[computerType][indiceComponenti]);
			lblComponents.setFont(new Font("Toledo", Font.BOLD, 11));
			GridBagConstraints gbc_lblComponents = new GridBagConstraints();
			gbc_lblComponents.anchor = GridBagConstraints.EAST;
			gbc_lblComponents.insets = new Insets(0, 0, 5, 5);
			gbc_lblComponents.gridx = 0;
			gbc_lblComponents.gridy = ultimo;
			add(lblComponents, gbc_lblComponents);

			// Radio Button
			ButtonGroup groupComponents = new ButtonGroup();
			JRadioButton[] rdbtnComponents = new JRadioButton[config
					.getComponenti().length];
			for (int i = 0; i < configurazione.getComponenti().length; i++) {
				if (configurazione.getComponenti()[i].getTipo().compareTo(
						tipoComponenti[computerType][indiceComponenti]) == 0) {
					// Setta la configurazione di default
					rdbtnComponents[i] = configButtons(rdbtnComponents[i],
							indiceComponenti, i, configurazione);
					rdbtnComponents[i]
							.setActionCommand(tipoComponenti[computerType][indiceComponenti]
									+ i);

					// Griglia, nettamente grafico
					GridBagConstraints grid_radio = new GridBagConstraints();
					grid_radio.anchor = GridBagConstraints.WEST;
					grid_radio.insets = new Insets(0, 0, 5, 5);
					grid_radio.gridx = 1;
					grid_radio.gridy = ultimo++;
					add(rdbtnComponents[i], grid_radio);

					// Ragruppamento dei buttons
					groupComponents.add(rdbtnComponents[i]);

					// Controller
					rdbtnComponents[i].addActionListener(preventivoController);

				}
			}

			ultimo++;
		}

	}

	/** Metodo che consente di mostrare il prezzo corretto di un componente e di configurare il radio button corrispondente
	 * @param rdbtn				Radio button da configurare
	 * @param indexTipoComp		Tipo di computer
	 * @param indexComp
	 * @param conf				Configurazione
	 * @return rdbtn			Radio button configurato
	 */
	private JRadioButton configButtons(JRadioButton rdbtn, int indexTipoComp,
			int indexComp, Configurazione conf) {

		if (conf.getComponenti()[indexComp].isStandard() == true) {
			conf.getComponenti()[indexComp].setPrezzo(0);
			conf.setConfigurazioneScelta(indexComp, indexTipoComp);
			rdbtn = new JRadioButton(conf.getComponenti()[indexComp].getNome()
					+ "\n Prezzo: "
					+ conf.getComponenti()[indexComp].getPrezzo());
			rdbtn.setSelected(true);
		} else {
			rdbtn = new JRadioButton(conf.getComponenti()[indexComp].getNome()
					+ "\n Prezzo: "
					+ conf.getComponenti()[indexComp].getPrezzo());
		}
		rdbtn.setBackground(Color.WHITE);
		rdbtn.setFont(new Font("Toledo", Font.PLAIN, 11));

		return rdbtn;
	}

	/** Restituisce il controller del preventivo
	 * @return preventivoController
	 */
	public PreventivoController getPreventivoController() {
		return preventivoController;
	}

	/** Setter del controller del preventivo
	 * @param preventivoController		Controller da settare
	 */
	public void setPreventivoController(
			PreventivoController preventivoController) {
		this.preventivoController = preventivoController;
	}

	/** Restituisce la configurazione scelta
	 * @return configurazione
	 */
	public Configurazione getConfigurazione() {
		return configurazione;
	}

	/** Setter della configurazione
	 * @param configurazione		Configurazione da settare
	 */
	public void setConfigurazione(Configurazione configurazione) {
		this.configurazione = configurazione;
	}

	/** Restituisce il tipo di computer
	 * @return compTipo
	 */
	public int getCompTipo() {
		return compTipo;
	}

	/** Setter del tipo di computer
	 * @param compTipo		Tipo di computer da settare
	 */
	public void setCompTipo(int compTipo) {
		this.compTipo = compTipo;
	}

	/** Restituisce il tipo di componenti
	 * @return tipoComponenti
	 */
	public static String[][] getTipocomponenti() {
		return tipoComponenti;
	}

}
