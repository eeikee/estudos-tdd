package exercicio7.model;

public class Supervisor extends Funcionario {
	public Supervisor(String nome, int idade, double salario) {
		super(nome, idade, salario);
	}

	@Override
	public double bonificacao() {
		return super.bonificacao() + 5000.00;
	}

	@Override
	public String toString() {
		return "Supervisor\nnome: " + nome + "\nidade: " + idade + " anos\nsalario: R$ " + bonificacao() + "\n";
	}
}
