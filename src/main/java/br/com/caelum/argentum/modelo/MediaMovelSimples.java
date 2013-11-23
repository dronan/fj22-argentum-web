package br.com.caelum.argentum.modelo;

import br.com.caelum.argentum.indicadores.Indicador;

public class MediaMovelSimples implements Indicador {
	private final Indicador outroIndicador;

	/* (non-Javadoc)
	 * @see br.com.caelum.argentum.indicadores.Indicador#calcula(int, br.com.caelum.argentum.modelo.SerieTemporal)
	 */
	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		for(int i = posicao - 2; i <= posicao; i++){
			soma += outroIndicador.calcula(i, serie);
		}
		return soma / 3;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MMS - " + this.outroIndicador.toString();
	}
	
	public MediaMovelSimples(Indicador outroIndicador) {
		this.outroIndicador = outroIndicador;
	}

	
}
