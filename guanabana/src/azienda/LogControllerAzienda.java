package azienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import modello.Dipendente;


public class LogControllerAzienda implements ActionListener{
	LogAzienda logAzienda;

	public LogControllerAzienda(LogAzienda logAzienda) {
		this.logAzienda = logAzienda;
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Entra")){
			Dipendente impiegato;
			int id = Integer.parseInt(logAzienda.getTxtUser());
			String psw=String.valueOf(logAzienda.getTxtPassword());
			if(psw.compareTo("")!=0 && logAzienda.getTxtUser().compareTo("")!=0){
				ClientAzienda servizioClientAzienda = new ClientAzienda();
				try {
					impiegato = servizioClientAzienda.logDipendente(id, psw);
					logAzienda.getGestioneOrdine().mostraPanelPrincipale(impiegato);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		}
		
	}
	

}
