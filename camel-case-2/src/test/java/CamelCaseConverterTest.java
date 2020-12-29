import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CamelCaseConverterTest {
	
	CamelCaseConverter camelCase;
	
	@Before
	public void setup() {
		camelCase = new CamelCaseConverter();
	}
	
	@Test
	public void aplicatCamelCaseNomeUnico() throws Exception {
		assertEquals("Lionel", camelCase.converter("lionel"));
	}
	
	public void deveConverterNomeMisturadoMaiusculoMinusculo() {
		assertEquals("Lionel", camelCase.converter("LiONeL"));
	}
}
