package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class CandlestickFactory {

	public Candlestick constroiCandleParaData(Calendar data,
			List<Negociacao> negociacoes) {
		
		// double maximo = Double.MIN_VALUE; //negociacoes.get(0).getPreco();
		double maximo = negociacoes.isEmpty() ? 0 : negociacoes.get(0)
				.getPreco();

		// double minimo = Double.MAX_VALUE; //negociacoes.get(0).getPreco();
		double minimo = negociacoes.isEmpty() ? 0 : negociacoes.get(0)
				.getPreco();

		double volume = 0;

		for (Negociacao negociacao : negociacoes) {
			
			volume += negociacao.getVolume();

			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			} else if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}
		}

		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0)
				.getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(
				negociacoes.size() - 1).getPreco();

		return new Candlestick(abertura, fechamento, minimo, maximo, volume,
				data);

	}

	public List<Candlestick> constroiCandles(List<Negociacao> todasNegociacoes) {
		
		Collections.sort(todasNegociacoes);
		
		List<Candlestick> candles = new ArrayList<Candlestick>();
		List<Negociacao> negociacoesDoDia = new ArrayList<Negociacao>();

		Calendar dataAtual = todasNegociacoes.get(0).getData();

		for (Negociacao negociacao : todasNegociacoes) {
			
			if (negociacao.getData().before(dataAtual)){
				throw new IllegalStateException("negociacao em ordem errada");
			}
			
			if (!negociacao.isMesmoDia(dataAtual)) {
				Candlestick candleDoDia = constroiCandleParaData(dataAtual,
						negociacoesDoDia);
				candles.add(candleDoDia);
				negociacoesDoDia = new ArrayList<Negociacao>();
				dataAtual = negociacao.getData();
			}

			negociacoesDoDia.add(negociacao);
		}

		Candlestick candleDoDia = constroiCandleParaData(dataAtual,
				negociacoesDoDia);

		candles.add(candleDoDia);

		return candles;
	}

}
