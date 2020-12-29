package exercicio7.model;

public class Vendedor extends Funcionario {
	public Vendedor(String nome, int idade, double salario) {
		super(nome, idade, salario);
	}

	@Override
	public double bonificacao() {
		return super.bonificacao() + 3000.00;
	}

	@Override
	public String toString() {
		return "Vendedor\nnome: " + nome + "\nidade: " + idade + " anos \nsalario: R$ " + bonificacao() + "\n";
	}
}
