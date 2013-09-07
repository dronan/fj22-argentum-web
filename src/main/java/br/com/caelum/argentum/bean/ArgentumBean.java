package br.com.caelum.argentum.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.ws.ClienteWebService;

@ManagedBean
@SessionScoped
public class ArgentumBean {
	
	private List<Negociacao> negociacoes;
	
	@PostConstruct
	public void peparadados(){
		ClienteWebService cliente = new ClienteWebService();
		this.negociacoes = cliente.getNegociacoes();
	}
	
	public List<Negociacao> getNegociacoes() {
		return negociacoes;
	}
	
}
