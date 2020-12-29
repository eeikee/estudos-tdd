package exercicio1.model;

import exercicio1.exceptions.CarroDesligadoException;
import exercicio1.exceptions.CarroLigadoException;
import exercicio1.exceptions.CombustivelValorInvalidoException;

public class Veiculo {
	private String marca;
	private String modelo;
	private String placa;
	private String cor;
	private float km;
	private boolean isLigado;
	private int litrosCombustivel;
	private int velocidade;
	private double preco;

	public Veiculo(String marca, String modelo, String placa, String cor, double preco) {
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.km = 0.0f;
		this.isLigado = false;
		this.litrosCombustivel = 0;
		this.velocidade = 0;
		this.preco = preco;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		if (!isLigado) {
			this.cor = cor;
		}
	}

	public float getKm() {
		return km;
	}

	public void setKm(float km) {
		this.km = km;
	}

	public boolean isLigado() {
		return isLigado;
	}

	public void setLigado(boolean isLigado) {
		this.isLigado = isLigado;
	}

	public int getLitrosCombustivel() {
		return litrosCombustivel;
	}

	public void setLitrosCombustivel(int litrosCombustivel) {
		this.litrosCombustivel = litrosCombustivel;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void acelerar() {
		if (isLigado && getLitrosCombustivel() > 0) {
			setVelocidade(getVelocidade() + 20);
		}
	}

	public void abastecer(int combutivel) {
		if (!isLigado) {
			if (getLitrosCombustivel() + combutivel <= 60 && combutivel > 0) {
				setLitrosCombustivel(getLitrosCombustivel() + combutivel);
			} else {
				throw new CombustivelValorInvalidoException();
			}
		} else {
			throw new CarroLigadoException();
		}
	}

	public void frear() {
		if (isLigado && getVelocidade() > 0) {
			setVelocidade(getVelocidade() - 20);
		} else {
			throw new CarroDesligadoException();
		}
	}

	public void pintar(String cor) {
		setCor(cor);
	}

	public void ligar() {
		if (!isLigado) {
			setLigado(true);
		} else {
			throw new CarroLigadoException();
		}
	}

	public void desligar() {
		if (isLigado) {
			if (getVelocidade() == 0) {
				setLigado(false);
			}
		} else {
			throw new CarroDesligadoException();
		}
	}

	@Override
	public String toString() {
		return "Veiculo\nmarca: " + marca + "\nmodelo: " + modelo + "\nplaca: " + placa + "\ncor: " + cor + "\nkm: "
				+ km + "\nisLigado: " + isLigado + "\nlitrosCombustivel: " + litrosCombustivel + "\nvelocidade: "
				+ velocidade + "\npreco: " + preco + "\n";
	}

}
