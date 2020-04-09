package br.com.tecsegapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "situacao")
public class Situacao implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsituacao")
    private Integer idsituacao;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "funcionario_idfuncionario", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    private Funcionario funcionario;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Situacao() {
    }

    public Situacao(Integer idsituacao) {
        this.idsituacao = idsituacao;
    }

    public Integer getIdsituacao() {
        return idsituacao;
    }

    public void setIdsituacao(Integer idsituacao) {
        this.idsituacao = idsituacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsituacao != null ? idsituacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Situacao)) {
            return false;
        }
        Situacao other = (Situacao) object;
        if ((this.idsituacao == null && other.idsituacao != null) || (this.idsituacao != null && !this.idsituacao.equals(other.idsituacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Situacao[ idsituacao=" + idsituacao + " ]";
    }
    
}

