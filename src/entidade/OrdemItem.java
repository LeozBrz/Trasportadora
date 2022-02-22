package entidade;

public class OrdemItem {
	private int qtd;
	private Double preco;
	private Produto produto;
	
	public OrdemItem() {
	}
	
	public OrdemItem(int qtd, Double preco, Produto produto) {
		super();
		this.qtd = qtd;
		this.preco = preco;
		this.produto = produto;
	}

	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public int getQtd() {
		return qtd;
	}
	
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	public Double getPrice() {
		return preco;
	}
	
	public void setPrice(Double price) {
		this.preco = price;
	}
	
	public double subTotal() {
		return preco * qtd;
	}
	
	public String toString() {
		return produto.getNomeProd() 
				+ ", $" 
				+ String.format("%.2f", preco) 
				+ ", Quantidade: " 
				+ qtd + 
				", Subtotal: $" 
				+ String.format("%.2f", subTotal());
	
	}
}
