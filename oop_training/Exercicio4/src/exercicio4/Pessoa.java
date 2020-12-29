package exercicio4;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Pessoa {
	String nome;
	int idade;

	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	@Override
	public String toString() {
		return "Pessoa: nome=" + nome + ", idade=" + idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public static String maisVelha(List<Pessoa> pessoas) {
		Pessoa maisVelha = new Pessoa("maisVelha", 0);

		for (Pessoa pessoa : pessoas) {
			if (pessoa.getIdade() > maisVelha.getIdade()) {
				maisVelha.setNome(pessoa.getNome());
				maisVelha.setIdade(pessoa.getIdade());
			}
		}
		return "A pessoa mais velha é: " + maisVelha.getNome();
	}

	public static void isJessica(List<Pessoa> pessoas) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getNome().equals("Jessica")) {
				System.out.println("Jessica possui " + pessoa.getIdade() + " anos.");
			}
		}
	}

	public static String quantidadePessoas(List<Pessoa> pessoas) {
		return "Quantidade de pessoas na lista: " + pessoas.size();
	}

	public static void removeMenorDeIdade(List<Pessoa> pessoas) {
		Iterator<Pessoa> iterator = pessoas.iterator();
		while (iterator.hasNext()) {
			Pessoa pessoa = iterator.next();
			if (pessoa.getIdade() < 18) {
				iterator.remove();
			}
		}

	}

}
