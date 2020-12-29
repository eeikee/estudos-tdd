package exercicio2.model;

public class VideoGame extends Produto {

	private String marca;
	private String modelo;
	private boolean isUsado;

	public VideoGame(String nome, double preco, int qtd, String marca, String modelo, boolean isUsado) {
		super(nome, preco, qtd);
		this.marca = marca;
		this.modelo = modelo;
		this.isUsado = isUsado;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public boolean isUsado() {
		return isUsado;
	}

	public void setUsado(boolean isUsado) {
		this.isUsado = isUsado;
	}

	@Override
	public double calcularImposto() {
		return getPreco() * (isUsado() ? 0.25 : 0.45);
	}

	@Override
	public String ImpostoToString() {
		return "Imposto " + getNomeString() + (isUsado() ? " Usado " : " ") + getModelo() + ", R$ " + calcularImposto()
				+ ".";
	}

	@Override
	public String ListToString() {
		return "Video-game: " + nome + ", preco: " + preco + ", quantidade: " + qtd + " em estoque.";
	}
}
