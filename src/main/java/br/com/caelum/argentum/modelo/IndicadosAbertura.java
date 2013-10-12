package br.com.caelum.argentum.modelo;

import br.com.caelum.argentum.indicadores.Indicador;

public class IndicadosAbertura implements Indicador {

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandle(posicao).getAbertura();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Abertura";
	}
	
}
