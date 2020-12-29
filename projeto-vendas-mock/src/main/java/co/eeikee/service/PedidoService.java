package co.eeikee.service;

import java.util.List;

import co.eeikee.model.Pedido;
import co.eeikee.model.StatusPedido;
import co.eeikee.repository.PedidosRepository;

public class PedidoService {
	
	private List<AcaoLancamentoPedido> acoes;
	private PedidosRepository pr;

	public PedidoService(PedidosRepository pr, List<AcaoLancamentoPedido> acoes) {
		this.acoes = acoes;
		this.pr = pr;
	}

	public double lancar(Pedido pedido) {
		double imposto = pedido.getValor() * 0.1;
		
		acoes.forEach(acao -> acao.executar(pedido));

		return imposto;
	}

	public Pedido pagar(Long codigo) {
		Pedido pedido = pr.buscarPeloCodigo(codigo);
		if (!pedido.getStatus().equals(StatusPedido.PENDENTE)) {
			throw new StatusPedidoInvalidoException();
		}
		pedido.setStatus(StatusPedido.PAGO);
		return pedido;
	}

}
