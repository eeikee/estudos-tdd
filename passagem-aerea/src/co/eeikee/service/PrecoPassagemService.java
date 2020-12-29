package co.eeikee.service;

import co.eeikee.Passageiro;
import co.eeikee.Voo;

public class PrecoPassagemService {

	public double calcular(Passageiro passageiro, Voo voo) {
		return passageiro.getTipo().getCalculadora().Calcular(voo);
	}
}
