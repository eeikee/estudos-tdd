package exercicio7;

import exercicio7.model.Gerente;
import exercicio7.model.Supervisor;
import exercicio7.model.Vendedor;

public class Main {
	public static void main(String[] args) {
		Gerente gerente1 = new Gerente("Leandro", 21, 15000.00);
		Supervisor supervisor1 = new Supervisor("Jessica", 18, 10000.00);
		Vendedor vendedor1 = new Vendedor("Paulo", 5, 5000.00);

		System.out.println(gerente1.toString());
		System.out.println(supervisor1.toString());
		System.out.println(vendedor1.toString());
	}
}
