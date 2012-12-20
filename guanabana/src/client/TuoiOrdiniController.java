package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.itextpdf.text.DocumentException;

import azienda.ClientAzienda;

import modello.Fattura;
import modello.Ordine;


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
