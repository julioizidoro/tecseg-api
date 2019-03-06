/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "asovalidade")
public class Asovalidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idasovalidade")
    private Integer idasovalidade;
    @Column(name = "vencimento")
    @Temporal(TemporalType.DATE)
    private Date vencimento;
    @JoinColumn(name = "aso_idaso", referencedColumnName = "idaso")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Aso aso;

    public Asovalidade() {
    }

    public Asovalidade(Integer idasovalidade) {
        this.idasovalidade = idasovalidade;
    }

    public Integer getIdasovalidade() {
        return idasovalidade;
    }

    public void setIdasovalidade(Integer idasovalidade) {
        this.idasovalidade = idasovalidade;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Aso getAso() {
        return aso;
    }

    public void setAso(Aso aso) {
        this.aso = aso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasovalidade != null ? idasovalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asovalidade)) {
            return false;
        }
        Asovalidade other = (Asovalidade) object;
        if ((this.idasovalidade == null && other.idasovalidade != null) || (this.idasovalidade != null && !this.idasovalidade.equals(other.idasovalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tecseg.model.Asovalidade[ idasovalidade=" + idasovalidade + " ]";
    }
    
}
