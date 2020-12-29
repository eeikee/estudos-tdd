package exercicio3;

import java.util.List;

import exercicio3.model.Guerreiro;
import exercicio3.model.Mago;
import exercicio3.model.Personagem;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		List<String> magiasMago1 = new ArrayList<>();
		Mago mago1 = new Mago("Mestre dos magos", 1000, 1000, 1000000, 1000, 10, 1000, magiasMago1);
		mago1.aprenderMagia("Adivinhação");
		mago1.aprenderMagia("Templo Dos Deuses");
		mago1.aprenderMagia("Tentáculos Negros De Evard");

		List<String> habilidadesGuerreiro1 = new ArrayList<>();
		Guerreiro guerreiro1 = new Guerreiro("Hank", 70, 20, 3000, 50, 100, 30, habilidadesGuerreiro1);
		guerreiro1.aprenderHabilidade("Raiva");
		guerreiro1.aprenderHabilidade("Ataque triplo");
		guerreiro1.aprenderHabilidade("Força vital");

		System.out.println(mago1.toString());
		System.out.println(guerreiro1.toString());

		System.out.println("\n" + mago1.getNome() + " Attack: " + mago1.attack());
		System.out.println("\n" + guerreiro1.getNome() + "Attack: " + guerreiro1.attack() + "\n");

		mago1.lvlUp();
		guerreiro1.lvlUp();

		System.out.println(mago1.toString());
		System.out.println(guerreiro1.toString());

		System.out.println("\n" + mago1.getNome() + " Attack: " + mago1.attack());
		System.out.println("\n" + guerreiro1.getNome() + "Attack: " + guerreiro1.attack() + "\n");

		System.out.println(Personagem.quantidade());
	}

}
