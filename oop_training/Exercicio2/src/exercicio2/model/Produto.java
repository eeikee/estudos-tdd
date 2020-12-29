package exercicio2.model;

public abstract class Produto implements Imposto {
	String nome;
	double preco;
	int qtd;

	public Produto(String nome, double preco, int qtd) {
		this.nome = nome;
		this.preco = preco;
		this.qtd = qtd;
	}

	public String getNomeString() {
		return nome;
	}

	public void setNomeString(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public String ListToString() {
		return "Produto: " + nome + ", preco: " + preco + ", quantidade: " + qtd + " em estoque.\n";
	}

	public String ImpostoToString() {
		return "R$ " + calcularImposto();
	}

}
