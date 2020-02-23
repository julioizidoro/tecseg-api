package br.com.tecsegapi.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "lojavaloraso")
public class Lojavaloraso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlojavaloraso")
    private Integer idlojavaloraso;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valoraso")
    private Float valoraso;
    @JoinColumn(name = "clinica_idclinica", referencedColumnName = "idclinica")
    @ManyToOne(optional = false)
    private Clinica clinica;
    @JsonBackReference
    @JoinColumn(name = "loja_idloja", referencedColumnName = "idloja")
    @ManyToOne(optional = false)
    private Loja loja;

    public Lojavaloraso() {
    }

    public Lojavaloraso(Integer idlojavaloraso) {
        this.idlojavaloraso = idlojavaloraso;
    }

    public Integer getIdlojavaloraso() {
        return idlojavaloraso;
    }

    public void setIdlojavaloraso(Integer idlojavaloraso) {
        this.idlojavaloraso = idlojavaloraso;
    }

    public Float getValoraso() {
        return valoraso;
    }

    public void setValoraso(Float valoraso) {
        this.valoraso = valoraso;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlojavaloraso != null ? idlojavaloraso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lojavaloraso)) {
            return false;
        }
        Lojavaloraso other = (Lojavaloraso) object;
        if ((this.idlojavaloraso == null && other.idlojavaloraso != null) || (this.idlojavaloraso != null && !this.idlojavaloraso.equals(other.idlojavaloraso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Lojavaloraso[ idlojavaloraso=" + idlojavaloraso + " ]";
    }
    
}
