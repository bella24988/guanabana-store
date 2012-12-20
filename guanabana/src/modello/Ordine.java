package modello;

import java.io.Serializable;


/**
 * @author  Veronica
 */
public class Ordine implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="numeroOrdine"
	 */
	private int numeroOrdine;
	/**
	 * @uml.property  name="computer"
	 * @uml.associationEnd  
	 */
	private Computer computer;
	private float totale;
	/**
	 * @uml.property  name="cliente"
	 * @uml.associationEnd  
	 */
	private Cliente cliente;
	/**
	 * @uml.property  name="data"
	 */
	private String data;
	/**
	 * @uml.property  name="stato"
	 */
	private String stato;
	
	

	public Ordine(int numeroOrdine, Computer computer, float prezzo, Cliente cliente) {
		super();
		this.numeroOrdine = numeroOrdine;
		this.computer = computer;
		this.totale = prezzo;
		this.cliente = cliente;
	}

	/**
	 * @return  the numeroOrdine
	 * @uml.property  name="numeroOrdine"
	 */
	public int getNumeroOrdine() {
		return numeroOrdine;
	}

	/**
	 * @param numeroOrdine  the numeroOrdine to set
	 * @uml.property  name="numeroOrdine"
	 */
	public void setNumeroOrdine(int numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}

	/**
	 * @return  the computer
	 * @uml.property  name="computer"
	 */
	public Computer getComputer() {
		return computer;
	}

	/**
	 * @param computer  the computer to set
	 * @uml.property  name="computer"
	 */
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	/**
	 * @return the prezzo
	 */
	public float getPrezzo() {
		return totale;
	}

	/**
	 * @param prezzo the prezzo to set
	 */
	public void setPrezzo(float prezzo) {
		this.totale = prezzo;
	}

	/**
	 * @return  the cliente
	 * @uml.property  name="cliente"
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente  the cliente to set
	 * @uml.property  name="cliente"
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return  the data
	 * @uml.property  name="data"
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data  the data to set
	 * @uml.property  name="data"
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return  the stato
	 * @uml.property  name="stato"
	 */
	public String getStato() {
		return stato;
	}

	/**
	 * @param stato  the stato to set
	 * @uml.property  name="stato"
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}

	/** 
	 * @uml.property name="pagamento"
	 * @uml.associationEnd aggregation="composite" inverse="ordine:modello.Pagamento"
	 * @uml.association name="conclusa con"
	 */
	private Pagamento pagamento;



	/** 
	 * Getter of the property <tt>pagamento</tt>
	 * @return  Returns the pagamento.
	 * @uml.property  name="pagamento"
	 */
	public Pagamento getPagamento() {
		return pagamento;
	}

	/** 
	 * Setter of the property <tt>pagamento</tt>
	 * @param pagamento  The pagamento to set.
	 * @uml.property  name="pagamento"
	 */
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	/** 
	 * @uml.property name="richiestaSpedizione"
	 * @uml.associationEnd aggregation="composite" inverse="ordine:modello.RichiestaSpedizione"
	 * @uml.association name="crea"
	 */
	private RichiestaSpedizione richiestaSpedizione;



	/** 
	 * Getter of the property <tt>richiestaSpedizione</tt>
	 * @return  Returns the richiestaSpedizione.
	 * @uml.property  name="richiestaSpedizione"
	 */
	public RichiestaSpedizione getRichiestaSpedizione() {
		return richiestaSpedizione;
	}

	/** 
	 * Setter of the property <tt>richiestaSpedizione</tt>
	 * @param richiestaSpedizione  The richiestaSpedizione to set.
	 * @uml.property  name="richiestaSpedizione"
	 */
	public void setRichiestaSpedizione(RichiestaSpedizione richiestaSpedizione) {
		this.richiestaSpedizione = richiestaSpedizione;
	}
	
	public String getMessaggioEmail(Pagamento pagamento, String msnAdjunto){
		String messaggio ="<p class=MsoNormal align=center style='text-align:center'>" +
				"<span style='font-size:50.0pt;color:#76923C;mso-themecolor:accent3;mso-themeshade:191'>Ricevuta</span></p>" +
				"<p class=MsoNormal><b style='mso-bidi-font-weight:normal'><span" +
				"style='color:#76923C;mso-themecolor:accent3;mso-themeshade:191'><o:p>&nbsp;</o:p></span></b></p>" +
				"<p class=MsoNormal><span style='font-size:18.0pt'>"+msnAdjunto+"</span></p>" +
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
				detagliPagamento(pagamento)+
				"<p class=MsoNormal><span style='font-size:18.0pt'>Codice pagamento: "+pagamento.getNumPagamento()+"</span></p>"+
				"<p class=MsoNormal><span style='font-size:18.0pt'>Stato del pagamento: "+statoPagamento(pagamento.isConfermato())+"</span></p>"+
				"<p class=MsoNormal align=center style='text-align:center'><span"+
				"style='font-size:18.0pt'><o:p>&nbsp;</o:p></span></p>"+
				
				"<p class=MsoNormal style='text-align:justify;text-justify:inter-ideograph'><span"+
				"style='color:#76923C;mso-themecolor:accent3;mso-themeshade:191'>Grazie per "+
				"l&rsquo;acquisto! In qualunque momento potr&agrave; consultare lo stato dei suoi ordini oppure"+
				"cancellare l&rsquo;ordine traverso il nostro sito web <a"+
				"href='http://www.guanabana-store.com'>www.guanabana-store.com</a> nella voce &ldquo;I "+
				"tuoi ordini&rdquo;.<o:p></o:p></span></p>"+
				
				"<p class=MsoNormal align=center style='text-align:center'><span"+
				"style='font-size:18.0pt'><o:p>&nbsp;</o:p></span></p>";
		
		
		return messaggio;
		
	}
	
	private String statoPagamento(boolean confermato) {
		 if(confermato){
			 return "Pagato";
		 }else return "Non pagato";
	}

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
	
	private String detagliPagamento(Pagamento pagamento){
		String detagli;
		
		if(pagamento.getTipoPagamento().compareTo("Carta di Credito")==0||pagamento.getTipoPagamento().compareTo("CARTA DI CREDITO")==0){
			CartaCredito cc = (CartaCredito) pagamento;
			detagli="<p class=MsoNormal><span style='font-size:14.0pt'>Carta numero: ****"+cc.getCodice().substring(12,16)+"<o:p></o:p></span></p>"+
					"<p class=MsoNormal><span style='font-size:14.0pt'>Intestatario: "+cc.getIntestatario()+"<o:p></o:p></span></p>";
			
		}else if(pagamento.getTipoPagamento().compareTo("Bonifico")==0||pagamento.getTipoPagamento().compareTo("BONIFICO")==0){
			Bonifico bon = (Bonifico) pagamento;
			detagli="<p class=MsoNormal><span style='font-size:14.0pt'>Numero bonifico: "+bon.getCodice()+"<o:p></o:p></span></p>" +
					"<p class=MsoNormal><span style='font-size:14.0pt'>Banca :"+bon.getBanca()+"<o:p></o:p></span></p>";
		}else{
			detagli="<p class=MsoNormal><span style='font-size:14.0pt'>Al momento della consegna dovr&agrave; pagare in assegno o contanti<o:p></o:p></span></p>";
		}
		
		
		return detagli;
	}
	

}
