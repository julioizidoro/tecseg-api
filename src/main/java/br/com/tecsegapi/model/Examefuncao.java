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
@Table(name = "examefuncao")
public class Examefuncao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexamefuncao")
    private Integer idexamefuncao;
    @Basic(optional = false)
    @Column(name = "asotipo_idasotipo")
    private Asotipo asoTipo;
    @JoinColumn(name = "funcao_idfuncao", referencedColumnName = "idfuncao")
    @ManyToOne(optional = false)
    private Funcao funcao;
    
    public Asotipo getAsoTipo() {
		return asoTipo;
	}

	public void setAsoTipo(Asotipo asoTipo) {
		this.asoTipo = asoTipo;
	}

	
   

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

   

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
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
        return "tecsegcriacao.model.Examefuncao[ idexamefuncao=" + idexamefuncao + " ]";
    }
    
}
