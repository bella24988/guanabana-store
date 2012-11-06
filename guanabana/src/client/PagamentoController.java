package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PagamentoController implements ActionListener{
	
	/**
	 * @uml.property  name="pagamentoPanel"
	 * @uml.associationEnd  
	 */
	private PagamentoPanel pagamentoPanel;
	/**
	 * @uml.property  name="tipoPagamento"
	 */
	private String tipoPagamento;

	public PagamentoController(PagamentoPanel pagamentoPanel) {
		super();
		this.pagamentoPanel = pagamentoPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("carta di credito")){
			pagamentoPanel.getPanelCartaCredito().setVisible(true);
			pagamentoPanel.getPanelBonifico().setVisible(false);
			pagamentoPanel.getPanelContrasegno().setVisible(false);
			pagamentoPanel.setTipoPagamentoScelto(1);
			
		}else if (e.getActionCommand().equalsIgnoreCase("bonifico")){
			pagamentoPanel.getPanelBonifico().setVisible(true);
			pagamentoPanel.getPanelContrasegno().setVisible(false);
			pagamentoPanel.getPanelCartaCredito().setVisible(false);
			pagamentoPanel.setTipoPagamentoScelto(2);
			
		}else if (e.getActionCommand().equalsIgnoreCase("contrassegno")){
			pagamentoPanel.getPanelContrasegno().setVisible(true);
			pagamentoPanel.getPanelCartaCredito().setVisible(false);
			pagamentoPanel.getPanelBonifico().setVisible(false);
			pagamentoPanel.setTipoPagamentoScelto(3);
			
		}else if (e.getActionCommand().equalsIgnoreCase("accetta")){
			if(pagamentoPanel.getContenutoPanel().getClienteLogato()!=null){
			
				Client client = new Client(pagamentoPanel.getContenutoPanel().getHost());
				
				if (pagamentoPanel.getTipoPagamentoScelto()==0) {
					pagamentoPanel.mostraMessaggioErrore("Selezionare il tipo di pagamento");
					}else {
						if (pagamentoPanel.getTipoPagamentoScelto()==1) {
						setTipoPagamento("Carta di Credito");
						}else if (pagamentoPanel.getTipoPagamentoScelto()==2) {
						setTipoPagamento("Bonifico"); 
						}else if (pagamentoPanel.getTipoPagamentoScelto()==3) {
						setTipoPagamento("Contrassegno"); 
						}
						try {
							client.registrarePagamento(pagamentoPanel.getContenutoPanel().getOrdine(), getTipoPagamento());
							pagamentoPanel.getContenutoPanel().mostraRingraziamento();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}else{
				
			}
			
		}		
	private boolean validate(PagamentoPanel p){
		
		if (p.getTipoPagamentoScelto()==1) {
			
			setTipoPagamento("Carta di Credito");
			
			Matcher cardNumberMatcher = null;
			Matcher intestatarioMatcher = null;
			Matcher codSicurezzaMatcher = null;
			
			Pattern cardNumberPattern = Pattern.compile("[0-9]{16}");
			Pattern intestatarioPattern = Pattern.compile("[a-zA-Z ]{2,}");
			Pattern codSicurezzaPattern = Pattern.compile("[0-9]{3}");
			
			cardNumberMatcher = cardNumberPattern.matcher(p.getTxtCarta());
			intestatarioMatcher = intestatarioPattern.matcher(p.getTxtIntestatario());
			codSicurezzaMatcher = codSicurezzaPattern.matcher(p.getTxtCodSicurezza());
			
			if (!cardNumberMatcher.matches()) {
				p.mostraMessaggioErrore("Il numero della carta deve essere di 16 cifre \ne non deve contenere spazi");
				return false;
			}
			
			if (!intestatarioMatcher.matches()) {
				p.mostraMessaggioErrore("Inserire il nome dell'intestatario \ncome riportato sulla carta");
				return false;
			}
			
			
			
		}else if (p.getTipoPagamentoScelto()==2) {
			setTipoPagamento("Bonifico"); 
		}else if (p.getTipoPagamentoScelto()==3) {
			setTipoPagamento("Contrassegno"); 
			return true;
		}
		return true;
		
	}

	/**
	 * @return  the pagamentoPanel
	 * @uml.property  name="pagamentoPanel"
	 */
	public PagamentoPanel getPagamentoPanel() {
		return pagamentoPanel;
	}

	/**
	 * @param pagamentoPanel  the pagamentoPanel to set
	 * @uml.property  name="pagamentoPanel"
	 */
	public void setPagamentoPanel(PagamentoPanel pagamentoPanel) {
		this.pagamentoPanel = pagamentoPanel;
	}

	/**
	 * @return  the tipoPagamento
	 * @uml.property  name="tipoPagamento"
	 */
	public String getTipoPagamento() {
		return tipoPagamento;
	}

	/**
	 * @param tipoPagamento  the tipoPagamento to set
	 * @uml.property  name="tipoPagamento"
	 */
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	

}
