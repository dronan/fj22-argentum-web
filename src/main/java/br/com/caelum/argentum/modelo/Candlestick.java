package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candlestick {
	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}

	public boolean isAlta() {
		return this.abertura < this.fechamento;
	}

	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}

	public Candlestick(double abertura, double fechamento, double minimo,
			double maximo, double volume, Calendar data) {

		if (minimo > maximo) {
			throw new IllegalArgumentException(
					"o valor minimo n‹o pode ser maior que o maximo");
		}

		if (data == null) {
			throw new IllegalArgumentException(
					"o valor minimo n‹o pode ser maior que o maximo");
		}

		if ((abertura < 0) || (fechamento < 0) || (minimo < 0) || (maximo < 0)
				|| (volume < 0)) {
			throw new IllegalArgumentException(
					"valores inferiores a zero");
		}

		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return "Abertura " + abertura + ", Fechamento " + fechamento
				+ ", Minima " + minimo + ", Maxima " + maximo + ", Volume "
				+ volume + ", Data " + df.format(this.data.getTime());
	}

}
