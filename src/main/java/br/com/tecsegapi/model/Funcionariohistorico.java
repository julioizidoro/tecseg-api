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
@Table(name = "funcionariohistorico")
public class Funcionariohistorico implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfuncionariohistorico")
    private Integer idfuncionariohistorico;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "hora")
    private String hora;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "funcionario_idfuncionario", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    private Funcionario funcionario;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Funcionariohistorico() {
    }

    public Funcionariohistorico(Integer idfuncionariohistorico) {
        this.idfuncionariohistorico = idfuncionariohistorico;
    }

    public Integer getIdfuncionariohistorico() {
        return idfuncionariohistorico;
    }

    public void setIdfuncionariohistorico(Integer idfuncionariohistorico) {
        this.idfuncionariohistorico = idfuncionariohistorico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        hash += (idfuncionariohistorico != null ? idfuncionariohistorico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionariohistorico)) {
            return false;
        }
        Funcionariohistorico other = (Funcionariohistorico) object;
        if ((this.idfuncionariohistorico == null && other.idfuncionariohistorico != null) || (this.idfuncionariohistorico != null && !this.idfuncionariohistorico.equals(other.idfuncionariohistorico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Funcionariohistorico[ idfuncionariohistorico=" + idfuncionariohistorico + " ]";
    }
    
}
