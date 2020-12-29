package co.eeikee.desconto;

public class CalculadoraSemDesconto extends CalculardoraFaixaDesconto{

	public CalculadoraSemDesconto(CalculardoraFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		return 0;
	}
}
