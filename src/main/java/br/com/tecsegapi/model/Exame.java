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
@Table(name = "exame")
public class Exame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexame")
    private Integer idexame;
    @JoinColumn(name = "asocontrole_idasocontrole", referencedColumnName = "idasocontrole")
    @ManyToOne(optional = false)
    private Asocontrole asocontroleIdasocontrole;
    @JoinColumn(name = "examefuncao_idexamefuncao", referencedColumnName = "idexamefuncao")
    @ManyToOne(optional = false)
    private Examefuncao examefuncao;
    
    public Exame() {
    }

    public Exame(Integer idexame) {
        this.idexame = idexame;
    }

    public Integer getIdexame() {
        return idexame;
    }

    public void setIdexame(Integer idexame) {
        this.idexame = idexame;
    }

    public Asocontrole getAsocontroleIdasocontrole() {
        return asocontroleIdasocontrole;
    }

    public void setAsocontroleIdasocontrole(Asocontrole asocontroleIdasocontrole) {
        this.asocontroleIdasocontrole = asocontroleIdasocontrole;
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
        hash += (idexame != null ? idexame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exame)) {
            return false;
        }
        Exame other = (Exame) object;
        if ((this.idexame == null && other.idexame != null) || (this.idexame != null && !this.idexame.equals(other.idexame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tecsegcriacao.model.Exame[ idexame=" + idexame + " ]";
    }
    
}
