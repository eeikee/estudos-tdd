package exercicio3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import exercicio3.model.Guerreiro;
import exercicio3.model.Mago;

public class RPGTest {

	private List<String> magiasMago1 = new ArrayList<>();
	private List<String> habilidadesGuerreiro1 = new ArrayList<>();
	private Mago mago;
	private Guerreiro guerreiro; 
	
	@Before
	public void setup() {
		
		guerreiro = new Guerreiro("Hank", 70, 20, 3000, 50, 100, 30, habilidadesGuerreiro1);
		mago = new Mago("Mestre dos magos", 1000, 1000, 1000000, 1000, 10, 1000, magiasMago1);	
		
		mago.aprenderMagia("Adivinhação");
		mago.aprenderMagia("Templo Dos Deuses");
		mago.aprenderMagia("Tentáculos Negros De Evard");
		
		guerreiro.aprenderHabilidade("Raiva");
		guerreiro.aprenderHabilidade("Ataque triplo");
		guerreiro.aprenderHabilidade("Força vital");
	}
	
	@Test
	public void lvlUpMago() throws Exception {
		mago.lvlUp();
		assertEquals(1003, mago.getMana());
	}
	
	@Test
	public void lvlUpGuerreiro() throws Exception {
		guerreiro.lvlUp();
		assertEquals(21, guerreiro.getMana());
	}
	
	@Test
	public void attackGuerreiro() throws Exception {
		int random = guerreiro.generate();
		assertEquals(3000 + random, guerreiro.attack(random));
	}
	
	@Test
	public void attackMago() throws Exception {
		int random = mago.generate();
		assertEquals(1000000 + random, mago.attack(random));
	}
}
