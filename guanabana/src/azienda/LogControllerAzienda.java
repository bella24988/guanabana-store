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


	/**
	 * @uml.property  name="logPanel"
	 * @uml.associationEnd  inverse="logControllerAzienda:azienda.LogPanel"
	 */
	private LogPanel logPanel;

	/**
	 * Getter of the property <tt>logPanel</tt>
	 * @return  Returns the logPanel.
	 * @uml.property  name="logPanel"
	 */
	public LogPanel getLogPanel() {
		return logPanel;
	}


	/**
	 * Setter of the property <tt>logPanel</tt>
	 * @param logPanel  The logPanel to set.
	 * @uml.property  name="logPanel"
	 */
	public void setLogPanel(LogPanel logPanel) {
		this.logPanel = logPanel;
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

}
