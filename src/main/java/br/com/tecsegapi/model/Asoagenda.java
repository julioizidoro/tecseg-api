package br.com.tecsegapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "asoagenda")
public class Asoagenda implements Serializable{
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idasoagenda")
    private Integer idasoagenda;
    @Column(name = "dataexame")
    @Temporal(TemporalType.DATE)
    private Date dataexame;
    @Column(name = "horaexame")
    private boolean horaexame;
    @Column(name = "situacao")
    private boolean situacao;
    @JoinColumn(name = "asocontrole_idasocontrole", referencedColumnName = "idasocontrole")
    @ManyToOne(optional = false)
    private Asocontrole asocontrole;
    @JoinColumn(name = "asotipo_idasotipo", referencedColumnName = "idasotipo")
    @ManyToOne(optional = false)
    private Asotipo asotipo;
    @JoinColumn(name = "clinica_idclinica", referencedColumnName = "idclinica")
    @ManyToOne(optional = false)
    private Clinica clinica;
    
	public Asoagenda() {
		
	}

	public Integer getIdasoagenda() {
		return idasoagenda;
	}

	public void setIdasoagenda(Integer idasoagenda) {
		this.idasoagenda = idasoagenda;
	}

	public Date getDataexame() {
		return dataexame;
	}

	public void setDataexame(Date dataexame) {
		this.dataexame = dataexame;
	}

	public boolean isHoraexame() {
		return horaexame;
	}

	public void setHoraexame(boolean horaexame) {
		this.horaexame = horaexame;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public Asocontrole getAsocontrole() {
		return asocontrole;
	}

	public void setAsocontrole(Asocontrole asocontrole) {
		this.asocontrole = asocontrole;
	}

	public Asotipo getAsotipo() {
		return asotipo;
	}

	public void setAsotipo(Asotipo asotipo) {
		this.asotipo = asotipo;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idasoagenda == null) ? 0 : idasoagenda.hashCode());
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
		Asoagenda other = (Asoagenda) obj;
		if (idasoagenda == null) {
			if (other.idasoagenda != null)
				return false;
		} else if (!idasoagenda.equals(other.idasoagenda))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asoagenda [idasoagenda=" + idasoagenda + "]";
	}
	
	
    
    

}
