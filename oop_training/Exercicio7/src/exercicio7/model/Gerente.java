package exercicio7.model;

public class Gerente extends Funcionario {

	public Gerente(String nome, int idade, double salario) {
		super(nome, idade, salario);
	}

	@Override
	public double bonificacao() {
		return super.bonificacao() + 10000.00;
	}

	@Override
	public String toString() {
		return "Gerente\nnome: " + nome + "\nidade: " + idade + " anos\nsalario: R$ " + bonificacao() + "\n";
	}
}
