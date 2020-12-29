package co.eeikee.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.eeikee.Passageiro;
import co.eeikee.TipoPassageiro;
import co.eeikee.Voo;

public class PrecoPassagemServiceTest {

	PrecoPassagemService pps;

	@Before
	public void setup() {
		pps = new PrecoPassagemService();
	}

	private void assertValorPassagem(Passageiro passageiro, Voo voo, double esperado) {
		double valor = pps.calcular(passageiro, voo);
		assertEquals(esperado, valor, 0.0001);
	}
	
	@Test
	public void calcularValorPassagemPassageiroGoldValorAbaixoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		assertValorPassagem(passageiro, voo, 90.0);
	}
	
	@Test
	public void calcularValorPassagemPassageiroGoldValorAcimaLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 600.0);
		assertValorPassagem(passageiro, voo, 510.0);
	}

	@Test
	public void calcularValorPassagemPassageiroSilverAbaixoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		assertValorPassagem(passageiro, voo, 94.0);
	}
	
	@Test
	public void calcularValorPassagemPassageirosSilverValorAcimaLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 800.0);
		assertValorPassagem(passageiro, voo, 720.0);
	}
}
