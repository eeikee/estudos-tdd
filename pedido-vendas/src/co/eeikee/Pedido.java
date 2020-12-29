package co.eeikee;

import java.util.ArrayList;
import java.util.List;

import co.eeikee.desconto.CalculardoraFaixaDesconto;

public class Pedido {

	private List<ItemPedido> itens = new ArrayList<ItemPedido>();
	private CalculardoraFaixaDesconto calculardoraFaixaDesconto;

	public void adicionarItem(ItemPedido itemPedido) {
		validarItemPedido(itemPedido);
		itens.add(itemPedido);
	}

	private void validarItemPedido(ItemPedido itemPedido) {
		if(itemPedido.getQuantidade() < 0) {
			throw new QuantidadeItensInvalidaException();
		}
	}

	public Pedido(CalculardoraFaixaDesconto calculardoraFaixaDesconto) {
		this.calculardoraFaixaDesconto = calculardoraFaixaDesconto;
	}

	public ResumoPedido resumo() {
		double valorTotal = itens.stream().mapToDouble(i -> i.getValorMonetario() * i.getQuantidade()).sum();
		double desconto = calculardoraFaixaDesconto.desconto(valorTotal);
		return new ResumoPedido(valorTotal, desconto);
	}

}
