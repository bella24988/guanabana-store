package azienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import modello.Dipendente;


/**
 * @author  Veronica
 */
public class LogControllerAzienda implements ActionListener, KeyListener{
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
			faLogIn();
			
		}else if (e.getActionCommand().compareTo("Logout")==0){
			sistemaGestioneFinestra.setVisible(false);
			logAzienda.setVisible(true);
			logAzienda.setTxtUser("");
			logAzienda.setTxtPassword("");
		}
		
	}
	
	
	
	private void faLogIn() {
		try {
			int id = Integer.parseInt(logAzienda.getTxtUser());
			String psw=String.valueOf(logAzienda.getTxtPassword());
			if(psw.compareTo("")!=0 && logAzienda.getTxtUser().compareTo("")!=0){
				ClientAzienda servizioClientAzienda = new ClientAzienda();
				try {
					Dipendente impiegato = servizioClientAzienda.logDipendente(id, psw);
					if(impiegato.getNome().compareTo("")!=0){
						setImpiegato(impiegato);
						mostraPanelPrincipale(getImpiegato());
					}else{
						mostraMessaggioErrore("User e password non coincidono");
					}
				} catch (IOException e1) {
					mostraMessaggioErrore("User e password non coincidono");
					e1.printStackTrace();
				}
				
			}
		} catch (Exception e2) {
			mostraMessaggioErrore("Non è un user o password valido");
		}
		
		
	}


	private void mostraMessaggioErrore(String msn) {
		logAzienda.setTxtErrore(msn);
		logAzienda.setTxtPassword("");
		logAzienda.setTxtUser("");
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


	/**
	 * @uml.property  name="sistemaGestioneFinestra"
	 * @uml.associationEnd  inverse="logControllerAzienda:azienda.SistemaGestioneFinestra"
	 * @uml.association  name="mostra"
	 */
	private SistemaGestioneFinestra gestioneFinestra;

	/**
	 * Getter of the property <tt>sistemaGestioneFinestra</tt>
	 * @return  Returns the gestioneFinestra.
	 * @uml.property  name="sistemaGestioneFinestra"
	 */
	public SistemaGestioneFinestra getSistemaGestioneFinestra() {
		return gestioneFinestra;
	}


	/**
	 * Setter of the property <tt>sistemaGestioneFinestra</tt>
	 * @param sistemaGestioneFinestra  The gestioneFinestra to set.
	 * @uml.property  name="sistemaGestioneFinestra"
	 */
	public void setSistemaGestioneFinestra(
			SistemaGestioneFinestra sistemaGestioneFinestra) {
		gestioneFinestra = sistemaGestioneFinestra;
	}


	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_ENTER) {
        	faLogIn();           
        }
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
