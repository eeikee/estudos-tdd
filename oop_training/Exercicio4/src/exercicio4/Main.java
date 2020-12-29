package exercicio4;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Pessoa> pessoas = new ArrayList<>();

		Pessoa p1 = new Pessoa("João", 15);
		Pessoa p2 = new Pessoa("Leandro", 21);
		Pessoa p3 = new Pessoa("Paulo", 17);
		Pessoa p4 = new Pessoa("Jessica", 18);

		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3);
		pessoas.add(p4);

		System.out.println(Pessoa.maisVelha(pessoas));

		System.out.println(Pessoa.quantidadePessoas(pessoas));

		Pessoa.removeMenorDeIdade(pessoas);

		Pessoa.isJessica(pessoas);
		System.out.println(Pessoa.quantidadePessoas(pessoas));

	}
}
