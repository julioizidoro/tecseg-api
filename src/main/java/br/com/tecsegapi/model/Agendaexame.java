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

@Entity
@Table(name = "agendaexame")
public class Agendaexame implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idagendaexame")
    private Integer idagendaexame;
	@Column(name = "situacao")
    private String situacao;
	@Column(name = "datalancamento")
    @Temporal(TemporalType.DATE)
    private Date datalancamento;
	@JoinColumn(name = "asoagenda_idasoagenda", referencedColumnName = "idasoagenda")
    @ManyToOne(optional = false)
    private Asoagenda asoagenda;
	@JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;
	@JoinColumn(name = "clinica_idclinica", referencedColumnName = "idclinica")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Clinica clinica;
	@JoinColumn(name = "asotipo_idasotipo", referencedColumnName = "idasotipo")
	@ManyToOne(optional = false)
	private Asotipo asotipo;
	
	public Agendaexame() {
	
	}

	public Integer getIdagendaexame() {
		return idagendaexame;
	}

	public void setIdagendaexame(Integer idagendaexame) {
		this.idagendaexame = idagendaexame;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getDatalancamento() {
		return datalancamento;
	}

	public void setDatalancamento(Date datalancamento) {
		this.datalancamento = datalancamento;
	}

	public Asoagenda getAsoagenda() {
		return asoagenda;
	}

	public void setAsoagenda(Asoagenda asoagenda) {
		this.asoagenda = asoagenda;
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

	public Asotipo getAsotipo() {
		return asotipo;
	}

	public void setAsotipo(Asotipo asotipo) {
		this.asotipo = asotipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idagendaexame == null) ? 0 : idagendaexame.hashCode());
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
		Agendaexame other = (Agendaexame) obj;
		if (idagendaexame == null) {
			if (other.idagendaexame != null)
				return false;
		} else if (!idagendaexame.equals(other.idagendaexame))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agendaexame [idagendaexame=" + idagendaexame + "]";
	}
	
	
	
	

}
