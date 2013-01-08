package modello;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Classe Fattura: Modello di una fattura di un acquisto.
 * Implementa Serializable.
 * @author Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class Fattura implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Dichiarazione delle variabili
	 */
	private Ordine ordine;		//Ordine da fatturare
	private String codice;		//Codice dell'ordine
	private String data;		//Data della fattura


	/**
	 * Costruttore di una fattura di un acquisto.
	 * @param ordine			Ordine da fatturare
	 * @param codice			Codice dell'ordine
	 * @param data				Data della fattura
	 */
	public Fattura(Ordine ordine, String codice, String data) {
		super();
		this.ordine = ordine;
		this.codice = codice;
		this.data = data;
	}
	
	/**
	 * Metodo che permette di generare la fattura di un ordine.
	 * @param filename			Nome del file generato
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void generareFattura(String filename) throws DocumentException, IOException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        Font style=new Font(Font.FontFamily.TIMES_ROMAN, 20);
        style.setStyle("bold");
        
        Font style1=new Font(Font.FontFamily.TIMES_ROMAN, 10);
        
        Paragraph titolo = new Paragraph("Fattura Numero: "+codice, style1);
        
        Paragraph titoloDocumento = new Paragraph("Fattura",style);
        titoloDocumento.setAlignment(Element.ALIGN_CENTER);
        
        PdfPTable tableTitolo = new PdfPTable(1);
        Image image;
        try {
        	 image = Image.getInstance ("src/icons/logoGpiccollo.jpg");
        	 tableTitolo.addCell(image);
		} catch (Exception e) {
			 Font style2=new Font(Font.FontFamily.TIMES_ROMAN, 34);
		     style2.setStyle("bold");
			 image = null;
			 Paragraph titoloAlternativo = new Paragraph("www.guanabana.it",style2);
		     titoloAlternativo.setAlignment(Element.ALIGN_CENTER);
			 tableTitolo.addCell(titoloAlternativo);
		}
        
        
        tableTitolo.addCell(titolo);
        
        Paragraph intestazione = new Paragraph("Nome cliente:  "+ordine.getCliente().getNome()+" "+ordine.getCliente().getCognome()+"\n" +
        		"C.F. "+ordine.getCliente().getCf()+"\nIndirizzo: "+ordine.getCliente().getIndirizzo()+"\nTelefono: "+ordine.getCliente().getTelefono(), style1);
        
        tableTitolo.addCell(intestazione);
        
        Paragraph spazioLinea = new Paragraph("\n");
        
        PdfPTable table = new PdfPTable(3);
       
		Paragraph titoloTabella = new Paragraph("Dettagli dell'ordine");
		titoloTabella.setAlignment(Element.ALIGN_CENTER);
		
		int r=123;
        int g=160;
        int b=91;        
        BaseColor cell_background_color=new BaseColor(r,g,b);
        
		PdfPCell cell = new PdfPCell(titoloTabella);
		
		cell.setBackgroundColor(cell_background_color);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(3);
		
		table.addCell(cell);
		table.addCell("Codice");
		table.addCell("Nome");
		table.addCell("Prezzo");
		
		table.addCell("");
		table.addCell(ordine.getComputer().getNome());
		table.addCell(String.valueOf(ordine.getComputer().getPrezzo()));
		float prezzoAdd = ordine.getComputer().getPrezzo();
		for(int i=0;i<ordine.getComputer().getConfigurazione().getComponentiScelti().length;i++){
			table.addCell(ordine.getComputer().getConfigurazione().getComponentiScelti()[i].getCodice());
			table.addCell(ordine.getComputer().getConfigurazione().getComponentiScelti()[i].getNome());
			table.addCell(String.valueOf(ordine.getComputer().getConfigurazione().getComponentiScelti()[i].getPrezzo()));
			prezzoAdd = prezzoAdd+ordine.getComputer().getConfigurazione().getComponentiScelti()[i].getPrezzo();
		}
					
		PdfPCell cell2 = new PdfPCell(new Paragraph("Totale senza sconto"));
		cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell2.setColspan(2);
		table.addCell(cell2);
		
		table.addCell(String.valueOf(prezzoAdd));
		
		PdfPCell cell3 = new PdfPCell(new Paragraph("Sconto: "));
		cell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell3.setColspan(2);
		table.addCell(cell3);
		
		table.addCell("-"+String.valueOf(100-(ordine.getPrezzo()*100/prezzoAdd)+"%"));
		
		PdfPCell cell4 = new PdfPCell(new Paragraph("Totale"));
		cell4.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell4.setColspan(2);
		table.addCell(cell4);
		
		table.addCell(String.valueOf(ordine.getPrezzo()));
		
		Paragraph piePagina = new Paragraph("Grazie per l'acquisto! \nA seconda del metodo di pagamento scelto, possono essere necessari fino a 7 giorni lavorativi per l'elaborazione dell'ordine. Per i pagamenti tramite bonifico, vi saranno richiesti i vostri estremi bancari per addebitare l'importo sul vostro conto." +
				"\nNon vi verra' addebitato nessun costo sulla vostra carta di credito finche' l'ordine non risultera' spedito. Per qualsiasi tipo di annullamento dell'ordine prima della spedizione, l'importo dell'autorizzazione trattenuto sulla vostra carta verra' restituito entro 3 giorni dalla societa' erogatrice della carta di credito." +
				"\nData: "+getData(), style1);
		piePagina.setAlignment(Element.ALIGN_CENTER);
		
		PdfPTable tablePagamento = new PdfPTable(2);
		tablePagamento.addCell("Tipo pagamento: ");
		tablePagamento.addCell(ordine.getPagamento().getTipoPagamento());
		
	
        document.add(tableTitolo);
        document.add(spazioLinea);
        document.add(titoloDocumento);
        document.add(spazioLinea);
        document.add(table);
        document.add(spazioLinea);
        document.add(spazioLinea);
        document.add(tablePagamento);
        document.add(spazioLinea);
        document.add(spazioLinea);
        document.add(piePagina);
        
        // step 5
        document.close();
        java.awt.Desktop.getDesktop().open(new File(filename));
    }

	
	/**
	 * Getter of codice
	 * @return codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * Setter of codice
	 * @param codice
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * Getter of data
	 * @return data.
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
	 * Getter of ordine
	 * @return ordine
	 */
	public Ordine getOrdine() {
		return ordine;
	}

	/**
	 * Setter of ordine
	 * @param ordine
	 */
	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}
	
}
