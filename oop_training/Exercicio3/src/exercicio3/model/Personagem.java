package exercicio3.model;

import java.util.Random;

public abstract class Personagem {
	String nome;
	int vida;
	int mana;
	float xp;
	int inteligencia;
	int forca;
	int level;
	protected static int quantidade = 0;
	Random random = new Random();

	public Personagem(String nome, int vida, int mana, float xp, int inteligencia, int forca, int level) {
		this.nome = nome;
		this.vida = vida;
		this.mana = mana;
		this.xp = xp;
		this.inteligencia = inteligencia;
		this.forca = forca;
		this.level = level;
		quantidade++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public float getXp() {
		return xp;
	}

	public void setXp(float xp) {
		this.xp = xp;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void lvlUp() {
		setForca(getForca() + 1);
		setInteligencia(getInteligencia() + 1);
		setVida(getVida() + 1);
		setMana(getMana() + 1);
	}

	public int attack() {
		return getLevel() + random.nextInt(300);
	}

	public static String quantidade() {
		return "Quantidade de pesonagens: " + quantidade;
	}

	@Override
	public String toString() {
		return "Personagem\nnome: " + nome + "\nvida: " + vida + "\nmana: " + mana + "\nxp: " + xp + "\ninteligencia: "
				+ inteligencia + "\nforca: " + forca + "\nlevel: " + level + "\n";
	}
	public int generate() {
		return random.nextInt(300);
	}
}
