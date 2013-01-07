package azienda;

import java.awt.EventQueue;

/**
 * Classe Main: esegue il programma e carica il primo
 * pannello, quello di login di dipendenti dell'azienda.
 * @author Gabriele
 * @author Veronica
 * @version 3.0 Jan 3, 2013.
 */
public class Main {
	/**
	 * Main
	 * @param args
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
