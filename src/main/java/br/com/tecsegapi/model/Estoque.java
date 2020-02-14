package br.com.tecsegapi.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estoque")
public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestoque")
    private Integer idestoque;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidadeestoque")
    private Float quantidadeestoque;
    @Column(name = "quantidademinima")
    private Float quantidademinima;
    @JoinColumn(name = "produto_idproduto", referencedColumnName = "idproduto")
    @ManyToOne(optional = false)
    private Produto produto;

    public Estoque() {
    }

    public Estoque(Integer idestoque) {
        this.idestoque = idestoque;
    }

    public Integer getIdestoque() {
        return idestoque;
    }

    public void setIdestoque(Integer idestoque) {
        this.idestoque = idestoque;
    }

    public Float getQuantidadeestoque() {
        return quantidadeestoque;
    }

    public void setQuantidadeestoque(Float quantidadeestoque) {
        this.quantidadeestoque = quantidadeestoque;
    }

    public Float getQuantidademinima() {
        return quantidademinima;
    }

    public void setQuantidademinima(Float quantidademinima) {
        this.quantidademinima = quantidademinima;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestoque != null ? idestoque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estoque)) {
            return false;
        }
        Estoque other = (Estoque) object;
        if ((this.idestoque == null && other.idestoque != null) || (this.idestoque != null && !this.idestoque.equals(other.idestoque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EstoqueRepository[ idestoque=" + idestoque + " ]";
    }
    
}

