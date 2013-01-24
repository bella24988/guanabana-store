package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import modello.Cliente;

import client.ContenutoPanel;
import client.LogPanel;
import client.RegistratiView;

/**
 * Classe RegistratiController: Controlla il processo di registrazione e i pulsanti per confermare
 * la registrazione dopo aver compilato il form.
 * Implementa ActionListener.
 * @author Gabriele
 * @author Veronica
 * @version 3.0 Jan 3, 2013. 
 */
public class RegistratiController implements ActionListener {

	/**
	 * Dichiarazione delle variabili
	 */
	LogPanel logpanel;
	ContenutoPanel contenuto;
	RegistratiView registrati;
	
	private ServizioClient client;
	
	Cliente cliente;

	/**
	 * Primo costruttore del controller, prende come parametro il pannello di registrazione
	 * @param registrati
	 */
	public RegistratiController(RegistratiView registrati) {
		this.setRegistrati(registrati);
	}

	/**
	 * Secondo costruttore del controller, associa al pannello di login e a quello dei contenuti
	 * l'utente registrato
	 * @param logpanel
	 * @param contenuto
	 */
	public RegistratiController(LogPanel logpanel, ContenutoPanel contenuto) {
		super();
		this.setLogpanel(logpanel);
		this.setContenuto(contenuto);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Registrati")) {
			contenuto.mostraFormularioRegistrati(logpanel);
		}

