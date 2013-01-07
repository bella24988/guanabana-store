package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import com.itextpdf.text.DocumentException;

import azienda.ClientAzienda;

import modello.Fattura;
import modello.Ordine;


/**
 * Classe TuoiOrdiniController: Controller del pannello "I tuoi ordini".
 * Implementa ActionListener.
 * @author  Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class TuoiOrdiniController implements ActionListener{
	/**
	 * Dichiarazione delle variabili
	 */
	private TuoiOrdiniPanel tOrdiniPanel;

	/**
	 * Costruttore del controller
	 * @param tOrdiniPanel
	 */
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
		}else if (comand.compareTo("Fatt")==0){
			Ordine ordine = tOrdiniPanel.getOrdini()[indiceArray];
			ClientAzienda servizioClientAzienda = new ClientAzienda();
			Fattura fattura = null;
			try {
				fattura = servizioClientAzienda.cercaFattura(ordine);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String file = System.getProperty("user.home")+"/FATTURA_"+ordine.getNumeroOrdine()+".pdf";
			try {
				fattura.generareFattura(file);
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	/**
	 * Getter of tOrdiniPanel
	 * @return tOrdiniPanel
	 */
	public TuoiOrdiniPanel gettOrdiniPanel() {
		return tOrdiniPanel;
	}

	/**
	 * Setter of tOrdiniPanel
	 * @param tOrdiniPanel
	 */
	public void settOrdiniPanel(TuoiOrdiniPanel tOrdiniPanel) {
		this.tOrdiniPanel = tOrdiniPanel;
	}

}
