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
@Table(name = "tipoatestado")
public class Tipoatestado {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoatestado")
    private Integer idtipoatestado;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
   
    

    public Tipoatestado() {
    }

    public Tipoatestado(Integer idtipoatestado) {
        this.idtipoatestado = idtipoatestado;
    }

    public Integer getIdtipoatestado() {
        return idtipoatestado;
    }

    public void setIdtipoatestado(Integer idtipoatestado) {
        this.idtipoatestado = idtipoatestado;
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
        hash += (idtipoatestado != null ? idtipoatestado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoatestado)) {
            return false;
        }
        Tipoatestado other = (Tipoatestado) object;
        if ((this.idtipoatestado == null && other.idtipoatestado != null) || (this.idtipoatestado != null && !this.idtipoatestado.equals(other.idtipoatestado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tecseg.model.Tipoatestado[ idtipoatestado=" + idtipoatestado + " ]";
    }
    
}
