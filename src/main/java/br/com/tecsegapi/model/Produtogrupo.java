package br.com.tecsegapi.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtogrupo")
public class Produtogrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprodutogrupo")
    private Integer idprodutogrupo;
    @Column(name = "descricao")
    private String descricao;

    public Produtogrupo() {
    }

    public Produtogrupo(Integer idprodutogrupo) {
        this.idprodutogrupo = idprodutogrupo;
    }

    public Integer getIdprodutogrupo() {
        return idprodutogrupo;
    }

    public void setIdprodutogrupo(Integer idprodutogrupo) {
        this.idprodutogrupo = idprodutogrupo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprodutogrupo != null ? idprodutogrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtogrupo)) {
            return false;
        }
        Produtogrupo other = (Produtogrupo) object;
        if ((this.idprodutogrupo == null && other.idprodutogrupo != null) || (this.idprodutogrupo != null && !this.idprodutogrupo.equals(other.idprodutogrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Produtogrupo[ idprodutogrupo=" + idprodutogrupo + " ]";
    }
    
}

