package co.eeikee.service;

import co.eeikee.Voo;

public class PrecoPassagemSilver implements CalculadoraPrecoPassagem {

	@Override
	public double Calcular(Voo voo) {
		if (voo.getPreco() > 700.0) {
			return  calcularValorAcimaDoLimite(voo);
		}
		return calcularValorAbaixoDoLimite(voo);
	}

	private double calcularValorAbaixoDoLimite(Voo voo) {
		return voo.getPreco() * 0.94;
	}

	private double calcularValorAcimaDoLimite(Voo voo) {
		return voo.getPreco() * 0.9;
	}

}
