package br.com.tecsegapi.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "relatoriosegurancaitens")
public class Relatoriosegurancaitens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelatoriosegurancaitens")
    private Integer idrelatoriosegurancaitens;
    @Lob
    @Column(name = "constatacao")
    private String constatacao;
    @Lob
    @Column(name = "adequacao")
    private String adequacao;
    @Column(name = "urlfoto")
    private String urlfoto;
    @JoinColumn(name = "relatorioseguranca_idrelatorioseguranca", referencedColumnName = "idrelatorioseguranca")
    @ManyToOne(optional = false)
    private Relatorioseguranca relatorioseguranca;
    @JoinColumn(name = "setor_idsetor", referencedColumnName = "idsetor")
    @ManyToOne(optional = false)
    private Setor setor;

    public Relatoriosegurancaitens() {
    }

    public Relatoriosegurancaitens(Integer idrelatoriosegurancaitens) {
        this.idrelatoriosegurancaitens = idrelatoriosegurancaitens;
    }

    public Integer getIdrelatoriosegurancaitens() {
        return idrelatoriosegurancaitens;
    }

    public void setIdrelatoriosegurancaitens(Integer idrelatoriosegurancaitens) {
        this.idrelatoriosegurancaitens = idrelatoriosegurancaitens;
    }

    public String getConstatacao() {
        return constatacao;
    }

    public void setConstatacao(String constatacao) {
        this.constatacao = constatacao;
    }

    public String getAdequacao() {
        return adequacao;
    }

    public void setAdequacao(String adequacao) {
        this.adequacao = adequacao;
    }

    public Relatorioseguranca getRelatorioseguranca() {
        return relatorioseguranca;
    }

    public void setRelatorioseguranca(Relatorioseguranca relatorioseguranca) {
        this.relatorioseguranca = relatorioseguranca;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getUrlfoto() {
		return urlfoto;
	}

	public void setUrlfoto(String urlfoto) {
		this.urlfoto = urlfoto;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelatoriosegurancaitens != null ? idrelatoriosegurancaitens.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relatoriosegurancaitens)) {
            return false;
        }
        Relatoriosegurancaitens other = (Relatoriosegurancaitens) object;
        if ((this.idrelatoriosegurancaitens == null && other.idrelatoriosegurancaitens != null) || (this.idrelatoriosegurancaitens != null && !this.idrelatoriosegurancaitens.equals(other.idrelatoriosegurancaitens))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Relatoriosegurancaitens[ idrelatoriosegurancaitens=" + idrelatoriosegurancaitens + " ]";
    }
    
}

