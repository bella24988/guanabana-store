package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/** 
 * Classe AnnullaOrdineController: Controller del pannello per annullare l'ordine.
 * Implementa ActionListener
 * @author Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class AnnullaOrdineController implements ActionListener{
	
	/** Pannello per annullare l'ordine */
	private AnnullaOrdinePanel annullaOrdinePanel;

	
	/** Costruttore del controller
	 * @param annullaPanel
	 */
	public AnnullaOrdineController(AnnullaOrdinePanel annullaPanel) {
		super();
		this.annullaOrdinePanel = annullaPanel;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equalsIgnoreCase("Si")){
			ServizioClient servizioClient = new ServizioClient(annullaOrdinePanel.getContenutoPanel().getHost());
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
