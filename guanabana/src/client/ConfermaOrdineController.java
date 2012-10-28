package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author  Veronica
 */
public class ConfermaOrdineController implements ActionListener{

	/**
	 * @uml.property  name="confermaOrdinePanel"
	 * @uml.associationEnd  
	 */
	private ConfermaOrdinePanel confermaOrdinePanel;
	
	
	public ConfermaOrdineController(ConfermaOrdinePanel confermaOrdinePanel) {
		this.confermaOrdinePanel = confermaOrdinePanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Continua con il pagamento")){
			//confermaOrdinePanel.getContenutoPanel().getComputer().setConfigurazioneScelta(confermaOrdinePanel.getConfigurazione());
			confermaOrdinePanel.getContenutoPanel().aggiungePagamentoPanel(confermaOrdinePanel, confermaOrdinePanel.getPrezzoTotale());
		}
	}

	/**
	 * @return  the confermaOrdinePanel
	 * @uml.property  name="confermaOrdinePanel"
	 */
	public ConfermaOrdinePanel getConfermaOrdinePanel() {
		return confermaOrdinePanel;
	}

	/**
	 * @param confermaOrdinePanel  the confermaOrdinePanel to set
	 * @uml.property  name="confermaOrdinePanel"
	 */
	public void setConfermaOrdinePanel(ConfermaOrdinePanel confermaOrdinePanel) {
		this.confermaOrdinePanel = confermaOrdinePanel;
	}

}
