package co.eeikee.projetovendasmock;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import co.eeikee.email.NotificadorEmail;
import co.eeikee.model.Pedido;
import co.eeikee.model.StatusPedido;
import co.eeikee.model.builder.PedidoBuilder;
import co.eeikee.repository.PedidosRepository;
import co.eeikee.service.AcaoLancamentoPedido;
import co.eeikee.service.PedidoService;
import co.eeikee.service.StatusPedidoInvalidoException;
import co.eeikee.sms.NotificacaoSMS;

public class PedidoServiceTest {

	PedidoService pedidoService;

	@Mock
	PedidosRepository pedidos;

	@Mock
	private NotificadorEmail ne;

	@Mock
	private NotificacaoSMS ns;

	private Pedido pedido;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		List<AcaoLancamentoPedido> acoes = Arrays.asList(pedidos,ns, ne);
		pedidoService = new PedidoService(pedidos,acoes);
		pedido = new PedidoBuilder().comValor(100.0).para("João", "joao@joao.com", "9999-0000").construir();
	}

	@Test
	public void calcularImposto() throws Exception {
		double imposto = pedidoService.lancar(pedido);
		assertEquals(10.0, imposto, 0.0001);
	}

	@Test
	public void salvarPedidoNoBancoDeDados() throws Exception {
		Pedido pedido = new PedidoBuilder().comValor(100.0).para("João", "joao@joao.com", "9999-0000").construir();
		pedidoService.lancar(pedido);
		verify(pedidos).executar(pedido);
	}

	@Test
	public void notificarPorEmail() throws Exception {
		pedidoService.lancar(pedido);
		verify(ne).executar(pedido);
	}
	
	@Test
	public void notificarPorSMS() throws Exception {
		pedidoService.lancar(pedido);
		verify(ns).executar(pedido);
	}
	@Test
	public void pagarPedidoPendente() throws Exception {
		Long codigoPedido = 135L;
		Pedido pedidoPendente = new Pedido();
		pedidoPendente.setStatus(StatusPedido.PENDENTE);
		when(pedidos.buscarPeloCodigo(codigoPedido)).thenReturn(pedidoPendente);
		Pedido pedidoPago = pedidoService.pagar(codigoPedido);
		assertEquals(StatusPedido.PAGO, pedidoPago.getStatus());
	}
	
	@Test(expected = StatusPedidoInvalidoException.class)
	public void negarPagamento() throws Exception {
		Long codigoPedido = 135L;
		
		Pedido pedidoPago = new Pedido();
		pedidoPago.setStatus(StatusPedido.PAGO);
		when(pedidos.buscarPeloCodigo(codigoPedido)).thenReturn(pedidoPago);
		pedidoService.pagar(codigoPedido);
	}
}
