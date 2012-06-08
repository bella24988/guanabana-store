package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import server.DataBase;

public class ModelloController implements ActionListener {
	private String nome;
	private String tipo;
	private DataBase db;
	private ModelloView modView;

	public ModelloController(String nome, ModelloView modView) {
		this.nome = nome;
		this.setModView(modView);
		try {
			db = new DataBase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			if (nome.startsWith("LAP")) {
				tipo = "lap";
			} else if (nome.startsWith("DES")) {
				tipo = "des";
			} else if (nome.startsWith("SER")) {
				tipo = "ser";
			}
			int rows = 0;
			int maxCol = 3;
			rows = db.countComponentiModello(tipo);
			String[][] components = new String[rows][maxCol];
			components = db.getComponentiModello(tipo);

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
