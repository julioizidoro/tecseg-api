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
import javax.persistence.Table;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "asotipo")

public class Asotipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idasotipo")
    private Integer idasotipo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "tipo")
    private String tipo;
    

    public Asotipo() {
    }

    public Asotipo(Integer idasotipo) {
        this.idasotipo = idasotipo;
    }

    public Integer getIdasotipo() {
        return idasotipo;
    }

    public void setIdasotipo(Integer idasotipo) {
        this.idasotipo = idasotipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasotipo != null ? idasotipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asotipo)) {
            return false;
        }
        Asotipo other = (Asotipo) object;
        if ((this.idasotipo == null && other.idasotipo != null) || (this.idasotipo != null && !this.idasotipo.equals(other.idasotipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tecsegcriacao.model.Asotipo[ idasotipo=" + idasotipo + " ]";
    }
    
}
