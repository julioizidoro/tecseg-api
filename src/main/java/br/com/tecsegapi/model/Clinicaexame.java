package br.com.tecsegapi.model;

import java.io.Serializable;

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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "clinicaexame")
public class Clinicaexame  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclinicaexame")
    private Integer idclinicaexame;
	@JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;
	@JoinColumn(name = "clinica_idclinica", referencedColumnName = "idclinica")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Clinica clinica;
	@JsonBackReference	
	@JoinColumn(name = "agendaexame_idagendaexame", referencedColumnName = "idagendaexame")
	@ManyToOne(optional = false)
	private Agendaexame agendaexame;
	
	public Clinicaexame() {
		super();
	}

	public Integer getIdclinicaexame() {
		return idclinicaexame;
	}

	public void setIdclinicaexame(Integer idclinicaexame) {
		this.idclinicaexame = idclinicaexame;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public Agendaexame getAgendaexame() {
		return agendaexame;
	}

	public void setAgendaexame(Agendaexame agendaexame) {
		this.agendaexame = agendaexame;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idclinicaexame == null) ? 0 : idclinicaexame.hashCode());
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
		Clinicaexame other = (Clinicaexame) obj;
		if (idclinicaexame == null) {
			if (other.idclinicaexame != null)
				return false;
		} else if (!idclinicaexame.equals(other.idclinicaexame))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Clinicaexame [idclinicaexame=" + idclinicaexame + "]";
	}
	
	
	

}
