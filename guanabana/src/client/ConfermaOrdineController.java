package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfermaOrdineController implements ActionListener{

	private ConfermaOrdinePanel confermaOrdinePanel;
	
	public ConfermaOrdineController(ConfermaOrdinePanel confermaOrdinePanel) {
		this.confermaOrdinePanel = confermaOrdinePanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Continua con il pagamento")){
			confermaOrdinePanel.getContenutoPanel().aggiungePagamentoPanel(confermaOrdinePanel);
			
		}
		
	}

	/**
	 * @return the confermaOrdinePanel
	 */
	public ConfermaOrdinePanel getConfermaOrdinePanel() {
		return confermaOrdinePanel;
	}

	/**
	 * @param confermaOrdinePanel the confermaOrdinePanel to set
	 */
	public void setConfermaOrdinePanel(ConfermaOrdinePanel confermaOrdinePanel) {
		this.confermaOrdinePanel = confermaOrdinePanel;
	}

}
