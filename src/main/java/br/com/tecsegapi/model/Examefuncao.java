/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecsegapi.model;

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

/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "examefuncao")
public class Examefuncao  {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexamefuncao")
    private Integer idexamefuncao;
    @Column(name = "periodo")
    private Integer periodo;
    @JoinColumn(name = "funcao_idfuncao", referencedColumnName = "idfuncao")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Funcao funcaoIdfuncao;
    @JoinColumn(name = "tipocomplementar_idtipocomplementar", referencedColumnName = "idtipocomplementar")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tipocomplementar tipocomplementarIdtipocomplementar;

    public Examefuncao() {
    }

    public Examefuncao(Integer idexamefuncao) {
        this.idexamefuncao = idexamefuncao;
    }

    public Integer getIdexamefuncao() {
        return idexamefuncao;
    }

    public void setIdexamefuncao(Integer idexamefuncao) {
        this.idexamefuncao = idexamefuncao;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Funcao getFuncaoIdfuncao() {
        return funcaoIdfuncao;
    }

    public void setFuncaoIdfuncao(Funcao funcaoIdfuncao) {
        this.funcaoIdfuncao = funcaoIdfuncao;
    }

    public Tipocomplementar getTipocomplementarIdtipocomplementar() {
        return tipocomplementarIdtipocomplementar;
    }

    public void setTipocomplementarIdtipocomplementar(Tipocomplementar tipocomplementarIdtipocomplementar) {
        this.tipocomplementarIdtipocomplementar = tipocomplementarIdtipocomplementar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexamefuncao != null ? idexamefuncao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examefuncao)) {
            return false;
        }
        Examefuncao other = (Examefuncao) object;
        if ((this.idexamefuncao == null && other.idexamefuncao != null) || (this.idexamefuncao != null && !this.idexamefuncao.equals(other.idexamefuncao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tecseg.model.Examefuncao[ idexamefuncao=" + idexamefuncao + " ]";
    }
    
}
