package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimples implements Indicador {
	/* (non-Javadoc)
	 * @see br.com.caelum.argentum.indicadores.Indicador#calcula(int, br.com.caelum.argentum.modelo.SerieTemporal)
	 */
	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		for(int i = posicao - 2; i <= posicao; i++){
			soma += serie.getCandle(i).getFechamento();
		}
		return soma / 3;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MMS de Fechamento";
	}
}
