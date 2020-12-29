package exercicio2.model;

public class Livro extends Produto {

	private String autor;
	private String tema;
	private int qtdPag;

	public Livro(String nomeString, double preco, int qtd, String autor, String tema, int qtdPag) {
		super(nomeString, preco, qtd);
		this.autor = autor;
		this.tema = tema;
		this.qtdPag = qtdPag;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getQtdPag() {
		return qtdPag;
	}

	public void setQtdPag(int qtdPag) {
		this.qtdPag = qtdPag;
	}

	@Override
	public double calcularImposto() {
		return getPreco() * (getTema().equals("educativo") ? 0 : 0.1);
	}

	@Override
	public String ImpostoToString() {
		return "R$ " + calcularImposto() + " imposto sobre o livro " + getNomeString() + ".";
	}

	@Override
	public String ListToString() {
		return "Titulo: " + nome + ", preco: " + preco + ", quantidade: " + qtd + " em estoque.";
	}

}
