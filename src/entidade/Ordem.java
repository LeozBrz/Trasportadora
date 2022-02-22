package entidade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidade.enums.StatusOrdem;

public class Ordem {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date momento;
	private StatusOrdem status;
	private Cliente cliente;
	private List<OrdemItem> item = new ArrayList<>();
	
	public Ordem() {
	}
	
	
	public Ordem(Date momento, StatusOrdem status, Cliente cliente) {
		super();
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}


	public Ordem(StatusOrdem status) {
		this.status = status;
	}




	public Date getMomento() {
		return momento;
	}


	public void setMomento(Date momento) {
		this.momento = momento;
	}


	public StatusOrdem getStatus() {
		return status;
	}


	public void setStatus(StatusOrdem status) {
		this.status = status;
	}


	public List<OrdemItem> getItem() {
		return item;
	}


	public void setItem(List<OrdemItem> item) {
		this.item = item;
	}


	public void addItem(OrdemItem item) {
		this.item.add(item);
	}
	
	public void removeItem(OrdemItem item){
		this.item.remove(item);
	}
	public double total() {
		double sum = 0.0;
		for (OrdemItem item : item) {
			sum += item.subTotal();
		}
		return sum;	
	}	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Momento da Ordem: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("Status da Ordem: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Ordem de items:\n");
		for (OrdemItem item : item) {
			sb.append(item + "\n");
		}
		sb.append("Preco Total: R$");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}