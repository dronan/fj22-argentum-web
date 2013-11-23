package br.com.caelum.argentum.modelo;

import br.com.caelum.argentum.indicadores.Indicador;

public class MediaMovelPonderada implements Indicador {

	private final Indicador outroIndicador;

	public double calcula(int posicao, SerieTemporal serie){
		
		double soma = 0.0;
		int peso = 1;
		
		for (int i = posicao - 2; i <= posicao; i++){
			soma += outroIndicador.calcula(i, serie) * peso;
			peso++;
		}
		return soma / 6;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MMP - " + this.outroIndicador.toString();
	}
	
	public MediaMovelPonderada(Indicador outroIndicador) {
		this.outroIndicador = outroIndicador;
		// TODO Auto-generated constructor stub
	}
	
}
