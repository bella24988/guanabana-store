package client;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import client.MenuController;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MenuPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btnLaptop; // Buttons
	public JButton btnServer;
	public JButton btnDesktop;
	private ContenutoPanel contenuto;
	private MenuController menuController;

	/**
	 * Create the panel.
	 */
	public MenuPanel(ContenutoPanel contenuto) {
		setBackground(Color.WHITE);
		this.setContenuto(contenuto);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 70, 70, 70, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		btnLaptop = new JButton("Acquista Laptop");
		btnLaptop.setForeground(new Color(0, 0, 0));
		btnLaptop.setBackground(new Color(154, 205, 50));
		GridBagConstraints gbc_btnAcquistaLaptop = new GridBagConstraints();
		gbc_btnAcquistaLaptop.fill = GridBagConstraints.BOTH;
		gbc_btnAcquistaLaptop.insets = new Insets(0, 0, 5, 0);
		gbc_btnAcquistaLaptop.gridx = 0;
		gbc_btnAcquistaLaptop.gridy = 0;
		add(btnLaptop, gbc_btnAcquistaLaptop);

		btnDesktop = new JButton("Acquista Desktop");
		btnDesktop.setForeground(new Color(0, 0, 0));
		btnDesktop.setBackground(new Color(154, 205, 50));
		GridBagConstraints gbc_btnAcquistaDesktop = new GridBagConstraints();
		gbc_btnAcquistaDesktop.fill = GridBagConstraints.BOTH;
		gbc_btnAcquistaDesktop.insets = new Insets(0, 0, 5, 0);
		gbc_btnAcquistaDesktop.gridx = 0;
		gbc_btnAcquistaDesktop.gridy = 1;
		add(btnDesktop, gbc_btnAcquistaDesktop);

		btnServer = new JButton("Acquista Server");
		btnServer.setForeground(new Color(0, 0, 0));
		btnServer.setBackground(new Color(154, 205, 50));
		GridBagConstraints gbc_btnAcquistaServer = new GridBagConstraints();
		gbc_btnAcquistaServer.fill = GridBagConstraints.BOTH;
		gbc_btnAcquistaServer.gridx = 0;
		gbc_btnAcquistaServer.gridy = 2;
		add(btnServer, gbc_btnAcquistaServer);

		// CONTROLLERS
		menuController = new MenuController(this, contenuto);
		btnLaptop.addActionListener(menuController);
		btnDesktop.addActionListener(menuController);
		btnServer.addActionListener(menuController);
	}

	/**
	 * @return the contenuto
	 */
	public ContenutoPanel getContenuto() {
		return contenuto;
	}

	/**
	 * @param contenuto
	 *            the contenuto to set
	 */
	public void setContenuto(ContenutoPanel contenuto) {
		this.contenuto = contenuto;
	}

	/**
	 * @uml.property  name="menuController1"
	 * @uml.associationEnd  inverse="menuPanel:client.MenuController"
	 * @uml.association  name="controllato"
	 */
	private MenuController menuController1;

	/**
	 * Getter of the property <tt>menuController1</tt>
	 * @return  Returns the menuController1.
	 * @uml.property  name="menuController1"
	 */
	public MenuController getMenuController1() {
		return menuController1;
	}

	/**
	 * Setter of the property <tt>menuController1</tt>
	 * @param menuController1  The menuController1 to set.
	 * @uml.property  name="menuController1"
	 */
	public void setMenuController1(MenuController menuController1) {
		this.menuController1 = menuController1;
	}

}
