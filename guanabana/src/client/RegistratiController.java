package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.Pattern;

import modello.Cliente;

import client.ContenutoPanel;
import client.LogPanel;
import client.RegistratiView;

public class RegistratiController implements ActionListener {

	/**
	 * @uml.property name="logpanel"
	 * @uml.associationEnd
	 */
	LogPanel logpanel;
	/**
	 * @uml.property name="contenuto"
	 * @uml.associationEnd
	 */
	ContenutoPanel contenuto;
	/**
	 * @uml.property name="registrati"
	 * @uml.associationEnd
	 */
	RegistratiView registrati;
	/**
	 * @uml.property name="cliente"
	 * @uml.associationEnd
	 */
	Cliente cliente;

	public RegistratiController(RegistratiView registrati) {
		this.setRegistrati(registrati);
	}

	public RegistratiController(LogPanel logpanel, ContenutoPanel contenuto) {
		super();
		this.setLogpanel(logpanel);
		this.setContenuto(contenuto);
	}

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

					client = new Client(registrati.getLogPanel().getContenuto()
							.getHost());
					try {
						try {
							cliente = client
									.registreNuovoCliente(
											registrati.getTxtCf(), registrati
													.getTxtNome(), registrati
													.getTxtCognome(),
											registrati.getTxtEmail(),
											indirizzo, registrati
													.getTxtTelefono(), String
													.valueOf(registrati
															.getTxtPassword()));

							if (client != null) {

								registrati.setTxtNome(cliente.getNome() + " "
										+ cliente.getCognome());
								registrati.getLogPanel().getContenuto()
										.setClienteLogato(cliente);

								if (registrati.getLogPanel().getContenuto()
										.getAttessaCompra() == true) {

									registrati.getLogPanel().getContenuto()
											.continuaOperazione();

								}

							} else
								registrati
										.mostraMessaggio("Errore al registrarsi");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
						registrati.mostraMessaggio("Errore con il server");
					}
					registrati.ocultaFinestra(cliente);

				} else {
					registrati.mostraMessaggio("Le password non coincidono");
				}
			} else if (validate(registrati) == 1) {
				registrati.mostraMessaggio("Si devono compilare tutti campi");
			}

		}

	}

	private boolean passwordUguali(String psw1, String psw2) {

		if (psw2.compareTo(psw1) != 0) {
			return false;
		} else {
			return true;
		}
		// return true;

	}

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
		Pattern cfPattern = Pattern.compile("[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]");
		Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%-]*@[a-zA-Z0-9.-]{3,}\\.[a-zA-Z]{2,4}");
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
		passwordMatcher = passwordPattern.matcher(String.valueOf(r.getTxtPasswordConferma()));

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
	 * @return
	 * @uml.property name="registrati"
	 */
	public RegistratiView getRegistrati() {
		return registrati;
	}

	/**
	 * @param registrati
	 * @uml.property name="registrati"
	 */
	public void setRegistrati(RegistratiView registrati) {
		this.registrati = registrati;
	}

	/**
	 * @return
	 * @uml.property name="contenuto"
	 */
	public ContenutoPanel getContenuto() {
		return contenuto;
	}

	/**
	 * @param contenuto
	 * @uml.property name="contenuto"
	 */
	public void setContenuto(ContenutoPanel contenuto) {
		this.contenuto = contenuto;
	}

	/**
	 * @return
	 * @uml.property name="logpanel"
	 */
	public LogPanel getLogpanel() {
		return logpanel;
	}

	/**
	 * @param logpanel
	 * @uml.property name="logpanel"
	 */
	public void setLogpanel(LogPanel logpanel) {
		this.logpanel = logpanel;
	}

	/**
	 * @uml.property name="registratiView"
	 * @uml.associationEnd
	 */
	private RegistratiView registratiView;

	/**
	 * Getter of the property <tt>registratiView</tt>
	 * 
	 * @return Returns the registratiView.
	 * @uml.property name="registratiView"
	 */
	public RegistratiView getRegistratiView() {
		return registratiView;
	}

	/**
	 * Setter of the property <tt>registratiView</tt>
	 * 
	 * @param registratiView
	 *            The registratiView to set.
	 * @uml.property name="registratiView"
	 */
	public void setRegistratiView(RegistratiView registratiView) {
		this.registratiView = registratiView;
	}

	/**
	 * @uml.property name="contenutoPanel"
	 * @uml.associationEnd
	 */
	private ContenutoPanel contenutoPanel;

	/**
	 * Getter of the property <tt>contenutoPanel</tt>
	 * 
	 * @return Returns the contenutoPanel.
	 * @uml.property name="contenutoPanel"
	 */
	public ContenutoPanel getContenutoPanel() {
		return contenutoPanel;
	}

	/**
	 * Setter of the property <tt>contenutoPanel</tt>
	 * 
	 * @param contenutoPanel
	 *            The contenutoPanel to set.
	 * @uml.property name="contenutoPanel"
	 */
	public void setContenutoPanel(ContenutoPanel contenutoPanel) {
		this.contenutoPanel = contenutoPanel;
	}

	/**
	 * @uml.property name="client"
	 * @uml.associationEnd
	 */
	private Client client;

	/**
	 * Getter of the property <tt>client</tt>
	 * 
	 * @return Returns the client.
	 * @uml.property name="client"
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Setter of the property <tt>client</tt>
	 * 
	 * @param client
	 *            The client to set.
	 * @uml.property name="client"
	 */
	public void setClient(Client client) {
		this.client = client;
	}

}
