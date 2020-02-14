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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "epibaixa")
public class Epibaixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idepibaixa")
    private Integer idepibaixa;
    @Column(name = "databaixa")
    @Temporal(TemporalType.DATE)
    private Date databaixa;
    @Column(name = "motivo")
    private String motivo;
    @Lob
    @Column(name = "descricaomotivo")
    private String descricaomotivo;
    @Column(name = "cobrado")
    private String cobrado;
    @JoinColumn(name = "epi_idepi", referencedColumnName = "idepi")
    @ManyToOne(optional = false)
    private Epi epi;

    public Epibaixa() {
    }

    public Epibaixa(Integer idepibaixa) {
        this.idepibaixa = idepibaixa;
    }

    public Integer getIdepibaixa() {
        return idepibaixa;
    }

    public void setIdepibaixa(Integer idepibaixa) {
        this.idepibaixa = idepibaixa;
    }

    public Date getDatabaixa() {
        return databaixa;
    }

    public void setDatabaixa(Date databaixa) {
        this.databaixa = databaixa;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescricaomotivo() {
        return descricaomotivo;
    }

    public void setDescricaomotivo(String descricaomotivo) {
        this.descricaomotivo = descricaomotivo;
    }

    public String getCobrado() {
        return cobrado;
    }

    public void setCobrado(String cobrado) {
        this.cobrado = cobrado;
    }

    public Epi getEpi() {
        return epi;
    }

    public void setEpi(Epi epi) {
        this.epi = epi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idepibaixa != null ? idepibaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Epibaixa)) {
            return false;
        }
        Epibaixa other = (Epibaixa) object;
        if ((this.idepibaixa == null && other.idepibaixa != null) || (this.idepibaixa != null && !this.idepibaixa.equals(other.idepibaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Epibaixa[ idepibaixa=" + idepibaixa + " ]";
    }
    
}

