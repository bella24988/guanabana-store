package azienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import modello.Ordine;

/**
 * @author  Veronica
 */
public class MagazinoController implements ActionListener{
	/**
	 * @uml.property  name="panelPrincipalGestione"
	 * @uml.associationEnd  
	 */
	private MagazinoPanel panelPrincipalGestione;
	
	

	public MagazinoController(
			MagazinoPanel panelPrincipalGestione) {
		super();
		this.setPanelPrincipalGestione(panelPrincipalGestione);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getActionCommand().substring(0, 4).compareTo("Sped")==0){
			int indiceArray = Integer.parseInt(e.getActionCommand().substring(4));
			Ordine ordine = panelPrincipalGestione.getOrdini()[indiceArray];
			ClientAzienda servizioClientAzienda = new ClientAzienda();
			try {
				servizioClientAzienda.aggiornaStatoOrdine("SPEDITO", ordine.getNumeroOrdine());
				panelPrincipalGestione.getGestioneOrdine().refreshOrdini();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		   
		}else if (e.getActionCommand().compareTo("Logout")==0){
			panelPrincipalGestione.getGestioneOrdine().logOut();
		}else if (e.getActionCommand().compareTo("Aggiorna")==0){
			panelPrincipalGestione.getGestioneOrdine().refreshOrdini();
		}
		
	}



	/**
	 * @return  the panelPrincipalGestione
	 * @uml.property  name="panelPrincipalGestione"
	 */
	public MagazinoPanel getPanelPrincipalGestione() {
		return panelPrincipalGestione;
	}



	/**
	 * @param panelPrincipalGestione  the panelPrincipalGestione to set
	 * @uml.property  name="panelPrincipalGestione"
	 */
	public void setPanelPrincipalGestione(MagazinoPanel panelPrincipalGestione) {
		this.panelPrincipalGestione = panelPrincipalGestione;
	}

}
