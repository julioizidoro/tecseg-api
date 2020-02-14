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
@Table(name = "epicontrole")
public class Epicontrole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idepicontrole")
    private Integer idepicontrole;
    @Column(name = "dataentrega")
    @Temporal(TemporalType.DATE)
    private Date dataentrega;
    @Column(name = "datasituacao")
    @Temporal(TemporalType.DATE)
    private Date datasituacao;
    @Column(name = "situacao")
    private String situacao;
    @Column(name = "tipolocal")
    private String tipolocal;
    @Column(name = "local")
    private String local;
    @Column(name = "idlocal")
    private Integer idlocal;
    @Column(name = "datarevisao")
    @Temporal(TemporalType.DATE)
    private Date datarevisao;
    @Column(name = "datavalidade")
    @Temporal(TemporalType.DATE)
    private Date datavalidade;
    @JoinColumn(name = "epi_idepi", referencedColumnName = "idepi")
    @ManyToOne(optional = false)
    private Epi epi;

    public Epicontrole() {
    }

    public Epicontrole(Integer idepicontrole) {
        this.idepicontrole = idepicontrole;
    }

    public Integer getIdepicontrole() {
        return idepicontrole;
    }

    public void setIdepicontrole(Integer idepicontrole) {
        this.idepicontrole = idepicontrole;
    }

    public Date getDataentrega() {
        return dataentrega;
    }

    public void setDataentrega(Date dataentrega) {
        this.dataentrega = dataentrega;
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

    public String getTipolocal() {
        return tipolocal;
    }

    public void setTipolocal(String tipolocal) {
        this.tipolocal = tipolocal;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(Integer idlocal) {
        this.idlocal = idlocal;
    }

    public Date getDatarevisao() {
        return datarevisao;
    }

    public void setDatarevisao(Date datarevisao) {
        this.datarevisao = datarevisao;
    }

    public Date getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(Date datavalidade) {
        this.datavalidade = datavalidade;
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
        hash += (idepicontrole != null ? idepicontrole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Epicontrole)) {
            return false;
        }
        Epicontrole other = (Epicontrole) object;
        if ((this.idepicontrole == null && other.idepicontrole != null) || (this.idepicontrole != null && !this.idepicontrole.equals(other.idepicontrole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Epicontrole[ idepicontrole=" + idepicontrole + " ]";
    }
    
}
