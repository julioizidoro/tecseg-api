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
@Table(name = "contasusuario")
public class Contasusuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontasusuario")
    private Integer idcontasusuario;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "hora")
    private String hora;
    @Column(name = "operacao")
    private String operacao;
    @JoinColumn(name = "contas_idcontas", referencedColumnName = "idcontas")
    @ManyToOne(optional = false)
    private Contas contas;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Contasusuario() {
    }

    public Contasusuario(Integer idcontasusuario) {
        this.idcontasusuario = idcontasusuario;
    }

    public Integer getIdcontasusuario() {
        return idcontasusuario;
    }

    public void setIdcontasusuario(Integer idcontasusuario) {
        this.idcontasusuario = idcontasusuario;
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

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Contas getContas() {
        return contas;
    }

    public void setContas(Contas contas) {
        this.contas = contas;
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
        hash += (idcontasusuario != null ? idcontasusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contasusuario)) {
            return false;
        }
        Contasusuario other = (Contasusuario) object;
        if ((this.idcontasusuario == null && other.idcontasusuario != null) || (this.idcontasusuario != null && !this.idcontasusuario.equals(other.idcontasusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Contasusuario[ idcontasusuario=" + idcontasusuario + " ]";
    }
    
}
