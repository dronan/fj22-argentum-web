package br.com.caelum.argentum.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.ChartModel;

import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.ws.ClienteWebService;

@ManagedBean
@SessionScoped
public class ArgentumBean {
	
	private List<Negociacao> negociacoes;
	private ChartModel modeloGrafico;
	
	@PostConstruct
	public void peparadados(){
		ClienteWebService cliente = new ClienteWebService();
		this.negociacoes = cliente.getNegociacoes();
		
		List<Candle> candles = new CandlestickFactory().constroiCandles(this.negociacoes);
		SerieTemporal serie = new SerieTemporal(candles);
		
		GeradorModeloGrafico gerador = new GeradorModeloGrafico(serie, 2, serie.getTotal() - 1);
		gerador.plotaIndicador(new MediaMovelSimples(new IndicadorFechamento()));
		
		this.modeloGrafico = gerador.getModeloGrafico();
		
	}
	
	public List<Negociacao> getNegociacoes() {
		return negociacoes;
	}
	
	public ChartModel getModeloGrafico() {
		return modeloGrafico;
	}
	
}
