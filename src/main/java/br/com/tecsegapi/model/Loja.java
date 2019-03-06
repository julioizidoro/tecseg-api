/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecsegapi.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "loja")
public class Loja  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idloja")
    private Integer idloja;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    

    public Loja() {
    }

    public Loja(Integer idloja) {
        this.idloja = idloja;
    }

    public Integer getIdloja() {
        return idloja;
    }

    public void setIdloja(Integer idloja) {
        this.idloja = idloja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idloja != null ? idloja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loja)) {
            return false;
        }
        Loja other = (Loja) object;
        if ((this.idloja == null && other.idloja != null) || (this.idloja != null && !this.idloja.equals(other.idloja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tecseg.model.Loja[ idloja=" + idloja + " ]";
    }
    
}
