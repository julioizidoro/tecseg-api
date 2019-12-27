package br.com.tecsegapi.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "codigoafastamento")
public class Codigoafastamento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcodigoafastamento")
    private Integer idcodigoafastamento;
    @Size(max = 2)
    @Column(name = "sefip")
    private String sefip;
    @Size(max = 2)
    @Column(name = "rais")
    private String rais;
    @Size(max = 1)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 45)
    @Column(name = "descricao")
    private String descricao;
    
	public Codigoafastamento() {
	
	}

	public Integer getIdcodigoafastamento() {
		return idcodigoafastamento;
	}

	public void setIdcodigoafastamento(Integer idcodigoafastamento) {
		this.idcodigoafastamento = idcodigoafastamento;
	}

	public String getSefip() {
		return sefip;
	}

	public void setSefip(String sefip) {
		this.sefip = sefip;
	}

	public String getRais() {
		return rais;
	}

	public void setRais(String rais) {
		this.rais = rais;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcodigoafastamento == null) ? 0 : idcodigoafastamento.hashCode());
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
		Codigoafastamento other = (Codigoafastamento) obj;
		if (idcodigoafastamento == null) {
			if (other.idcodigoafastamento != null)
				return false;
		} else if (!idcodigoafastamento.equals(other.idcodigoafastamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Codigoafastamento [descricao=" + descricao + "]";
	}
	
	
    
    

}
