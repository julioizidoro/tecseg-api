package br.com.tecsegapi.bean;

import java.util.Date;

import br.com.tecsegapi.model.Funcionario;

public class Contratoexp {
	
	private Funcionario funcionario;
	private Date datavencendo;
	private int diasvencendo;
	private String tipovencimento;
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Date getDatavencendo() {
		return datavencendo;
	}
	public void setDatavencendo(Date datavencendo) {
		this.datavencendo = datavencendo;
	}
	public int getDiasvencendo() {
		return diasvencendo;
	}
	public void setDiasvencendo(int diasvencendo) {
		this.diasvencendo = diasvencendo;
	}
	public String getTipovencimento() {
		return tipovencimento;
	}
	public void setTipovencimento(String tipovencimento) {
		this.tipovencimento = tipovencimento;
	}
	
	

}

