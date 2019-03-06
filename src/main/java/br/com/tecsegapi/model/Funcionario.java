/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecsegapi.model;

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
import javax.validation.constraints.Size;

/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "funcionario")
public class Funcionario  {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfuncionario")
    private Integer idfuncionario;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Column(name = "dataadmissao")
    @Temporal(TemporalType.DATE)
    private Date dataadmissao;
    @Column(name = "situacao")
    private Short situacao;
    @JoinColumn(name = "funcao_idfuncao", referencedColumnName = "idfuncao")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Funcao funcao;
    @JoinColumn(name = "loja_idloja", referencedColumnName = "idloja")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Loja loja;
    
    public Funcionario() {
    }

    public Funcionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Integer getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataadmissao() {
        return dataadmissao;
    }

    public void setDataadmissao(Date dataadmissao) {
        this.dataadmissao = dataadmissao;
    }

    public Short getSituacao() {
        return situacao;
    }

    public void setSituacao(Short situacao) {
        this.situacao = situacao;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfuncionario != null ? idfuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idfuncionario == null && other.idfuncionario != null) || (this.idfuncionario != null && !this.idfuncionario.equals(other.idfuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tecseg.model.Funcionario[ idfuncionario=" + idfuncionario + " ]";
    }
    
}
