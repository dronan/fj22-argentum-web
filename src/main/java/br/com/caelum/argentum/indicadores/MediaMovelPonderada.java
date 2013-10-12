package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador {

	public double calcula(int posicao, SerieTemporal serie){
		
		double soma = 0.0;
		int peso = 1;
		
		for (int i = posicao - 2; i <= posicao; i++){
			Candle c = serie.getCandle(i);
			soma += c.getFechamento() * peso;
			peso++;
		}
		return soma / 6;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MMP de Fechamento";
	}
	
}
