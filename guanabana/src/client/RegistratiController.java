package client;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import server.Cliente;
import client.ContenutoPanel;
import client.LogPanel;
import client.RegistratiView;

public class RegistratiController implements ActionListener{
	
	LogPanel logpanel;
	ContenutoPanel contenuto;
	RegistratiView registrati;
	Cliente cliente;
	
	public RegistratiController(RegistratiView registrati){
		this.setRegistrati(registrati);
	}

	public RegistratiController(LogPanel logpanel, ContenutoPanel contenuto) {
		super();
		this.setLogpanel(logpanel);
		this.setContenuto(contenuto);
	}



	@SuppressWarnings("unused")
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Registrati")){
			contenuto.mostraFormularioRegistrati(logpanel);
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Annulla")){
			registrati.dehabilitaRegistrati();
			registrati.inizializza();
		}
		if (e.getActionCommand().equalsIgnoreCase("Conferma Registrazione")){
			registrati.togliMessaggio();
			if(ciSonoCampiVuoti(registrati)==false){
				
				if ( passwordUguali(String.valueOf(registrati.getTxtPassword()),String.valueOf(registrati.getTxtPasswordConferma())) == true ){
										
					String indirizzo = "Via: "+registrati.getTxtVia()+" C.A.P. "+registrati.getTxtCap()+". "+
										registrati.getTxtCitta()+". Provincia: "+registrati.getTxtProvincia()+
										". "+registrati.getTxtStato();
					
					Client client = new Client();
					Cliente cliente;
					try {
						try {
							cliente=client.registreNuovoCliente(registrati.getTxtCf(),registrati.getTxtNome(),registrati.getTxtCognome(),
									registrati.getTxtEmail(),indirizzo,registrati.getTxtTelefono(),registrati.getTxtPassword());
							if(client!=null)registrati.setTxtNome(cliente.getNome()+" "+cliente.getCognome());
							else registrati.mostraMessaggio("Errore al registrarsi");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
						registrati.mostraMessaggio("Errore con il server");
					}					
					registrati.ocultaFinestra();
				
				}else{
					registrati.mostraMessaggio("Le password non coincidono");
				}
			}else{
				registrati.mostraMessaggio("Si devono compilare tutti campi");
			}
			
		}
			
	}
	
	
	private boolean passwordUguali(String psw1, String psw2){
		
		if (psw2.compareTo(psw1)!=0){
			return false;
		}else {
			return true;
		}
	//	return true;
		
	}
	
	private boolean ciSonoCampiVuoti(RegistratiView r){
				
		if (r.getTxtCf().compareTo("")!=0){
			if (r.getTxtNome().compareTo("")!=0){
				if(r.getTxtCognome().compareTo("")!=0){
					if(r.getTxtEmail().compareTo("")!=0){
						if(r.getTxtTelefono().compareTo("")!=0){
							if(r.getTxtPassword().compareTo("")!=0){
								if(r.getTxtPasswordConferma().compareTo("")!=0){
									if(r.getTxtVia().compareTo("")!=0){
										if(r.getTxtCap().compareTo("")!=0){
											if(r.getTxtCitta().compareTo("")!=0){
												if(r.getTxtStato().compareTo("")!=0){
													return false;
												}else return true;
											}else return true;
										}else return true;
									}else return true;
								}else return true;
							}else return true;
						}else return true;
					}else return true;
				}else return true;
			}else return true;
		}else return true;
	}

	public RegistratiView getRegistrati() {
		return registrati;
	}

	public void setRegistrati(RegistratiView registrati) {
		this.registrati = registrati;
	}

	public ContenutoPanel getContenuto() {
		return contenuto;
	}



	public void setContenuto(ContenutoPanel contenuto) {
		this.contenuto = contenuto;
	}



	public LogPanel getLogpanel() {
		return logpanel;
	}



	public void setLogpanel(LogPanel logpanel) {
		this.logpanel = logpanel;
	}



	/**
	 * @uml.property  name="registratiView"
	 * @uml.associationEnd  inverse="registratiController:client.RegistratiView"
	 * @uml.association  name="controlllato"
	 */
	private RegistratiView registratiView;

	/**
	 * Getter of the property <tt>registratiView</tt>
	 * @return  Returns the registratiView.
	 * @uml.property  name="registratiView"
	 */
	public RegistratiView getRegistratiView() {
		return registratiView;
	}

	/**
	 * Setter of the property <tt>registratiView</tt>
	 * @param registratiView  The registratiView to set.
	 * @uml.property  name="registratiView"
	 */
	public void setRegistratiView(RegistratiView registratiView) {
		this.registratiView = registratiView;
	}



	/**
	 * @uml.property  name="contenutoPanel"
	 * @uml.associationEnd  inverse="registratiController:client.ContenutoPanel"
	 * @uml.association  name="modifica"
	 */
	private ContenutoPanel contenutoPanel;

	/**
	 * Getter of the property <tt>contenutoPanel</tt>
	 * @return  Returns the contenutoPanel.
	 * @uml.property  name="contenutoPanel"
	 */
	public ContenutoPanel getContenutoPanel() {
		return contenutoPanel;
	}

	/**
	 * Setter of the property <tt>contenutoPanel</tt>
	 * @param contenutoPanel  The contenutoPanel to set.
	 * @uml.property  name="contenutoPanel"
	 */
	public void setContenutoPanel(ContenutoPanel contenutoPanel) {
		this.contenutoPanel = contenutoPanel;
	}
	
	

}
