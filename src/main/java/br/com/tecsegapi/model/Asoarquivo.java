/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "asoarquivo")
public class Asoarquivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idasoarquivo")
    private Integer idasoarquivo;
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "asocontrole_idasocontrole", referencedColumnName = "idasocontrole")
    @ManyToOne(optional = false)
    private Asocontrole asocontrole;

    public Asoarquivo() {
    }

    public Asoarquivo(Integer idasoarquivo) {
        this.idasoarquivo = idasoarquivo;
    }

    public Integer getIdasoarquivo() {
        return idasoarquivo;
    }

    public void setIdasoarquivo(Integer idasoarquivo) {
        this.idasoarquivo = idasoarquivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Asocontrole getAsocontrole() {
        return asocontrole;
    }

    public void setAsocontrole(Asocontrole asocontrole) {
        this.asocontrole = asocontrole;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasoarquivo != null ? idasoarquivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asoarquivo)) {
            return false;
        }
        Asoarquivo other = (Asoarquivo) object;
        if ((this.idasoarquivo == null && other.idasoarquivo != null) || (this.idasoarquivo != null && !this.idasoarquivo.equals(other.idasoarquivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tecsegcriacao.model.Asoarquivo[ idasoarquivo=" + idasoarquivo + " ]";
    }
    
}
