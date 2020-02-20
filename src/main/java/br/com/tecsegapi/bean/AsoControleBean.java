package br.com.tecsegapi.bean;

import br.com.tecsegapi.model.Asotipo;

public class AsoControleBean {
	
	private Asotipo asotipo;
	private int quantidade;
	private float valortotal;
	
	public AsoControleBean() {
		
	}

	public Asotipo getAsotipo() {
		return asotipo;
	}

	public void setAsotipo(Asotipo asotipo) {
		this.asotipo = asotipo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValortotal() {
		return valortotal;
	}

	public void setValortotal(float valortotal) {
		this.valortotal = valortotal;
	}
	
	

	
	
}
