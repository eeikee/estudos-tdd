package co.eeikee;

import co.eeikee.desconto.CalculadoraDescontoPrimeiraFaixa;
import co.eeikee.desconto.CalculadoraDescontoSegundaFaixa;
import co.eeikee.desconto.CalculadoraDescontoTerceiraFaixa;
import co.eeikee.desconto.CalculadoraSemDesconto;
import co.eeikee.desconto.CalculardoraFaixaDesconto;

public class PedidoBuilder {
	private Pedido instancia;

	public PedidoBuilder() {
		CalculardoraFaixaDesconto calculardoraFaixaDesconto = 
				new CalculadoraDescontoTerceiraFaixa(
					new CalculadoraDescontoSegundaFaixa(
						new CalculadoraDescontoPrimeiraFaixa(
							new CalculadoraSemDesconto(null))));
		instancia = new Pedido(calculardoraFaixaDesconto);
	}
	
	public PedidoBuilder comItem(double valorUnitario, int quantidade) {
		instancia.adicionarItem(new ItemPedido("Sabonete", valorUnitario, quantidade));
		return this;
	}
	
	public Pedido contruir() {
		return instancia;
	}
}
