package co.eeikee.desconto;

public class CalculadoraDescontoSegundaFaixa extends CalculardoraFaixaDesconto{

	public CalculadoraDescontoSegundaFaixa(CalculardoraFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if(valorTotal > 800.0 && valorTotal <= 1000.0) {
			return valorTotal * 0.06;
		}
		return -1;
	}

}
