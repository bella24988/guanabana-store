package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author  Veronica
 */
public class TuoiOrdiniController implements ActionListener{
	/**
	 * @uml.property  name="tOrdiniPanel"
	 * @uml.associationEnd  
	 */
	private TuoiOrdiniPanel tOrdiniPanel;

	
	public TuoiOrdiniController(TuoiOrdiniPanel tOrdiniPanel) {
		super();
		this.tOrdiniPanel = tOrdiniPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comand = e.getActionCommand().substring(0, 4);
		int indiceArray = Integer.parseInt(e.getActionCommand().substring(4));
		
		
		if (comand.compareTo("Annu")==0){
			tOrdiniPanel.getContenutoPanel().setOrdine(tOrdiniPanel.getOrdini()[indiceArray]);
			tOrdiniPanel.getContenutoPanel().mostraAnnullaOrdine();
		   
		}else if (comand.compareTo("Paga")==0){
			tOrdiniPanel.getContenutoPanel().setOrdine(tOrdiniPanel.getOrdini()[indiceArray]);
			tOrdiniPanel.getContenutoPanel().mostraPagamentoPanel();
		}
		
	}

	/**
	 * @return  the tOrdiniPanel
	 * @uml.property  name="tOrdiniPanel"
	 */
	public TuoiOrdiniPanel gettOrdiniPanel() {
		return tOrdiniPanel;
	}

	/**
	 * @param tOrdiniPanel  the tOrdiniPanel to set
	 * @uml.property  name="tOrdiniPanel"
	 */
	public void settOrdiniPanel(TuoiOrdiniPanel tOrdiniPanel) {
		this.tOrdiniPanel = tOrdiniPanel;
	}
	
	

}
