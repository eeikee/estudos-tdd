package co.eeikee.repository;

import co.eeikee.model.Pedido;
import co.eeikee.service.AcaoLancamentoPedido;

public class PedidosRepository implements AcaoLancamentoPedido {

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Salvando no banco de dados");
	}
	
	public Pedido buscarPeloCodigo(Long codigo) {
		return new Pedido();
	}

}
