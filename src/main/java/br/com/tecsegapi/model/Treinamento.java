package br.com.tecsegapi.model;

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
import javax.validation.constraints.Size;

@Entity
@Table(name = "treinamento")
public class Treinamento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtreinamento")
    private Integer idtreinamento;
    @Size(max =200)
    @Column(name = "nome")
    private String nome;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Size(max =100)
    @Column(name = "instrutor")
    private String instrutor;
    @Size(max =9)
    @Column(name = "situacao")
    private String situacao;
    @Size(max =8)
    @Column(name = "duracao")
    private String duracao;
    @JoinColumn(name = "loja_idloja", referencedColumnName = "idloja")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Loja loja;
    
	public Treinamento() {
		
	}

	public Integer getIdtreinamento() {
		return idtreinamento;
	}

	public void setIdtreinamento(Integer idtreinamento) {
		this.idtreinamento = idtreinamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(String instrutor) {
		this.instrutor = instrutor;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idtreinamento == null) ? 0 : idtreinamento.hashCode());
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
		Treinamento other = (Treinamento) obj;
		if (idtreinamento == null) {
			if (other.idtreinamento != null)
				return false;
		} else if (!idtreinamento.equals(other.idtreinamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Treinamento [idtreinamento=" + idtreinamento + "]";
	}
	
	
    
    

}
