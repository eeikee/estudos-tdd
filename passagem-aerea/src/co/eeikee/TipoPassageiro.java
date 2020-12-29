package co.eeikee;

import co.eeikee.service.*;

public enum TipoPassageiro {
	GOLD(new PrecoPassagemGold()),
	SILVER(new PrecoPassagemSilver());
	
	CalculadoraPrecoPassagem cpp;

	private TipoPassageiro(CalculadoraPrecoPassagem cpp) {
		this.cpp = cpp;
	}

	public CalculadoraPrecoPassagem getCalculadora() {
		return cpp;
	}
	
}
