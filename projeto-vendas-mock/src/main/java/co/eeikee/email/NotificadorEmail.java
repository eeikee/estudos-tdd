package co.eeikee.email;

import co.eeikee.model.Pedido;
import co.eeikee.service.AcaoLancamentoPedido;

public class NotificadorEmail implements AcaoLancamentoPedido {

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Enviando " + pedido.toString() + "no email ...");
	}
}
