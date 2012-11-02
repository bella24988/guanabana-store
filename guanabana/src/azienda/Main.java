package azienda;

import java.awt.EventQueue;

public class Main {

	/**
	 * @param args
	 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogPanel logPanel = new LogPanel();
					logPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
