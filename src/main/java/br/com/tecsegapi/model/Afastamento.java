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
@Table(name = "afastamento")
public class Afastamento  implements Serializable{
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idafastamento")
    private Integer idafastamento;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "retorno")
    @Temporal(TemporalType.DATE)
    private Date retorno;
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "codigoafastamento_idcodigoafastamento", referencedColumnName = "idcodigoafastamento")
    @ManyToOne(optional = false)
    private Codigoafastamento codigoafastamento;
    @JoinColumn(name = "funcionario_idfuncionario", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    private Funcionario funcionario;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Afastamento() {
    }

    public Afastamento(Integer idafastamento) {
        this.idafastamento = idafastamento;
    }

    public Integer getIdafastamento() {
        return idafastamento;
    }

    public void setIdafastamento(Integer idafastamento) {
        this.idafastamento = idafastamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getRetorno() {
        return retorno;
    }

    public void setRetorno(Date retorno) {
        this.retorno = retorno;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Codigoafastamento getCodigoafastamento() {
        return codigoafastamento;
    }

    public void setCodigoafastamento(Codigoafastamento codigoafastamento) {
        this.codigoafastamento = codigoafastamento;
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
        hash += (idafastamento != null ? idafastamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Afastamento)) {
            return false;
        }
        Afastamento other = (Afastamento) object;
        if ((this.idafastamento == null && other.idafastamento != null) || (this.idafastamento != null && !this.idafastamento.equals(other.idafastamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Afastamento[ idafastamento=" + idafastamento + " ]";
    }
    
}

