package azienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import modello.Ordine;

public class VenditeEvaseController implements ActionListener, ItemListener{
	
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



	@Override
	public void itemStateChanged(ItemEvent e) {
		try {
			ClientAzienda clientAzienda = new ClientAzienda();
			JCheckBox btnConferma = (JCheckBox) e.getSource();
			if (e.getStateChange() == ItemEvent.SELECTED) {
				veEvasePanel.getOrdini()[btnConferma.getMnemonic()].getPagamento().setConfermato(true);
				clientAzienda.confermarePagamento(true, veEvasePanel
						.getOrdini()[btnConferma.getMnemonic()]
						.getPagamento().getNumPagamento());
				veEvasePanel.disabilitaConferma(btnConferma.getMnemonic());
			} else {
				veEvasePanel.getOrdini()[btnConferma.getMnemonic()].getPagamento().setConfermato(false);
				clientAzienda.confermarePagamento(false, veEvasePanel
						.getOrdini()[btnConferma.getMnemonic()]
						.getNumeroOrdine());
			}
		} catch (Exception e2) {
		}
		
	}

}
