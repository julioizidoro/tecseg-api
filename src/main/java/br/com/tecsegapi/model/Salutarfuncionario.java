package br.com.tecsegapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "salutar")
public class Salutarfuncionario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsalutarfuncionario")
    private Integer idsalutarfuncionario;
	@Column(name = "datasituacao")
    @Temporal(TemporalType.DATE)
    private Date datasituacao;
	@Column(name = "situacao")
    private String situacao;
	@JoinColumn(name = "salutar_idsalutar", referencedColumnName = "idsalutar")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JsonBackReference
    private Salutar salutar;
	@JoinColumn(name = "funcionario_idfuncionario", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    private Funcionario funcionario;
	@JoinColumn(name = "funcao_idfuncao", referencedColumnName = "idfuncao")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Funcao funcao;
	@JoinColumn(name = "setor_idsetor", referencedColumnName = "idsetor")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Setor setor;
	
	public Salutarfuncionario() {
	
	}

	public Integer getIdsalutarfuncionario() {
		return idsalutarfuncionario;
	}

	public void setIdsalutarfuncionario(Integer idsalutarfuncionario) {
		this.idsalutarfuncionario = idsalutarfuncionario;
	}

	public Date getDatasituacao() {
		return datasituacao;
	}

	public void setDatasituacao(Date datasituacao) {
		this.datasituacao = datasituacao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Salutar getSalutar() {
		return salutar;
	}

	public void setSalutar(Salutar salutar) {
		this.salutar = salutar;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idsalutarfuncionario == null) ? 0 : idsalutarfuncionario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salutarfuncionario other = (Salutarfuncionario) obj;
		if (idsalutarfuncionario == null) {
			if (other.idsalutarfuncionario != null)
				return false;
		} else if (!idsalutarfuncionario.equals(other.idsalutarfuncionario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Salutarfuncionario [idsalutarfuncionario=" + idsalutarfuncionario + "]";
	}
	
	
	
	
	
}
