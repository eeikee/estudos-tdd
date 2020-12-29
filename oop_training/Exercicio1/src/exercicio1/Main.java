package exercicio1;

import exercicio1.model.Veiculo;

public class Main {
	public static void main(String[] args) {
		Veiculo veiculo = new Veiculo("Toyota", "Corola Cross", "TYT-1234", "Preto", 120000.00);
		veiculo.abastecer(40);
		System.out.println(veiculo.toString());
		veiculo.ligar();
		System.out.println(veiculo.toString());
		veiculo.acelerar();
		System.out.println(veiculo.toString());
		veiculo.frear();
		System.out.println(veiculo.toString());
		veiculo.desligar();
		System.out.println(veiculo.toString());
		veiculo.pintar("Cinza");
		System.out.println(veiculo.toString());
	}
}
