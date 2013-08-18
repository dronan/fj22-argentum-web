package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public final class Negociacao implements Comparable<Negociacao> {
	private final double preco;
	private final int quantidade;
	private final Calendar data;

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar) this.data.clone();
	}

	public Negociacao(double preco, int quantidade, Calendar data) {
		
		if (data == null){
			throw new IllegalArgumentException("A data n‹o pode ser nula");
		}
		
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}
	
	public double getVolume(){
		return preco * quantidade;
	}

	public boolean isMesmoDia(Calendar outraData) {
		return this.data.get(Calendar.DATE) == outraData.get(Calendar.DATE) &&
				this.data.get(Calendar.MONTH) == outraData.get(Calendar.MONTH) &&
				this.data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR);
	}
	
	@Override
	public int compareTo(Negociacao o) {
		
		if ( this.getData().after(o.getData()) )
			return 1;
		
		if ( this.getData().before(o.getData()) )
			return -1;
		
		return 0;
	}
	
}
