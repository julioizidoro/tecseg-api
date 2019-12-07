package br.com.tecsegapi.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acesso")
public class Acesso implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idacesso")
    private Integer idaacesso;
	@Column(name = "cadastro")
    private Boolean cadastro;
	@Column(name = "aso")
    private Boolean aso;
	@Column(name = "treinamento")
    private Boolean treinamento;
	@Column(name = "asoagenda")
    private Boolean asoagenda;
	@Column(name = "asoagendanova")
    private Boolean asoagendanova;
	@Column(name = "asocontrole")
    private Boolean asocontrole;
	@Column(name = "asocontrolenovo")
    private Boolean asocontrolenovo;
	
	
	public Acesso() {
		
	}

	public Integer getIdaacesso() {
		return idaacesso;
	}

	public void setIdaacesso(Integer idaacesso) {
		this.idaacesso = idaacesso;
	}

	public Boolean getCadastro() {
		return cadastro;
	}

	public void setCadastro(Boolean cadastro) {
		this.cadastro = cadastro;
	}

	public Boolean getAso() {
		return aso;
	}

	public void setAso(Boolean aso) {
		this.aso = aso;
	}

	public Boolean getTreinamento() {
		return treinamento;
	}

	public void setTreinamento(Boolean treinamento) {
		this.treinamento = treinamento;
	}

	public Boolean getAsoagenda() {
		return asoagenda;
	}

	public void setAsoagenda(Boolean asoagenda) {
		this.asoagenda = asoagenda;
	}

	public Boolean getAsoagendanova() {
		return asoagendanova;
	}

	public void setAsoagendanova(Boolean asoagendanova) {
		this.asoagendanova = asoagendanova;
	}

	public Boolean getAsocontrole() {
		return asocontrole;
	}

	public void setAsocontrole(Boolean asocontrole) {
		this.asocontrole = asocontrole;
	}

	public Boolean getAsocontrolenovo() {
		return asocontrolenovo;
	}

	public void setAsocontrolenovo(Boolean asocontrolenovo) {
		this.asocontrolenovo = asocontrolenovo;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idaacesso == null) ? 0 : idaacesso.hashCode());
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
		Acesso other = (Acesso) obj;
		if (idaacesso == null) {
			if (other.idaacesso != null)
				return false;
		} else if (!idaacesso.equals(other.idaacesso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Acesso [idaacesso=" + idaacesso + "]";
	}
}
