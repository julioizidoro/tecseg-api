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
import javax.validation.constraints.Size;

/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "tipocomplementar")
public class Tipocomplementar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipocomplementar")
    private Integer idtipocomplementar;
    @Size(max = 45)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "periodo")
    private Integer periodo;
    

    public Tipocomplementar() {
    }

    public Tipocomplementar(Integer idtipocomplementar) {
        this.idtipocomplementar = idtipocomplementar;
    }

    public Integer getIdtipocomplementar() {
        return idtipocomplementar;
    }

    public void setIdtipocomplementar(Integer idtipocomplementar) {
        this.idtipocomplementar = idtipocomplementar;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipocomplementar != null ? idtipocomplementar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocomplementar)) {
            return false;
        }
        Tipocomplementar other = (Tipocomplementar) object;
        if ((this.idtipocomplementar == null && other.idtipocomplementar != null) || (this.idtipocomplementar != null && !this.idtipocomplementar.equals(other.idtipocomplementar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tecseg.model.Tipocomplementar[ idtipocomplementar=" + idtipocomplementar + " ]";
    }
    
}
