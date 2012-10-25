package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TuoiOrdiniController implements ActionListener{
	private TuoiOrdiniPanel tOrdiniPanel;

	
	public TuoiOrdiniController(TuoiOrdiniPanel tOrdiniPanel) {
		super();
		this.tOrdiniPanel = tOrdiniPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comand = e.getActionCommand().substring(0, 4);
		int indiceArray = Integer.parseInt(e.getActionCommand().substring(4));
		tOrdiniPanel.getContenutoPanel().setOrdine(tOrdiniPanel.getOrdini()[indiceArray]);
		
		if (comand.compareTo("Annu")==0){
			//Client servizioClient = new Client();	
			tOrdiniPanel.getContenutoPanel().mostraAnnullaOrdine();
		   
		}else if (comand.compareTo("Paga")==0){
			tOrdiniPanel.getContenutoPanel().mostraPagamentoPanel();
		}
		
	}

	/**
	 * @return the tOrdiniPanel
	 */
	public TuoiOrdiniPanel gettOrdiniPanel() {
		return tOrdiniPanel;
	}

	/**
	 * @param tOrdiniPanel the tOrdiniPanel to set
	 */
	public void settOrdiniPanel(TuoiOrdiniPanel tOrdiniPanel) {
		this.tOrdiniPanel = tOrdiniPanel;
	}
	
	

}
