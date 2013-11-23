package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.caelum.argentum.modelo.IndicadorFechamento;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderadaTest {

	@Test
	public void sequenciaSimplesDeCandles() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1,2,3,4,5,6);
		MediaMovelPonderada mmp = new MediaMovelPonderada(new IndicadorFechamento());
		
		assertEquals(14.0/6, mmp.calcula(2, serie),0.00001);
		assertEquals(20.0/6, mmp.calcula(3, serie),0.00001);
		assertEquals(26.0/6, mmp.calcula(4, serie),0.00001);
		assertEquals(32.0/6, mmp.calcula(5, serie),0.00001);
		
	}

}
