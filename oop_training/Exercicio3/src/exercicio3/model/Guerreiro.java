package exercicio3.model;

import java.util.ArrayList;
import java.util.List;

public class Guerreiro extends Personagem {

	List<String> habilidade = new ArrayList<>();

	public Guerreiro(String nome, int vida, int mana, float xp, int inteligencia, int forca, int level,
			List<String> habilidade) {
		super(nome, vida, mana, xp, inteligencia, forca, level);
		this.habilidade = habilidade;
	}

	public List<String> getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(List<String> habilidade) {
		this.habilidade = habilidade;
	}

	public void aprenderHabilidade(String habilidade) {
		getHabilidade().add(habilidade);
	}

	@Override
	public void lvlUp() {
		super.lvlUp();
		setForca(getForca() + 2);
		setVida(getVida() + 2);
	}

	@Override
	public int attack() {
		return getForca() * getLevel() + random.nextInt(300);
	}

	public int attack(int randomNumber) {
		return getForca() * getLevel() + randomNumber;
	}

	@Override
	public String toString() {
		return "Guerreiro\nnome: " + nome + "\nvida: " + vida + "\nmana: " + mana + "\nxp: " + xp + "\ninteligencia: "
				+ inteligencia + "\nforca: " + forca + "\nlevel: " + level + "\n";
	}
}
