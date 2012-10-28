package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author  Veronica
 */
public class AnnullaOrdineController implements ActionListener{
	
	/**
	 * @uml.property  name="annullaOrdinePanel"
	 * @uml.associationEnd  
	 */
	private AnnullaOrdinePanel annullaOrdinePanel;

	
	public AnnullaOrdineController(AnnullaOrdinePanel aPanel) {
		super();
		this.annullaOrdinePanel = aPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equalsIgnoreCase("Si")){
			Client servizioClient = new Client();
			try {
				servizioClient.aggiornaOrdine(annullaOrdinePanel.getOrdine().getNumeroOrdine(),"ANNULLATO");
				annullaOrdinePanel.getContenutoPanel().mostraRingraziamento();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equalsIgnoreCase("No")){
			annullaOrdinePanel.getContenutoPanel().mostraRingraziamento();
		}
	}

	
}
