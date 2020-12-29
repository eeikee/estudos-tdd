package exercicio1;

import static org.junit.Assert.*;

import org.junit.Before;

import exercicio1.exceptions.CarroDesligadoException;
import exercicio1.exceptions.CarroLigadoException;
import exercicio1.exceptions.CombustivelValorInvalidoException;
import exercicio1.model.Veiculo;

import org.junit.Test;

public class VeiculoTest {
	
	private Veiculo veiculo;
	
	@Before
	public void setup() {
		veiculo = new Veiculo("Toyota", "Corola Cross", "TYT-1234", "Preto", 120000.00);
	}
	@Test
	public void naoAcelerarQuandoDesligadoESemCombustivel() throws Exception {
		veiculo.acelerar();
		assertEquals(0,veiculo.getVelocidade());
	}
	
	@Test
	public void naoAcelerarQuandoDesligado() throws Exception {
		veiculo.abastecer(1);
		veiculo.acelerar();
		assertEquals(0,veiculo.getVelocidade());
	}
	
	@Test
	public void naoAcelerarQuandoSemCombustivel() throws Exception {
		veiculo.ligar();
		veiculo.acelerar();
		assertEquals(0,veiculo.getVelocidade());
	}
	
	@Test
	public void somenteAcelerarQuandoLigadoECombutivelMaiorQue0() throws Exception {
		veiculo.abastecer(1);
		veiculo.ligar();
		veiculo.acelerar();
		assertEquals(20,veiculo.getVelocidade());
	}
	
	@Test(expected = CarroLigadoException.class)
	public void somenteAbastecerQuandoDesligado() throws Exception {
		veiculo.abastecer(1);
		veiculo.ligar();
		veiculo.acelerar();
		veiculo.abastecer(1);
		assertEquals(20,veiculo.getVelocidade());
	}
	
	@Test(expected = CombustivelValorInvalidoException.class)
	public void somenteAbastecerQuandoCombustivelMenorQue60() throws Exception {
		veiculo.abastecer(60);
		veiculo.abastecer(1);
		assertEquals(60,veiculo.getLitrosCombustivel());
	}
	
	@Test(expected = CombustivelValorInvalidoException.class)
	public void somenteAbastecerQuandoValorNovoCombustivelMaiorQue0() throws Exception {
		veiculo.abastecer(59);
		veiculo.abastecer(-1);
		assertEquals(59,veiculo.getLitrosCombustivel());
	}
	
	@Test(expected = CombustivelValorInvalidoException.class)
	public void somenteAbastecerQuandoCombustivelSomadoSejaMenorIgualA60() throws Exception {
		veiculo.abastecer(59);
		veiculo.abastecer(2);
		assertEquals(59,veiculo.getLitrosCombustivel());
	}
	
	@Test
	public void abastecerCumprindoTodasAsValidacoes() throws Exception {
		veiculo.abastecer(59);
		veiculo.abastecer(1);
		assertEquals(60,veiculo.getLitrosCombustivel());
	}
	
	@Test(expected = CarroLigadoException.class)
	public void somenteLigarQuandoDesligado() throws Exception {
		veiculo.ligar();
		veiculo.ligar();
	}
	
	@Test(expected = CarroDesligadoException.class)
	public void somenteDesligarQuandoLigado() throws Exception {
		veiculo.desligar();
		assertEquals(true, !veiculo.isLigado());
	}
	
	@Test
	public void somenteDesligarQuandoVelocidadeIgualA0() throws Exception {
		veiculo.abastecer(15);
		veiculo.ligar();
		veiculo.acelerar();
		veiculo.desligar();
		assertEquals(20, veiculo.getVelocidade());
	}
	
	@Test
	public void somenteDesligarQuandoLigadoEVelocidadeIgualA0() throws Exception {
		veiculo.ligar();
		veiculo.desligar();
		assertEquals(true, !veiculo.isLigado());
	}
	
	@Test(expected = CarroDesligadoException.class)
	public void somenteFrearQuandoLigado() throws Exception {
		veiculo.frear();
		assertEquals(false, veiculo.isLigado());
	}
	
	@Test(expected = CarroDesligadoException.class)
	public void somenteFrearQuandoVelocidadeMaiorQue0() throws Exception {
		veiculo.abastecer(15);
		veiculo.ligar();
		veiculo.frear();
		assertEquals(0, veiculo.getVelocidade());
	}
	
	@Test
	public void somenteFrearQuandoLigadoEVelocidadeMaiorQue0() throws Exception {
		veiculo.abastecer(15);
		veiculo.ligar();
		veiculo.acelerar();
		veiculo.frear();
		assertEquals(0, veiculo.getVelocidade());
	}
	
}
