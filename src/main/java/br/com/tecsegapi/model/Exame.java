/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecsegapi.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author julioizidoro
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
    @Column(name = "dataemissao")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
    @JoinColumn(name = "funcionario_idfuncionario", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Funcionario funcionario;
    @JoinColumn(name = "examefuncao_idexamefuncao", referencedColumnName = "idexamefuncao")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }


    public Date getDataemissao() {
		return dataemissao;
	}

	public void setDataemissao(Date dataemissao) {
		this.dataemissao = dataemissao;
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
        return "br.com.tecseg.model.Exame[ idexame=" + idexame + " ]";
    }
    
}
