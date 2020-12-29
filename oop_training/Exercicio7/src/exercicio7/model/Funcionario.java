package exercicio7.model;

public abstract class Funcionario {
	String nome;
	int idade;
	double salario;

	public Funcionario(String nome, int idade, double salario) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
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

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double bonificacao() {
		return salario;
	}

	@Override
	public String toString() {
		return "Funcionario\nnome: " + nome + "\nidade: " + idade + " anos\nsalario: R$ " + bonificacao() + "\n";
	}

}
