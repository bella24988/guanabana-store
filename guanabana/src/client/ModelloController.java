package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModelloController implements ActionListener {
	private String nome;
	private String tipo;
	private ModelloView modView;

	public ModelloController(String nome, ModelloView modView) {
		this.nome = nome;
		this.setModView(modView);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

			if (nome.startsWith("LAP")) {
				tipo = "lap";
			} else if (nome.startsWith("DES")) {
				tipo = "des";
			} else if (nome.startsWith("SER")) {
				tipo = "ser";
			}
		/*	int rows = 0;
			int maxCol = 3;
			rows = db.countComponentiModello(tipo);
			String[][] components = new String[rows][maxCol];
			components = db.getComponentiModello(tipo);*/

	}

	/**
	 * @return the modView
	 */
	public ModelloView getModView() {
		return modView;
	}

	/**
	 * @param modView
	 *            the modView to set
	 */
	public void setModView(ModelloView modView) {
		this.modView = modView;
	}

}
