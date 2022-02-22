package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.Cliente;
import entidade.Ordem;
import entidade.OrdemItem;
import entidade.Produto;
import entidade.enums.StatusOrdem;

public class Programa {
	
	
	public static void main(String[] args) throws ParseException {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	System.out.println("DIGITE OS DADOS DO CLIENTE: ");
	System.out.print("Nome:");
	String nome =sc.nextLine();
	System.out.print("Email: ");
	String email = sc.next();
	System.out.print("Data de Nascimento (DD/MM/AAAA):");
	Date dataNasc = sdf.parse(sc.next());
	Cliente cliente = new Cliente(nome, email, dataNasc);
	
	System.out.println("\nDIGITE OS DADOS DA ORDEM:");
	System.out.print("Status PAGAMENTO_PENDENTE,\r\n"
			+ "	PROCESSANDO,\r\n"
			+ "	ENVIADO,\r\n"
			+ "	ENTREGUE): ");
	StatusOrdem status = StatusOrdem.valueOf(sc.next());
	Ordem ordem = new Ordem(new Date(), status, cliente);
	System.out.print("Quantos itens para essa ordem? ");
	int item = sc.nextInt();

	
	for(int i=0; i<item; i++) { 
	System.out.println("ENTRE COM O " + (i+1) + "º ITEM:");
	System.out.print("Nome do Produto: ");
	sc.next();
	String nomeProd = sc.nextLine();
	System.out.print("Preco do Produto: ");
	Double precoProd = sc.nextDouble();
	Produto prod = new Produto(nomeProd,precoProd);
	System.out.print("Quantidade: ");
	int qtd = sc.nextInt();
	OrdemItem ordemItem = new OrdemItem(qtd, precoProd, prod);
	ordem.addItem(ordemItem);
	}
	System.out.println();
	System.out.println("SUMÁRIO DA ORDEM:");
	System.out.println(ordem);
	sc.close();
}
}