		if (e.getActionCommand().equalsIgnoreCase("Annulla")) {
			registrati.disabilitaRegistrati();
			registrati.inizializza();
		} else if (e.getActionCommand().equalsIgnoreCase(
				"Conferma Registrazione")) {

			registrati.togliMessaggio();
			if (validate(registrati) == 0) {

				if (passwordUguali(String.valueOf(registrati.getTxtPassword()),
						String.valueOf(registrati.getTxtPasswordConferma())) == true) {

					String indirizzo = "Via: " + registrati.getTxtVia()
							+ " C.A.P. " + registrati.getTxtCap() + ". "
							+ registrati.getTxtCitta() + ". Provincia: "
							+ registrati.getTxtProvincia() + ". "
							+ registrati.getTxtStato();

					client = new ServizioClient(registrati.getLogPanel().getContenuto()
							.getHost());
					try {
							try {
								cliente = client
										.registraNuovoCliente(
												registrati.getTxtCf(), registrati
														.getTxtNome(), registrati
														.getTxtCognome(),
												registrati.getTxtEmail(),
												indirizzo, registrati
														.getTxtTelefono(), String
														.valueOf(registrati
																.getTxtPassword()));
								
							} catch (IOException e1) {
								e1.printStackTrace();
								registrati.mostraMessaggio("Errore: cliente già registrato");
							}

						if(cliente != null){

								
								try {
									registrati.setTxtNome(cliente.getNome() + " "
											+ cliente.getCognome());
									registrati.getLogPanel().getContenuto()
											.setClienteLoggato(cliente);
									client.inviaEmailConferma(registrati.getTxtEmail(),//email cliente
											cliente.getMessaggio(),//messaggio della email
											"Guanabana - Registrazione");
								} catch (UnknownHostException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
									registrati.mostraMessaggio("Errore, non è possibile registrarsi con questa email");
								}//subject della email

								if (registrati.getLogPanel().getContenuto()
										.getWaitForBuy() == true) {

									registrati.getLogPanel().getContenuto()
											.continuaOperazione();

								}
								registrati.nascondiFinestra(cliente);
						}
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (AddressException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (MessagingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							registrati.mostraMessaggio("Errore con il server");
						}


				} else {
					registrati.mostraMessaggio("Le password non coincidono");
				}
			} else if (validate(registrati) == 1) {
				registrati.mostraMessaggio("Si devono compilare tutti campi");
			}

		}

	}

	/**
	 * Restituisce true se i valori psw1 e psw2 coincidono, false altrimenti.
	 * Utilizzato per controllare la coincidenza dei campi "Password" e "Conferma Password"
	 * @param psw1
	 * @param psw2
	 * @return true or false
	 */
	private boolean passwordUguali(String psw1, String psw2) {

		if (psw2.compareTo(psw1) != 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Metodo che permette di validare tutti i campi del form
	 * di registrazione, utilizzando Java Pattern
	 * @param r
	 * @return int value that represent validation
	 */
	private int validate(RegistratiView r) {

		Matcher nomeMatcher = null;
		Matcher cognomeMatcher = null;
		Matcher cfMatcher = null;
		Matcher emailMatcher = null;
		Matcher cittaMatcher = null;
		Matcher viaMatcher = null;
		Matcher provinciaMatcher = null;
		Matcher capMatcher = null;
		Matcher statoMatcher = null;
		Matcher telefonoMatcher = null;
		Matcher passwordMatcher = null;

		Pattern nomePattern = Pattern.compile("[a-zA-Z ]{2,}");
		Pattern cognomePattern = Pattern.compile("[a-zA-Z ]{2,}");
		Pattern cfPattern = Pattern
				.compile("[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]");
		Pattern emailPattern = Pattern
				.compile("[a-zA-Z0-9._%-]*@[a-zA-Z0-9.-]{3,}\\.[a-zA-Z]{2,4}");
		Pattern cittaPattern = Pattern.compile("[a-zA-Z ]{2,}");
		Pattern viaPattern = Pattern.compile("[a-zA-Z0-9 ]{2,}");
		Pattern provinciaPattern = Pattern.compile("[A-Za-z]{2}");
		Pattern capPattern = Pattern.compile("[0-9]{5}");
		Pattern statoPattern = Pattern.compile("[a-zA-Z ]{2,}");
		Pattern telefonoPattern = Pattern.compile("[0-9]{8,}");
		Pattern passwordPattern = Pattern.compile("[0-9a-zA-z!@#$%^&*]{6,}");

		nomeMatcher = nomePattern.matcher(r.getTxtNome());
		cognomeMatcher = cognomePattern.matcher(r.getTxtCognome());
		cfMatcher = cfPattern.matcher(r.getTxtCf());
		emailMatcher = emailPattern.matcher(r.getTxtEmail());
		cittaMatcher = cittaPattern.matcher(r.getTxtCitta());
		viaMatcher = viaPattern.matcher(r.getTxtVia());
		provinciaMatcher = provinciaPattern.matcher(r.getTxtProvincia());
		capMatcher = capPattern.matcher(r.getTxtCap());
		statoMatcher = statoPattern.matcher(r.getTxtStato());
		telefonoMatcher = telefonoPattern.matcher(r.getTxtTelefono());
		passwordMatcher = passwordPattern.matcher(String.valueOf(r
				.getTxtPasswordConferma()));

		if (r.getTxtNome().compareTo("") != 0) {
			if (!nomeMatcher.matches()) {
				registrati.mostraMessaggio("Inserire un nome valido");
				return 2;
			}
			if (r.getTxtCognome().compareTo("") != 0) {
				if (!cognomeMatcher.matches()) {
					registrati.mostraMessaggio("Inserire un cognome valido");
					return 2;
				}
				if (r.getTxtCf().compareTo("") != 0) {
					if (!cfMatcher.matches()) {
						registrati
								.mostraMessaggio("Inserire un codice fiscale valido");
						return 2;
					}
					if (r.getTxtEmail().compareTo("") != 0) {
						if (!emailMatcher.matches()) {
							registrati
									.mostraMessaggio("Inserire una email valida");
							return 2;
						}
						if (r.getTxtCitta().compareTo("") != 0) {
							if (!cittaMatcher.matches()) {
								registrati
										.mostraMessaggio("Inserire una citta' valida");
								return 2;
							}
							if (r.getTxtVia().compareTo("") != 0) {
								if (!viaMatcher.matches()) {
									registrati
											.mostraMessaggio("Inserire una via valida");
									return 2;
								}
								if (r.getTxtProvincia().compareTo("") != 0) {
									if (!provinciaMatcher.matches()) {
										registrati
												.mostraMessaggio("Inserire una provincia valida");
										return 2;
									}

									if (r.getTxtCap().compareTo("") != 0) {
										if (!capMatcher.matches()) {
											registrati
													.mostraMessaggio("Inserire un CAP valido");
											return 2;
										}

										if (r.getTxtStato().compareTo("") != 0) {
											if (!statoMatcher.matches()) {
												registrati
														.mostraMessaggio("Inserire uno stato valido");
												return 2;
											}
											if (r.getTxtTelefono()
													.compareTo("") != 0) {
												if (!telefonoMatcher.matches()) {
													registrati
															.mostraMessaggio("Inserire un telefono valido");
													return 2;
												}
												if (String.valueOf(
														r.getTxtPassword())
														.compareTo("") != 0) {
													if (String
															.valueOf(
																	r.getTxtPasswordConferma())
															.compareTo("") != 0) {
														if (!passwordMatcher
																.matches()) {
															registrati
																	.mostraMessaggio("La password deve contenere almeno un carattere maiuscolo,\nun carattere minuscolo e un numero,\ne deve essere lunga almeno sei caratteri");
															return 2;
														}
														return 0;
													} else
														return 1;
												} else
													return 1;
											} else
												return 1;
										} else
											return 1;
									} else
										return 1;
								} else
									return 1;
							} else
								return 1;
						} else
							return 1;
					} else
						return 1;
				} else
					return 1;
			} else
				return 1;
		} else
			return 1;
	}

	/**
	 * Getter of registrati
	 * @return registrati
	 */
	public RegistratiView getRegistrati() {
		return registrati;
	}

	/**
	 * Setter of registrati
	 * @param registrati
	 */
	public void setRegistrati(RegistratiView registrati) {
		this.registrati = registrati;
	}

	/**
	 * Getter of contenuto
	 * @return contenuto
	 */
	public ContenutoPanel getContenuto() {
		return contenuto;
	}

	/**
	 * Setter of contenuto
	 * @param contenuto
	 */
	public void setContenuto(ContenutoPanel contenuto) {
		this.contenuto = contenuto;
	}

	/**
	 * Getter of logpanel
	 * @return logpanel
	 */
	public LogPanel getLogpanel() {
		return logpanel;
	}

	/**
	 * Setter of logpanel
	 * @param logpanel
	 */
	public void setLogpanel(LogPanel logpanel) {
		this.logpanel = logpanel;
	}

	/**
	 * Getter of client
	 * @return client
	 */
	public ServizioClient getClient() {
		return client;
	}

	/**
	 * Setter of client
	 * @param client
	 */
	public void setClient(ServizioClient client) {
		this.client = client;
	}

}
