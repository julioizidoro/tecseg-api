package br.com.tecsegapi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "relatorioseguranca")
public class Relatorioseguranca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelatorioseguranca")
    private Integer idrelatorioseguranca;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "loja_idloja", referencedColumnName = "idloja")
    @ManyToOne(optional = false)
    private Loja loja;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
   

    public Relatorioseguranca() {
    }

    public Relatorioseguranca(Integer idrelatorioseguranca) {
        this.idrelatorioseguranca = idrelatorioseguranca;
    }

    public Integer getIdrelatorioseguranca() {
        return idrelatorioseguranca;
    }

    public void setIdrelatorioseguranca(Integer idrelatorioseguranca) {
        this.idrelatorioseguranca = idrelatorioseguranca;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
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
        hash += (idrelatorioseguranca != null ? idrelatorioseguranca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relatorioseguranca)) {
            return false;
        }
        Relatorioseguranca other = (Relatorioseguranca) object;
        if ((this.idrelatorioseguranca == null && other.idrelatorioseguranca != null) || (this.idrelatorioseguranca != null && !this.idrelatorioseguranca.equals(other.idrelatorioseguranca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Relatorioseguranca[ idrelatorioseguranca=" + idrelatorioseguranca + " ]";
    }
    
}

