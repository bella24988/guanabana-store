package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PagamentoController implements ActionListener{
	
	private PagamentoPanel pagamentoPanel;
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
			
		}else if (e.getActionCommand().equalsIgnoreCase("contrasegno")){
			pagamentoPanel.getPanelContrasegno().setVisible(true);
			pagamentoPanel.getPanelCartaCredito().setVisible(false);
			pagamentoPanel.getPanelBonifico().setVisible(false);
			pagamentoPanel.setTipoPagamentoScelto(3);
			
		}else if (e.getActionCommand().equalsIgnoreCase("accetta")){
			if(pagamentoPanel.getContenutoPanel().getClienteLogato()!=null){
				
				Client client = new Client();
				
				switch (pagamentoPanel.getTipoPagamentoScelto()) {
					case 0: pagamentoPanel.mostraMessaggioErrore();
					
					case 1:	{setTipoPagamento("Carta di Credito");}						
					case 2: {setTipoPagamento("Bonifico"); }
					case 3: {setTipoPagamento("Contrasegno"); }
						
						try {
							client.registrarePagamento(pagamentoPanel.getContenutoPanel().getOrdine(), getTipoPagamento());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}else{
				
			}
			
		}		
	}

	/**
	 * @return the pagamentoPanel
	 */
	public PagamentoPanel getPagamentoPanel() {
		return pagamentoPanel;
	}

	/**
	 * @param pagamentoPanel the pagamentoPanel to set
	 */
	public void setPagamentoPanel(PagamentoPanel pagamentoPanel) {
		this.pagamentoPanel = pagamentoPanel;
	}

	/**
	 * @return the tipoPagamento
	 */
	public String getTipoPagamento() {
		return tipoPagamento;
	}

	/**
	 * @param tipoPagamento the tipoPagamento to set
	 */
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	

}
