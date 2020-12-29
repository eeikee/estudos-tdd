package exercicio3.model;

import java.util.List;
import java.util.ArrayList;

public class Mago extends Personagem {
	private List<String> magia = new ArrayList<>();

	public Mago(String nome, int vida, int mana, float xp, int inteligencia, int forca, int level, List<String> magia) {
		super(nome, vida, mana, xp, inteligencia, forca, level);
		this.magia = magia;
	}

	public List<String> getMagia() {
		return magia;
	}

	public void setMagia(List<String> magia) {
		this.magia = magia;
	}

	@Override
	public void lvlUp() {
		super.lvlUp();
		setInteligencia(getInteligencia() + 2);
		setMana(getMana() + 2);
	}

	public void aprenderMagia(String magia) {
		getMagia().add(magia);
	}

	@Override
	public int attack() {
		return getInteligencia() * getLevel() + random.nextInt(300);
	}
	
	public int attack(int randomNumber) {
		return getInteligencia() * getLevel() + randomNumber;
	}

	@Override
	public String toString() {
		return "Mago\nnome: " + nome + "\nvida: " + vida + "\nmana: " + mana + "\nxp: " + xp + "\ninteligencia: "
				+ inteligencia + "\nforca: " + forca + "\nlevel: " + level + "\n";
	}
}
