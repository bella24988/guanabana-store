package client;

import javax.swing.JPanel;

import java.awt.Color;

public class ContenutoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private RegistratiView registratiView;
	/**
	 * @uml.property name="modelloView"
	 * @uml.associationEnd inverse="contenutoPanel:client.ModelloView"
	 * @uml.association name="mostra"
	 */
	private ModelloView modelloView;

	public ContenutoPanel() {
		super();
		setBackground(new Color(204, 255, 153));
		setForeground(new Color(0, 0, 0));
		registratiView = new RegistratiView(this);
		registratiView.setBackground(new Color(204, 255, 153));
		add(registratiView);
		registratiView.setVisible(false);
		modelloView = new ModelloView();
		add(modelloView);
	}

	public RegistratiView getRegistratiView() {
		return registratiView;
	}

	public void setRegistratiView(RegistratiView registratiView) {
		this.registratiView = registratiView;
	}

	public void mostraFormularioRegistrati(LogPanel panel) {
		registratiView.setVisible(true);
		registratiView.conoscePanel(panel);
		modelloView.setVisible(false);
	}

	public void nascondeFormularioRegistrati() {
		registratiView.setVisible(false);
		nascondeModelli();
	}

	public void mostraModelli(int num, String[] nome, float[] prezzo,
			String tipo) {
		nascondeFormularioRegistrati();
		modelloView = new ModelloView();
		add(modelloView);
		modelloView.mostraButtons(num, nome, prezzo, tipo);
		modelloView.setVisible(true);
	}

	public void nascondeModelli() {
		modelloView.setVisible(false);
	}

	/**
	 * @uml.property name="registratiController"
	 * @uml.associationEnd inverse="contenutoPanel:client.RegistratiController"
	 * @uml.association name="modifica"
	 */
	private RegistratiController registratiController;

	/**
	 * Getter of the property <tt>registratiController</tt>
	 * 
	 * @return Returns the registratiController.
	 * @uml.property name="registratiController"
	 */
	public RegistratiController getRegistratiController() {
		return registratiController;
	}

	/**
	 * Setter of the property <tt>registratiController</tt>
	 * 
	 * @param registratiController
	 *            The registratiController to set.
	 * @uml.property name="registratiController"
	 */
	public void setRegistratiController(
			RegistratiController registratiController) {
		this.registratiController = registratiController;
	}

	/**
	 * @return the modelloView
	 */
	public ModelloView getModelloView() {
		return modelloView;
	}

	/**
	 * @param modelloView
	 *            the modelloView to set
	 */
	public void setModelloView(ModelloView modelloView) {
		this.modelloView = modelloView;
	}

}
