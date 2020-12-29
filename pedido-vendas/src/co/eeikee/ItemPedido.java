package co.eeikee;

public class ItemPedido {
	private String descricao;
	private double valorUnitario;
	private int quantidade;

	public ItemPedido(String descricao, double valorMonetario, int quantidade) {
		this.descricao = descricao;
		this.valorUnitario = valorMonetario;
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorMonetario() {
		return valorUnitario;
	}

	public void setValorMonetario(double valorMonetario) {
		this.valorUnitario = valorMonetario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}