package br.com.caelum.argentum.modelo;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static junit.framework.Assert.*;

import org.junit.Test;

public class CandlestickFactoryTest {

	@Test
	public void sequenciaSimpleDeNegociacoes() {
		Calendar hoje = Calendar.getInstance();

		Negociacao n1 = new Negociacao(40.5, 100, hoje);
		Negociacao n2 = new Negociacao(45.0, 100, hoje);
		Negociacao n3 = new Negociacao(39.8, 100, hoje);
		Negociacao n4 = new Negociacao(42.3, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(n1, n2, n3, n4);

		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		assertEquals(40.5, candle.getAbertura(), 0.000001);
		assertEquals(42.3, candle.getFechamento(), 0.000001);
		assertEquals(39.8, candle.getMinimo(), 0.000001);
		assertEquals(45.0, candle.getMaximo(), 0.000001);
		assertEquals(16760.0, candle.getVolume(), 0.000001);

	}

	@Test
	public void semNegociacoesGeraCandleComZeros() {
		Calendar hoje = Calendar.getInstance();

		List<Negociacao> negociacoes = Arrays.asList();

		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		assertEquals(0.0, candle.getVolume(), 0.000001);
		assertEquals(0.0, candle.getAbertura(), 0.000001);
		assertEquals(0.0, candle.getFechamento(), 0.000001);
		assertEquals(0.0, candle.getMinimo(), 0.000001);
		assertEquals(0.0, candle.getMaximo(), 0.000001);

	}
	
	@Test
	public void apenasUmaNegociacaoGeraCandleComValoresIguais() {
		Calendar hoje = Calendar.getInstance();

		Negociacao n1 = new Negociacao(40.5, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(n1);

		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		assertEquals(40.5, candle.getAbertura(), 0.000001);
		assertEquals(40.5, candle.getFechamento(), 0.000001);
		assertEquals(40.5, candle.getMinimo(), 0.000001);
		assertEquals(40.5, candle.getMaximo(), 0.000001);
		assertEquals(4050.0, candle.getVolume(), 0.000001);

	}	
	
	

	@Test
	public void negociacaoEmOrdemCrescenteDeValor() {
		Calendar hoje = Calendar.getInstance();

		Negociacao n1 = new Negociacao(10.0, 100, hoje);
		Negociacao n2 = new Negociacao(20.0, 100, hoje);
		Negociacao n3 = new Negociacao(30.0, 100, hoje);
		Negociacao n4 = new Negociacao(40.0, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(n1, n2, n3, n4);

		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		assertEquals(10.0, candle.getAbertura(), 0.000001);
		assertEquals(40.0, candle.getFechamento(), 0.000001);
		assertEquals(10.0, candle.getMinimo(), 0.000001);
		assertEquals(40.0, candle.getMaximo(), 0.000001);
		assertEquals(10000.0, candle.getVolume(), 0.000001);
		
	}

	@Test
	public void negociacaoEmOrdemDecrescenteDeValor() {
		Calendar hoje = Calendar.getInstance();

		Negociacao n1 = new Negociacao(40.0, 100, hoje);
		Negociacao n2 = new Negociacao(30.0, 100, hoje);
		Negociacao n3 = new Negociacao(20.0, 100, hoje);
		Negociacao n4 = new Negociacao(10.0, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(n1, n2, n3, n4);

		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		assertEquals(40.0, candle.getAbertura(), 0.000001);
		assertEquals(10.0, candle.getFechamento(), 0.000001);
		assertEquals(10.0, candle.getMinimo(), 0.000001);
		assertEquals(40.0, candle.getMaximo(), 0.000001);
		assertEquals(10000.0, candle.getVolume(), 0.000001);
		
	}
	
}
