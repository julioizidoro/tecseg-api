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

/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "aso")
public class Aso {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaso")
    private Integer idaso;
    @Column(name = "dataemissao")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
    @JoinColumn(name = "funcionario_idfuncionario", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Funcionario funcionario;
    @JoinColumn(name = "asofuncao_idasofuncao", referencedColumnName = "idasofuncao")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Asofuncao asofuncao;
    
    public Aso() {
    }

    public Aso(Integer idaso) {
        this.idaso = idaso;
    }

    public Integer getIdaso() {
        return idaso;
    }

    public void setIdaso(Integer idaso) {
        this.idaso = idaso;
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

	

	

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idaso != null ? idaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aso)) {
            return false;
        }
        Aso other = (Aso) object;
        if ((this.idaso == null && other.idaso != null) || (this.idaso != null && !this.idaso.equals(other.idaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tecseg.model.Aso[ idaso=" + idaso + " ]";
    }
    
}
