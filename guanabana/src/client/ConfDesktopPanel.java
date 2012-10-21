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

import modello.Componente;
import modello.Configurazione;

public class ConfDesktopPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Componente[] componenti;
	private PreventivoController preventivoController;
	private Configurazione[] configurazione;
	static int maxElementiConfig = 10;
	private static String[] tipoComponenti = {"RAM", "CPU", "MOU", "HD1", "HD2", "GPU", "DVD", "WAR", "KEY", "MON"};
	private static String[] labels = {"Memoria RAM:", "Processore:", "Mouse:", "Hard Disk (obbligatorio):", "Hard Disk (opzionale):", "Scheda Grafica:", "Unitˆ ottica:", "Garanzia:", "Tastiera:", "Monitor:"};
	
	public ConfDesktopPanel(Componente[] componenti, String[] configStandard,
			PreventivoController preventivoController) {
		super();
		this.setComponenti(componenti);
		this.setPreventivoController(preventivoController);

		for (int k=0; k<configStandard.length;k++){
			System.out.print("Conf "+ k + " - "+configStandard[k]);
		}
		// Definisco un array di configurazione
		configurazione = new Configurazione[maxElementiConfig];

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

		// Il tipo della finestra. Orientation Info
		JLabel lblServer = new JLabel("Acquista Desktop: scegli configurazione");
		lblServer.setForeground(new Color(0, 153, 0));
		lblServer.setFont(new Font("Toledo", Font.BOLD, 14));
		GridBagConstraints gbc_lblServer = new GridBagConstraints();
		gbc_lblServer.gridwidth = 2;
		gbc_lblServer.insets = new Insets(0, 0, 5, 0);
		gbc_lblServer.gridx = 0;
		gbc_lblServer.gridy = 0;
		add(lblServer, gbc_lblServer);
		int ultimo = 2;
		System.out.println("Lunghezza componenti" + tipoComponenti.length);
		ButtonGroup[] group = new ButtonGroup[tipoComponenti.length];
		for (int indiceComponenti=0; indiceComponenti<tipoComponenti.length; indiceComponenti++){
			JLabel lblComponenti = new JLabel(labels[indiceComponenti]); //Definisce nome dell'etichetta
			lblComponenti.setFont(new Font("Toledo", Font.BOLD, 11));
			GridBagConstraints griglia = new GridBagConstraints();
			griglia.anchor = GridBagConstraints.EAST;
			griglia.insets = new Insets(0, 0, 5, 5);
			griglia.gridx = 0;
			griglia.gridy = ultimo;
			add(lblComponenti, griglia);
			// Gruppi di Radio Button 
			int indiceGroupConf;
			int max;
			max=contaComponentiGruppo(tipoComponenti[indiceComponenti], componenti);
			System.out.println("conta componenti" + max );
			group[indiceComponenti] = new ButtonGroup();
			JRadioButton[] rdbtnGroup = new JRadioButton[max];
			for(int k=0; k<tipoComponenti.length; k++){
			for (indiceGroupConf = 0; indiceGroupConf < max; indiceGroupConf++) {
				
					System.out.println("PROVA IF "+componenti[indiceGroupConf].getTipo() +" ==== "+ tipoComponenti[k]);
					if (componenti[indiceGroupConf].getTipo().compareTo(tipoComponenti[k]) == 0) {
					
						// Setta la configurazione di default
						rdbtnGroup[indiceGroupConf] = configButtons(rdbtnGroup[indiceGroupConf], componenti[indiceGroupConf],
							configStandard[k]);
						System.out.println("Configurazione "+ tipoComponenti[indiceComponenti] + configStandard[indiceComponenti]);
						configurazione[indiceComponenti] = new Configurazione();
						getConfigurazione()[indiceComponenti].setCodice(configStandard[indiceComponenti]);
						getConfigurazione()[indiceComponenti].setPrezzo(componenti[indiceGroupConf].getPrezzo());
						rdbtnGroup[indiceGroupConf].setActionCommand(tipoComponenti[indiceComponenti] + indiceGroupConf);
	
						// Griglia, nettamente grafico
						GridBagConstraints grigliaGruppo = new GridBagConstraints();
						grigliaGruppo.insets = new Insets(0, 0, 5, 5);
						grigliaGruppo.gridx = 1;
						grigliaGruppo.gridy = ultimo++;
						add(rdbtnGroup[indiceGroupConf], grigliaGruppo);
	
						// Ragruppamento dei buttons
						group[indiceComponenti].add(rdbtnGroup[indiceGroupConf]);
	
						// Controller
						rdbtnGroup[indiceGroupConf].addActionListener(preventivoController);
					}
				}
		}
	
			ultimo++;
		}
		

	}
	private JRadioButton configButtons(JRadioButton rdbtn,
			Componente componente, String configStandard) {
		System.out.println("configurazionestandard "+ configStandard + "getcodice " + componente.getCodice());
		if (configStandard.compareTo(componente.getCodice()) == 0) {
			componente.setPrezzo(0);
			rdbtn = new JRadioButton(componente.getNome() + "\n Prezzo: "
					+ componente.getPrezzo());
			rdbtn.setSelected(true);
			System.out.println("prova in configButtons" + componente.getNome() + "\n Prezzo: "
					+ componente.getPrezzo());
		} else {
			rdbtn = new JRadioButton(componente.getNome() + "\n Prezzo: "
					+ componente.getPrezzo());
		}
		rdbtn.setBackground(Color.WHITE);
		rdbtn.setFont(new Font("Toledo", Font.PLAIN, 11));

		return rdbtn;
	}
	private int contaComponentiGruppo(String tipo, Componente[] componenti ){
		int i, num=0;
		for(i=0; i<componenti.length; i++){
			if (componenti[i].getTipo().compareTo(tipo)==0) {
				num++;
			}
			
		}
		return num;
		
	}
	public Componente[] getComponenti() {
		return componenti;
	}
	public void setComponenti(Componente[] componenti) {
		this.componenti = componenti;
	}
	public PreventivoController getPreventivoController() {
		return preventivoController;
	}
	public void setPreventivoController(PreventivoController preventivoController) {
		this.preventivoController = preventivoController;
	}
	public Configurazione[] getConfigurazione() {
		return configurazione;
	}
	public void setConfigurazione(Configurazione[] configurazione) {
		this.configurazione = configurazione;
	}
	
	
	

}
