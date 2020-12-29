package exercicio2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import exercicio2.exceptions.ListaVaziaException;
import exercicio2.model.Livro;
import exercicio2.model.Loja;
import exercicio2.model.VideoGame;

public class ECommerceTest {

	private VideoGame vg;
	private Livro lv;
	private Loja loja;
	private List<VideoGame> videoGames;
	private List<Livro> livros;

	@Before
	public void setup() {
		livros = new ArrayList<Livro>();
		videoGames = new ArrayList<VideoGame>();
		lv = new Livro("Harry Potter", 40, 50, "J. k. Rowling", "fantasia", 300);
		livros.add(lv);
		vg = new VideoGame("PS4", 2000.00, 5, "Sony", "Slim", true);
		videoGames.add(vg);
		loja = new Loja("Americanas", "12345678", livros, videoGames);
	}

	@Test
	public void calcularImpostoGameUsado() throws Exception {
		assertEquals(500, vg.calcularImposto(), 0.0001);
	}

	@Test
	public void calcularImpostoGameNovo() throws Exception {
		vg.setUsado(false);
		assertEquals(900, vg.calcularImposto(), 0.0001);
	}

	@Test(expected = ListaVaziaException.class)
	public void somenteListarLivrosSeNaoEstiverVazio() throws Exception {
		loja.getLivros().clear();
		loja.listaLivros();
	}

	@Test
	public void listarLivros() throws Exception {
		loja.listaLivros();
		assertEquals(false, loja.getLivros().isEmpty());
	}

	@Test(expected = ListaVaziaException.class)
	public void somenteListarGamesSeNaoEstiverVazio() throws Exception {
		loja.getVideoGames().clear();
		loja.listaVideoGames();
	}

	@Test
	public void listarGames() throws Exception {
		loja.listaVideoGames();
		assertEquals(false, loja.getVideoGames().isEmpty());
	}

	@Test(expected = ListaVaziaException.class)
	public void somenteCalcularPatrimonioSeTiverPatrimonio() throws Exception {
		loja.getLivros().clear();
		loja.getVideoGames().clear();
		loja.calcularPatrimonios();
	}

	@Test
	public void calcularalcularPatrimonioLivros() throws Exception {
		loja.getVideoGames().clear();
		assertEquals(2000.00, loja.calcularPatrimonios(), 0.0001);
	}
	
	@Test
	public void calcularalcularPatrimonioGames() throws Exception {
		loja.getLivros().clear();
		assertEquals(10000.00, loja.calcularPatrimonios(), 0.0001);
	}
	
	@Test
	public void calcularImpostoLivroEducativo() throws Exception {
		lv.setTema("educativo");
		assertEquals(0, lv.calcularImposto(), 0);
	}
	
	@Test
	public void calcularImpostoDemaisLivros() throws Exception {
		assertEquals(4.0, lv.calcularImposto(), 0);
	}

}
