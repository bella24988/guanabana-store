package azienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import modello.Dipendente;


/**
 * @author  Veronica
 */
public class LogControllerAzienda implements ActionListener{
	/**
	 * @uml.property  name="logAzienda"
	 * @uml.associationEnd  
	 */
	private LogPanel logAzienda;
	private Dipendente impiegato;
	private SistemaGestioneFinestra sistemaGestioneFinestra;

	public LogControllerAzienda(LogPanel logAzienda) {
		this.logAzienda = logAzienda;
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Entra")){
			int id = Integer.parseInt(logAzienda.getTxtUser());
			String psw=String.valueOf(logAzienda.getTxtPassword());
			if(psw.compareTo("")!=0 && logAzienda.getTxtUser().compareTo("")!=0){
				ClientAzienda servizioClientAzienda = new ClientAzienda();
				try {
					setImpiegato(servizioClientAzienda.logDipendente(id, psw));
					mostraPanelPrincipale(getImpiegato());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		}else if (e.getActionCommand().compareTo("Logout")==0){
			sistemaGestioneFinestra.setVisible(false);
			logAzienda.setVisible(true);
			logAzienda.setTxtUser("");
			logAzienda.setTxtPassword("");
		}
		
	}
	
	/**
	 * @param impiegato
	 */
	public void mostraPanelPrincipale(Dipendente impiegato) {
		logAzienda.setVisible(false);
		sistemaGestioneFinestra = new SistemaGestioneFinestra(impiegato, this);
		sistemaGestioneFinestra.setVisible(true);
	}


	/**
	 * @return the impiegato
	 */
	public Dipendente getImpiegato() {
		return impiegato;
	}


	/**
	 * @param impiegato the impiegato to set
	 */
	public void setImpiegato(Dipendente impiegato) {
		this.impiegato = impiegato;
	}

}
