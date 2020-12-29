package co.eeikee;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.eeikee.desconto.CalculadoraDescontoPrimeiraFaixa;
import co.eeikee.desconto.CalculadoraDescontoSegundaFaixa;
import co.eeikee.desconto.CalculadoraDescontoTerceiraFaixa;
import co.eeikee.desconto.CalculadoraSemDesconto;
import co.eeikee.desconto.CalculardoraFaixaDesconto;

public class PedidoTest {

	private PedidoBuilder pedido;

	@Before
	public void setup() {
		pedido = new PedidoBuilder();
	}

	@Test
	public void adicionarPedido() throws Exception {
		pedido.comItem(3.0, 10);
	}

	@Test
	public void calcularValorTotalEDesconto() throws Exception {
		assertResumoPedido(0.0, 0.0);
	}

	private void assertResumoPedido(double esperado, double desconto) {
		ResumoPedido resumoPedido = pedido.contruir().resumo();
		assertEquals(esperado, resumoPedido.getValorTotal(), 0.0001);
		assertEquals(desconto, resumoPedido.getDesconto(), 0.0001);
		assertEquals(new ResumoPedido(esperado, desconto), resumoPedido);
	}

	@Test
	public void valorTotalDiferentedeZero() throws Exception {
		pedido.comItem(5.0, 5);
		assertResumoPedido(25.0, 0.0);
	}

	@Test
	public void calcularResumoDoisItensSemDesconto() throws Exception {
		pedido.comItem(3.0, 3).comItem(7.0, 3);
		assertResumoPedido(30.0, 0.0);
	}

	@Test
	public void aplicarDesconto1Faixa() throws Exception {
		pedido.comItem(20.0, 20);
		assertResumoPedido(400, 16.0);
	}

	@Test
	public void aplicatDesconto2Faixa() throws Exception {
		pedido.comItem(15.0, 30).comItem(15.0, 30);
		assertResumoPedido(900.0, 54.0);
	}

	@Test
	public void aplicaDesconto3Faixa() throws Exception {
		pedido.comItem(15.0, 30).comItem(15.0, 30).comItem(10.0, 30);
		assertResumoPedido(1200.0, 96.0);
	}
	
	@Test(expected = QuantidadeItensInvalidaException.class)
	public void naoAceitarPedidoItemQuantidadeNegativa() throws Exception {
			pedido.comItem(0.0, -1);	
	} 
}
