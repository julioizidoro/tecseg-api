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
@Table(name = "examevalidade")
public class Examevalidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexamevalidade")
    private Integer idexamevalidade;
    @Column(name = "validade")
    @Temporal(TemporalType.DATE)
    private Date validade;
    @JoinColumn(name = "exame_idexame", referencedColumnName = "idexame")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Exame exame;

    public Examevalidade() {
    }

    public Examevalidade(Integer idexamevalidade) {
        this.idexamevalidade = idexamevalidade;
    }

    public Integer getIdexamevalidade() {
        return idexamevalidade;
    }

    public void setIdexamevalidade(Integer idexamevalidade) {
        this.idexamevalidade = idexamevalidade;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexamevalidade != null ? idexamevalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examevalidade)) {
            return false;
        }
        Examevalidade other = (Examevalidade) object;
        if ((this.idexamevalidade == null && other.idexamevalidade != null) || (this.idexamevalidade != null && !this.idexamevalidade.equals(other.idexamevalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tecseg.model.Examevalidade[ idexamevalidade=" + idexamevalidade + " ]";
    }
    
}
