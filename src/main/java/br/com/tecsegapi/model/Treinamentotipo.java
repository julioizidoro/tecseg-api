package br.com.tecsegapi.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "treinamentotipo")
public class Treinamentotipo  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtreinamentotipo")
    private Integer idtreinamentotipo;
	@Column(name = "nome")
    private String nome;
	@Column(name = "periodicidade")
    private Integer periodicidade;
	@Column(name = "tipo")
    private String tipo;
	@Lob
	@Column(name = "conteudo")
    private String conteudo;
	@Column(name = "complementotitulo")
    private String complementotitulo;
	
	
	
	public Treinamentotipo() {
	
	}

	public Integer getIdtreinamentotipo() {
		return idtreinamentotipo;
	}

	public void setIdtreinamentotipo(Integer idtreinamentotipo) {
		this.idtreinamentotipo = idtreinamentotipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(Integer periodicidade) {
		this.periodicidade = periodicidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getComplementotitulo() {
		return complementotitulo;
	}

	public void setComplementotitulo(String complementotitulo) {
		this.complementotitulo = complementotitulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idtreinamentotipo == null) ? 0 : idtreinamentotipo.hashCode());
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
		Treinamentotipo other = (Treinamentotipo) obj;
		if (idtreinamentotipo == null) {
			if (other.idtreinamentotipo != null)
				return false;
		} else if (!idtreinamentotipo.equals(other.idtreinamentotipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Treinamentotipo [idtreinamentotipo=" + idtreinamentotipo + ", nome=" + nome + "]";
	}
	
	
	
	
	
	

}
