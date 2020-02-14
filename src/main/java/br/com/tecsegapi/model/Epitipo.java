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
@Table(name = "epitipo")
public class Epitipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idepitipo")
    private Integer idepitipo;
    @Column(name = "descricao")
    private String descricao;
    
    public Epitipo() {
    }

    public Epitipo(Integer idepitipo) {
        this.idepitipo = idepitipo;
    }

    public Integer getIdepitipo() {
        return idepitipo;
    }

    public void setIdepitipo(Integer idepitipo) {
        this.idepitipo = idepitipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idepitipo != null ? idepitipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Epitipo)) {
            return false;
        }
        Epitipo other = (Epitipo) object;
        if ((this.idepitipo == null && other.idepitipo != null) || (this.idepitipo != null && !this.idepitipo.equals(other.idepitipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Epitipo[ idepitipo=" + idepitipo + " ]";
    }
    
}

