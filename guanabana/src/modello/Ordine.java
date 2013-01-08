package modello;

import java.io.Serializable;

/**
 * Classe Ordine: Modello di un ordine effettuato sul sito.
 * Implementa Serializable.
 * @author  Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class Ordine implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * Dichiarazione delle variabili
	 */
	private int numeroOrdine;		//Numero dell'ordine
	private Computer computer;		//Computer ordinato
	private float totale;			//Prezzo totale
	private Cliente cliente;		//Cliente che ha effettuato l'ordine
	private String data;			//Data dell'ordine
	private String stato;			//Stato dell'ordine
	private Pagamento pagamento;    //Pagamento dell'ordine

	/**
	 * Costruttore di un ordine.
	 * @param numeroOrdine			Numero dell'ordine
	 * @param computer				Computer ordinato
	 * @param prezzo				Prezzo totale
	 * @param cliente				Cliente che ha effettuato l'ordine
	 */
	public Ordine(int numeroOrdine, Computer computer, float prezzo, Cliente cliente) {
		super();
		this.numeroOrdine = numeroOrdine;
		this.computer = computer;
		this.totale = prezzo;
		this.cliente = cliente;
	}
	
	/**
	 * Metodo che permette di generare l'email riassuntiva dell'ordine
	 * @param pagamento
	 * @param mesAggiunto
	 * @return messaggio
	 */
	public String getMessaggioEmail(Pagamento pagamento, String mesAggiunto){
		String messaggio ="<p class=MsoNormal align=center style='text-align:center'>" +
				"<span style='font-size:50.0pt;color:#76923C;mso-themecolor:accent3;mso-themeshade:191'>Ricevuta</span></p>" +
				"<p class=MsoNormal><b style='mso-bidi-font-weight:normal'><span" +
				"style='color:#76923C;mso-themecolor:accent3;mso-themeshade:191'><o:p>&nbsp;</o:p></span></b></p>" +
				"<p class=MsoNormal><span style='font-size:18.0pt'>"+mesAggiunto+"</span></p>" +
				"<div align=center>" +
				"<table class=MsoTableGrid border=0 cellspacing=0 cellpadding=0>" +
				"<tr>" +
				"<td width=198 valign=top style='width:197.95pt; windowtext 1.0pt;" +
				"windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
				"<p class=MsoNormal>Ordine numero:</p></td>" +
				"<td width=269 valign=top style='width:269.35pt; windowtext 1.0pt;" +
				"border-left:none; windowtext .5pt;" +
				"windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
				"<p class=MsoNormal><span class=GramE>"+numeroOrdine+"</span></p>" +
				"</td>" +
				"<td width=135 valign=top style='width:135.25pt; windowtext 1.0pt;" +
				"border-left:none; windowtext .5pt;" +
				" windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'><p class=MsoNormal>Data:</p>" +
				"</td>" +
				"<td width=207 valign=top style='width:206.7pt; windowtext 1.0pt;" +
				"border-left:none; windowtext .5pt;" +
				" windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
				"<p class=MsoNormal>"+data+"</p>" +
				"</td>" +
				"</tr>" +
				"<tr style='mso-yfti-irow:1'>" +
				"<td width=198 valign=top style='width:197.95pt; windowtext 1.0pt;" +
				"border-top:none;windowtext .5pt;windowtext .5pt;" +
				"padding:0cm 5.4pt 0cm 5.4pt'><p class=MsoNormal>Codice Fiscale:</p></td>" +
				"<td width=269 valign=top style='width:269.35pt;border-top:none;border-left:" +
				"windowtext 1.0pt; windowtext 1.0pt;" +
				"windowtext .5pt; windowtext .5pt;" +
				"windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
				"<p class=MsoNormal><span class=GramE>"+cliente.getCf()+"</span></p>" +
				"</td>" +
				"<td width=198 valign=top style='width:197.95pt; windowtext 1.0pt;" +
				"border-top:none; windowtext .5pt; windowtext .5pt;" +
				"padding:0cm 5.4pt 0cm 5.4pt'><p class=MsoNormal>Telefono:</p></td>" +
				"<td width=269 valign=top style='width:269.35pt;border-top:none;border-left:" +
				"none; windowtext 1.0pt;windowtext 1.0pt;" +
				" windowtext .5pt;windowtext .5pt;" +
				" windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
				"<p class=MsoNormal><span class=GramE>"+cliente.getTelefono()+"</span></p>" +
				"</td></tr>" +
				"<tr style='mso-yfti-irow:1'>" +
				"<td width=198 valign=top style='width:197.95pt;windowtext 1.0pt;" +
				"border-top:none; windowtext .5pt;windowtext .5pt;" +
				"padding:0cm 5.4pt 0cm 5.4pt'><p class=MsoNormal>Cliente:</p></td>" +
				"<td width=269 valign=top style='width:269.35pt;border-top:none;border-left:" +
				"none;windowtext 1.0pt; windowtext 1.0pt;" +
				"windowtext .5pt; windowtext .5pt;" +
				"windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
				"<p class=MsoNormal><span class=GramE>"+cliente.getNome()+"</span></p>" +
				"</td>" +
				"<td width=135 valign=top style='width:135.25pt;border-top:none;border-left:" +
				"none; windowtext 1.0pt; windowtext 1.0pt;" +
				" windowtext .5pt;windowtext .5pt;" +
				"windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
				"<p class=MsoNormal>Cognome</p>" +
				"</td>" +
				"<td width=207 valign=top style='width:206.7pt;border-top:none;border-left:" +
				"none; windowtext 1.0pt;windowtext 1.0pt;" +
				" windowtext .5pt;windowtext .5pt;" +
				" windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
				"<p class=MsoNormal>"+cliente.getCognome()+"</p></td></tr><tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>" +
				"<td width=198 valign=top style='width:197.95pt; windowtext 1.0pt;" +
				"border-top:none; windowtext .5pt; windowtext .5pt;" +
				"padding:0cm 5.4pt 0cm 5.4pt'>" +
				"<p class=MsoNormal>Indirizzo di spedizione:</p> </td>" +
				"<td width=269 valign=top style='width:269.35pt;border-top:none;border-left:" +
				"windowtext 1.0pt; windowtext 1.0pt;" +
				"windowtext .5pt; windowtext .5pt;" +
				"windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
				"<p class=MsoNormal>"+cliente.getIndirizzo()+"</p>" +
				"<p class=MsoNormal><o:p>&nbsp;</o:p></p>" +
				"<p class=MsoNormal><o:p>&nbsp;</o:p></p>" +
				"<p class=MsoNormal><o:p>&nbsp;</o:p></p>" +
				"</td>" +
				"<td width=135 valign=top style='width:135.25pt;border-top:none;border-left:none;" +
				"windowtext 1.0pt; windowtext 1.0pt;" +
				"windowtext .5pt; windowtext .5pt;" +
				"windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
				"<p class=MsoNormal>Stato dell&lsquo;ordine:</p></td>" +
				"<td width=207 valign=top style='width:206.7pt;border-top:none;border-left:" +
				"none; windowtext 1.0pt; windowtext 1.0pt;" +
				" windowtext .5pt; windowtext .5pt;" +
				"windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
				"<p class=MsoNormal>"+stato+"</p>" +
				"</td></tr>" +
				"</table>" +
				"</div>" +
				
				"<div align=center>" +
				"<table class=MsoTableGrid border=1 cellspacing=0 cellpadding=0" +
				"style='border-collapse:collapse;border:none;mso-border-alt:solid windowtext .5pt;" +
				"mso-yfti-tbllook:1184;mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>" +
				"<tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>" +
				"<td width=808 colspan=3 valign=top style='width:807.5pt;border:solid windowtext 1.0pt;" +
				"mso-border-alt:solid windowtext .5pt;background:#D9D9D9;mso-background-themecolor:" +
				"background1;mso-background-themeshade:217;padding:0cm 5.4pt 0cm 5.4pt'>" +
				"<p class=MsoNormal><span style='font-size:18.0pt'>Computer ordinato:<span" +
				"class=SpellE>"+computer.getNome()+"</span><o:p></o:p></span></p>" +
				"</td></tr>" +
				"<tr style='mso-yfti-irow:1'>" +
				"<td width=808 colspan=3 valign=top style='width:807.5pt;border:solid windowtext 1.0pt;" +
				"border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;" +
				"background:#D9D9D9;mso-background-themecolor:background1;mso-background-themeshade:" +
				"217;padding:0cm 5.4pt 0cm 5.4pt'>" +
				"<p class=MsoNormal align=center style='text-align:center'><span" +
				"style='font-size:18.0pt'>Dettagli della configurazione<b style='mso-bidi-font-weight:normal'><o:p></o:p></b></span></p>" +
				"</td>" +
				"</tr>" +
				"<tr style='mso-yfti-irow:2'>" +
				"<td width=198 valign=top style='width:197.95pt;border:solid windowtext 1.0pt;" +
				"border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;" +
				"padding:0cm 5.4pt 0cm 5.4pt'>" +
				"<p class=MsoNormal align=center style='text-align:center'><span" +
				"style='font-size:18.0pt'>Codice<o:p></o:p></span></p>" +
				"</td>" +
				"<td width=269 valign=top style='width:269.35pt;border-top:none;border-left:" +
				"none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;" +
				"mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;" +
				"mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
				"<p class=MsoNormal align=center style='text-align:center'><span" +
				"style='font-size:18.0pt'>Nome<o:p></o:p></span></p>" +
				"</td>" +
				"<td width=340 valign=top style='width:12.0cm;border-top:none;border-left:" +
				"none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;" +
				"mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;" +
				"mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
				"<p class=MsoNormal align=center style='text-align:center'><span" +
				"style='font-size:18.0pt'>Prezzo<o:p></o:p></span></p>" +
				"</td></tr>" +
				forMancante()+
				"</table>" +
				"</div>" +
				"<p class=MsoNormal><span style='font-size:18.0pt'><o:p>&nbsp;</o:p></span></p>" +
				"<p class=MsoNormal><span style='font-size:18.0pt'>Totale da pagare: "+totale+"<o:p></o:p></span></p>" +
				"<p class=MsoNormal><span style='font-size:18.0pt'>Metodo di pagamento scelto: <span"+
				"class=SpellE>"+pagamento.getTipoPagamento()+"</span><o:p></o:p></span></p>"+
				dettagliPagamento(pagamento)+
				"<p class=MsoNormal><span style='font-size:18.0pt'>Codice pagamento: "+pagamento.getNumPagamento()+"</span></p>"+
				"<p class=MsoNormal><span style='font-size:18.0pt'>Stato del pagamento: "+statoPagamento(pagamento.isConfermato())+"</span></p>"+
				"<p class=MsoNormal align=center style='text-align:center'><span"+
				"style='font-size:18.0pt'><o:p>&nbsp;</o:p></span></p>"+
				
				"<p class=MsoNormal style='text-align:justify;text-justify:inter-ideograph'><span"+
				"style='color:#76923C;mso-themecolor:accent3;mso-themeshade:191'>Grazie per "+
				"l&rsquo;acquisto! In qualunque momento potr&agrave; consultare lo stato dei suoi ordini oppure"+
				"cancellare l&rsquo;ordine attraverso il nostro sito web <a"+
				"href='http://www.guanabana-store.com'>www.guanabana-store.com</a> nella voce &ldquo;I "+
				"tuoi ordini&rdquo;.<o:p></o:p></span></p>"+
				
				"<p class=MsoNormal align=center style='text-align:center'><span"+
				"style='font-size:18.0pt'><o:p>&nbsp;</o:p></span></p>";
		
		
		return messaggio;
		
	}
	
	/**
	 * Metodo che permette di verificare lo stato del pagamento di un ordine.
	 * @param confermato			True se il pagamento e' confermato, false altrimenti
	 * @return "Pagato" se il pagamento e' confermato, "Non pagato" altrimenti
	 */
	private String statoPagamento(boolean confermato) {
		 if(confermato){
			 return "Pagato";
		 }else return "Non pagato";
	}

	/**
	 * Metodo di supporto a getMessaggioEmail().
	 * @return string
	 */
	private String forMancante(){
		String forMancante="";
		for(int i = 0; i< computer.getConfigurazione().getComponentiScelti().length;i++){
			forMancante=forMancante+"<tr style='mso-yfti-irow:3;mso-yfti-lastrow:yes'>" +//for inizio
			"<td width=198 valign=top style='width:197.95pt;border:solid windowtext 1.0pt;" +
			"border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;" +
			"padding:0cm 5.4pt 0cm 5.4pt'>" +
			"<p class=MsoNormal>"+computer.getConfigurazione().getComponentiScelti()[i].getCodice()+"<o:p>&nbsp;</o:p></p>" +
			"</td>" +
			"<td width=269 valign=top style='width:269.35pt;border-top:none;border-left:" +
			"none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;" +
			"mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;" +
			"mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
			"<p class=MsoNormal>"+computer.getConfigurazione().getComponentiScelti()[i].getNome()+"<o:p>&nbsp;</o:p></p>" +
			"</td>" +
			"<td width=340 valign=top style='width:12.0cm;border-top:none;border-left:" +
			"none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;" +
			"mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;" +
			"mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>" +
			"<p class=MsoNormal>"+computer.getConfigurazione().getComponentiScelti()[i].getPrezzo()+"<o:p>&nbsp;</o:p></p>" +
			"</td>" +
			"</tr>";
			}//Fine for
		return forMancante;
	}
	
	/**
	 * Metodo che permette di visualizzare i dettagli di un pagamento.
	 * @param pagamento		Pagamento di cui si vogliono i dettagli
	 * @return dettagli		Dettagli del pagamento
	 */
	private String dettagliPagamento(Pagamento pagamento){
		String dettagli;
		
		if(pagamento.getTipoPagamento().compareTo("Carta di Credito")==0||pagamento.getTipoPagamento().compareTo("CARTA DI CREDITO")==0){
			CartaCredito cc = (CartaCredito) pagamento;
			dettagli="<p class=MsoNormal><span style='font-size:14.0pt'>Carta numero: ****"+cc.getCodice().substring(12,16)+"<o:p></o:p></span></p>"+
					"<p class=MsoNormal><span style='font-size:14.0pt'>Intestatario: "+cc.getIntestatario()+"<o:p></o:p></span></p>";
			
		}else if(pagamento.getTipoPagamento().compareTo("Bonifico")==0||pagamento.getTipoPagamento().compareTo("BONIFICO")==0){
			Bonifico bon = (Bonifico) pagamento;
			dettagli="<p class=MsoNormal><span style='font-size:14.0pt'>Numero bonifico: "+bon.getCodice()+"<o:p></o:p></span></p>" +
					"<p class=MsoNormal><span style='font-size:14.0pt'>Banca :"+bon.getBanca()+"<o:p></o:p></span></p>";
		}else{
			dettagli="<p class=MsoNormal><span style='font-size:14.0pt'>Al momento della consegna dovr&agrave; pagare tramite assegno o contanti<o:p></o:p></span></p>";
		}
		
		
		return dettagli;
	}
	

	/**
	 * Getter of numeroOrdine
	 * @return numeroOrdine
	 */
	public int getNumeroOrdine() {
		return numeroOrdine;
	}

	/**
	 * Setter of numeroOrdine
	 * @param numeroOrdine
	 */
	public void setNumeroOrdine(int numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}

	/**
	 * Getter of computer
	 * @return computer
	 */
	public Computer getComputer() {
		return computer;
	}

	/**
	 * Setter of computer
	 * @param computer
	 */
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	/**
	 * Getter of prezzo
	 * @return prezzo
	 */
	public float getPrezzo() {
		return totale;
	}

	/**
	 * Setter of prezzo
	 * @param prezzo
	 */
	public void setPrezzo(float prezzo) {
		this.totale = prezzo;
	}

	/**
	 * Getter of cliente
	 * @return cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Setter of cliente
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Getter of data
	 * @return data
	 */
	public String getData() {
		return data;
	}

	/**
	 * Setter of data
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * Getter of stato
	 * @return stato
	 */
	public String getStato() {
		return stato;
	}

	/**
	 * Setter of stato
	 * @param stato
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}

	/** 
	 * Getter of pagamento
	 * @return pagamento
	 */
	public Pagamento getPagamento() {
		return pagamento;
	}

	/** 
	 * Setter of pagamento
	 * @param pagamento
	 */
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

}
