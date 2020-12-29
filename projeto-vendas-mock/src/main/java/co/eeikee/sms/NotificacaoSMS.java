package co.eeikee.sms;

import co.eeikee.model.Pedido;
import co.eeikee.service.AcaoLancamentoPedido;

public class NotificacaoSMS implements AcaoLancamentoPedido {

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Enviando mensagem SMS (" + pedido.toString() + "...");
	}
}
