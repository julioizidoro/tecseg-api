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
@Table(name = "funcaoexameaso")
public class Funcaoexameaso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfuncaoexameaso")
    private Integer idfuncaoexameaso;
    @JoinColumn(name = "asotipo_idasotipo", referencedColumnName = "idasotipo")
    @ManyToOne(optional = false)
    private Asotipo asotipo;
    @JoinColumn(name = "examefuncao_idexamefuncao", referencedColumnName = "idexamefuncao")
    @ManyToOne(optional = false)
    private Examefuncao examefuncao;

    public Funcaoexameaso() {
    }

    public Funcaoexameaso(Integer idfuncaoexameaso) {
        this.idfuncaoexameaso = idfuncaoexameaso;
    }

    public Integer getIdfuncaoexameaso() {
        return idfuncaoexameaso;
    }

    public void setIdfuncaoexameaso(Integer idfuncaoexameaso) {
        this.idfuncaoexameaso = idfuncaoexameaso;
    }

    public Asotipo getAsotipo() {
        return asotipo;
    }

    public void setAsotipo(Asotipo asotipo) {
        this.asotipo = asotipo;
    }

    public Examefuncao getExamefuncao() {
        return examefuncao;
    }

    public void setExamefuncao(Examefuncao examefuncao) {
        this.examefuncao = examefuncao;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfuncaoexameaso != null ? idfuncaoexameaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcaoexameaso)) {
            return false;
        }
        Funcaoexameaso other = (Funcaoexameaso) object;
        if ((this.idfuncaoexameaso == null && other.idfuncaoexameaso != null) || (this.idfuncaoexameaso != null && !this.idfuncaoexameaso.equals(other.idfuncaoexameaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tecsegcriacao.model.Funcaoexameaso[ idfuncaoexameaso=" + idfuncaoexameaso + " ]";
    }
    
}
