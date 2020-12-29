package co.eeikee.desconto;

public abstract class CalculardoraFaixaDesconto {

	private CalculardoraFaixaDesconto proximo;

	public CalculardoraFaixaDesconto(CalculardoraFaixaDesconto proximo) {
		this.proximo = proximo;
	}

	public double desconto(double valorTotal) {
		double desconto = calcular(valorTotal);
		
		if(desconto == -1) {
			return proximo.desconto(valorTotal);
		}
		return desconto;
	}

	protected abstract double calcular(double valorTotal);
}
