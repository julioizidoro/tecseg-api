package br.com.tecsegapi.bean;

import java.util.List;

import br.com.tecsegapi.model.Loja;

public class PagSalutarBean {
	
	private Loja loja;
	private int funcionarios;
	private List<AsoControleBean> listaExames;
	private float valorFuncioanarios;
	private float valorExames;
	private float valorTotal;
	
	public Loja getLoja() {
		return loja;
	}
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	public int getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(int funcionarios) {
		this.funcionarios = funcionarios;
	}
	public List<AsoControleBean> getListaExames() {
		return listaExames;
	}
	public void setListaExames(List<AsoControleBean> listaExames) {
		this.listaExames = listaExames;
	}
	public float getValorFuncioanarios() {
		return valorFuncioanarios;
	}
	public void setValorFuncioanarios(float valorFuncioanarios) {
		this.valorFuncioanarios = valorFuncioanarios;
	}
	public float getValorExames() {
		return valorExames;
	}
	public void setValorExames(float valorExames) {
		this.valorExames = valorExames;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	

}
