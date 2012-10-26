package azienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modello.Cliente;
import modello.Computer;
import modello.Desktop;
import modello.Laptop;
import modello.Ordine;
import modello.Pagamento;
import modello.Server;

public class LogControllerAzienda implements ActionListener{
	LogAzienda logAzienda;

	public LogControllerAzienda(LogAzienda logAzienda) {
		this.logAzienda = logAzienda;
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Entra")){
			String[] impiegato = new String[3];
			int id = Integer.parseInt(logAzienda.getTxtUser());
			String psw=String.valueOf(logAzienda.getTxtPassword());
			if(psw.compareTo("")!=0 && logAzienda.getTxtUser().compareTo("")!=0){
				try {
					impiegato = logAzienda.getGestioneOrdine().getDb().cercaDipendente(id, psw);
					Ordine[] ordini = enlistaOrdini();
					logAzienda.getGestioneOrdine().mostraPanelPrincipale(impiegato[0], impiegato[1], impiegato[2], ordini);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		
	}
	
	private Ordine[] enlistaOrdini(){
		Ordine[] ordini;//Dichiarazione delle ordine
		
		String [][] risultato = logAzienda.getGestioneOrdine().getDb().cercaOrdinePerSpedizione();
		ordini = new Ordine[risultato.length];
		Computer[] computer = new Computer[risultato.length];
		Pagamento[] pagamento = new Pagamento[risultato.length];
		//Componente[] componente = new Componente[risultato.length];
		int j;
		for (j = 0; j<risultato.length; j++){//[rows][columns]
			//Inizializzare variabile con dati pescati dal db nel pasizione: ordini.codice, ordini.data, ordini.totale, stato, tipo, nome_computer, numPagamento
			int codiceOrdine = Integer.parseInt(risultato[j][0]);
			String dataOrdine = risultato[j][1];
			float totalePagato = new Float(risultato[j][2]);
			String statoOrdine = risultato[j][3];
			String tipoPagamento = risultato[j][4];
			String nomeComputer = risultato[j][5];
			int numPagamento = Integer.parseInt(risultato[j][6]);
			String cfCliente = risultato[j][7];
			
			
			//Del cliente
			String[] clienteDb= logAzienda.getGestioneOrdine().getDb().cercaCliente(cfCliente);
			String nome = clienteDb[1];
			String cognome = clienteDb[2];
			String indirizzo = clienteDb[3];
			String telefono = clienteDb[4];
			
			Cliente cliente = new Cliente(cfCliente, nome, cognome, "", "", indirizzo, telefono);
			//Creo i computer ordinati 
			String tipoComputer = nomeComputer.substring(0, 3);
			if (tipoComputer.compareTo("SER")==0){
				computer[j] = new Server(nomeComputer);
			}else if (tipoComputer.compareTo("LAP")==0){
				computer[j] = new Laptop(nomeComputer);
			}else if (tipoComputer.compareTo("DES")==0){
				computer[j] = new Desktop(nomeComputer);
			}
			
			//Creo ordine e pagamento
			ordini[j] = new Ordine(codiceOrdine, computer[j], totalePagato, cliente );
			pagamento[j] = new Pagamento(ordini[j], tipoPagamento, numPagamento);
			ordini[j].setPagamento(pagamento[j]);
			ordini[j].setStato(statoOrdine);
			ordini[j].setData(dataOrdine);
		}
		
		return ordini;
	}

}
