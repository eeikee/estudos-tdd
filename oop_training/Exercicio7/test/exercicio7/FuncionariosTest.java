package exercicio7;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exercicio7.model.Gerente;
import exercicio7.model.Supervisor;
import exercicio7.model.Vendedor;

public class FuncionariosTest {
	
	private Gerente gerente1;
	private Supervisor supervisor1;
	private Vendedor vendedor1;
	
	@Before
	public void setup() {
		gerente1 = new Gerente("Leandro", 21, 15000.00);
		supervisor1 = new Supervisor("Jessica", 18, 10000.00);
		vendedor1 = new Vendedor("Paulo", 5, 5000.00);
	}
	
	@Test
	public void bonificacaoGerente() throws Exception {
		assertEquals(25000.00, gerente1.bonificacao(), 0.0001);
	}
	
	@Test
	public void bonificacaoSupervisor() throws Exception {
		assertEquals(15000.00, supervisor1.bonificacao(), 0.0001);
	}
	
	@Test
	public void bonificacaoVendedor() throws Exception {
		assertEquals(8000.00, vendedor1.bonificacao(), 0.0001);
	}
}
