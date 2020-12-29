package co.eeikee.desconto;

public class CalculadoraDescontoPrimeiraFaixa extends CalculardoraFaixaDesconto{

	public CalculadoraDescontoPrimeiraFaixa(CalculardoraFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if(valorTotal > 300.0 && valorTotal <= 800.0) {
			return valorTotal * 0.04;
		}
		return -1;
	}

}
