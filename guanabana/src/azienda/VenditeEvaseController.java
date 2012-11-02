package azienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modello.Ordine;

public class VenditeEvaseController implements ActionListener{
	
	SistemaGestioneFinestra sistemaGestioneFinestra;
	VenditeEvasePanel veEvasePanel;
	
	

	public VenditeEvaseController(
			SistemaGestioneFinestra sistemaGestioneFinestra) {
		super();
		this.sistemaGestioneFinestra = sistemaGestioneFinestra;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().compareTo("Ordini evase")==0){
			refreshFinestra("SPEDITO", "ANNULLATO");
		}
		
	}
	
	private void refreshFinestra(String tipo, String tipo1){
		sistemaGestioneFinestra.pulisceSchermo();
		Ordine[] ordini1 = sistemaGestioneFinestra.enlistaOrdini(tipo);
		Ordine[] ordini2 = sistemaGestioneFinestra.enlistaOrdini(tipo1);
		Ordine[] ordini = new Ordine[ordini1.length+ordini2.length];
		
		for (int i = 0; i < ordini1.length; i++) {
			ordini[i]=ordini1[i];
		}
		int j=0;
		for (int i = ordini1.length; i < ordini.length; i++) {
			ordini[i]=ordini2[j];
			j++;
		}
		
		veEvasePanel = new VenditeEvasePanel(ordini, this);
		sistemaGestioneFinestra.getContenutoPanel().add(veEvasePanel);
		veEvasePanel.setVisible(true);
		sistemaGestioneFinestra.Refresh();
	}

}
