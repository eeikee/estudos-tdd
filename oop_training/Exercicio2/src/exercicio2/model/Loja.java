package exercicio2.model;

import java.util.ArrayList;

import java.util.List;

import exercicio2.exceptions.ListaVaziaException;

public class Loja {
	private String nomeString;
	private String cnpjString;
	private List<Livro> livros = new ArrayList<>();
	private List<VideoGame> videoGames = new ArrayList<>();
	private double patriminio;

	public Loja(String nomeString, String cnpjString, List<Livro> livros, List<VideoGame> videoGames) {
		this.nomeString = nomeString;
		this.cnpjString = cnpjString;
		this.livros = livros;
		this.videoGames = videoGames;
	}

	public String getNomeString() {
		return nomeString;
	}

	public void setNomeString(String nomeString) {
		this.nomeString = nomeString;
	}

	public String getCnpjString() {
		return cnpjString;
	}

	public void setCnpjString(String cnpjString) {
		this.cnpjString = cnpjString;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<VideoGame> getVideoGames() {
		return videoGames;
	}

	public void setVideoGames(List<VideoGame> videoGames) {
		this.videoGames = videoGames;
	}

	public double getPatriminio() {
		return patriminio;
	}

	public void setPatriminio(double patriminio) {
		this.patriminio = patriminio;
	}

	public void listaLivros() {
		if (getLivros().isEmpty()) {
			System.out.println("A loja não tem livros no seu estoque.");
			throw new ListaVaziaException();
		} else {
			System.out.println("A loja " + getNomeString() + " possui estes livros para venda:\n");
			for (Livro livro : livros) {
				System.out.println(livro.ListToString());
			}
		}
	}

	public void listaVideoGames() {
		if (getVideoGames().isEmpty()) {
			System.out.println("A loja não tem video-games no seu estoque.");
			throw new ListaVaziaException();
		} else {
			System.out.println("A loja " + getNomeString() + " possui estes video-games para venda:\n");
			for (VideoGame videoGame : videoGames) {
				System.out.println(videoGame.ListToString());
			}
		}
	}

	public double calcularPatrimonios() {
		if (!(getLivros().isEmpty() && getVideoGames().isEmpty())) {
			if (!getLivros().isEmpty()) {
				for (Livro livro : livros) {
					setPatriminio(getPatriminio() + (livro.getPreco() * livro.getQtd()));
				}
			}

			if (!getVideoGames().isEmpty()) {
				for (VideoGame videoGame : videoGames) {
					setPatriminio(getPatriminio() + (videoGame.getPreco() * videoGame.getQtd()));
				}
			}
		}
		else {
			throw new ListaVaziaException();
		}
		return patriminio;
	}

	public String patrimonioToString() {
		return "O patrimonio da loja: " + getNomeString() + "é de R$ " + +calcularPatrimonios();
	}

}
