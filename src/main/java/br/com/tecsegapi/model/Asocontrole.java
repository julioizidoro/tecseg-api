/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecsegapi.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Wolverine
 */
@Entity
@Table(name = "asocontrole")
public class Asocontrole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idasocontrole")
    private Integer idasocontrole;
    @Column(name = "dataexame")
    @Temporal(TemporalType.DATE)
    private Date dataexame;
    @Column(name = "datavencimento")
    @Temporal(TemporalType.DATE)
    private Date datavencimento;
    @Column(name = "finalizado")
    private boolean finalizado;
    @Lob
    @Column(name = "observaao")
    private String observaao;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "asocontroleIdasocontrole")
    private Exame exame;
    @JoinColumn(name = "asotipo_idasotipo", referencedColumnName = "idasotipo")
    @ManyToOne(optional = false)
    private Asotipo asotipo;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "funcionario_idfuncionario", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    private Funcionario funcionario;
   

    public Asocontrole() {
    }

    public Asocontrole(Integer idasocontrole) {
        this.idasocontrole = idasocontrole;
    }

    public Integer getIdasocontrole() {
        return idasocontrole;
    }

    public void setIdasocontrole(Integer idasocontrole) {
        this.idasocontrole = idasocontrole;
    }

    public Date getDataexame() {
        return dataexame;
    }

    public void setDataexame(Date dataexame) {
        this.dataexame = dataexame;
    }

    public Date getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(Date datavencimento) {
        this.datavencimento = datavencimento;
    }

    public String getObservaao() {
        return observaao;
    }

    public void setObservaao(String observaao) {
        this.observaao = observaao;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public Asotipo getAsotipo() {
        return asotipo;
    }

    public void setAsotipo(Asotipo asotipo) {
        this.asotipo = asotipo;
    }

    public Usuario getUsuarioo() {
        return usuario;
    }

    public void setUsuarioo(Usuario usuario) {
        this.usuario = usuario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasocontrole != null ? idasocontrole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asocontrole)) {
            return false;
        }
        Asocontrole other = (Asocontrole) object;
        if ((this.idasocontrole == null && other.idasocontrole != null) || (this.idasocontrole != null && !this.idasocontrole.equals(other.idasocontrole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tecsegcriacao.model.Asocontrole[ idasocontrole=" + idasocontrole + " ]";
    }
    
}
