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
@Table(name = "epicompra")
public class Epicompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idepicompra")
    private Integer idepicompra;
    @Column(name = "datacompra")
    @Temporal(TemporalType.DATE)
    private Date datacompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorunitario")
    private Float valorunitario;
    @Column(name = "quantidade")
    private Float quantidade;
    @Column(name = "ca")
    private String ca;
    @JoinColumn(name = "clientes_idclientes", referencedColumnName = "idclientes")
    @ManyToOne(optional = false)
    private Clientes clientes;
    @JoinColumn(name = "produto_idproduto", referencedColumnName = "idproduto")
    @ManyToOne(optional = false)
    private Produto produto;

    public Epicompra() {
    }

    public Epicompra(Integer idepicompra) {
        this.idepicompra = idepicompra;
    }

    public Integer getIdepicompra() {
        return idepicompra;
    }

    public void setIdepicompra(Integer idepicompra) {
        this.idepicompra = idepicompra;
    }

    public Date getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(Date datacompra) {
        this.datacompra = datacompra;
    }

    public Float getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(Float valorunitario) {
        this.valorunitario = valorunitario;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
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
        hash += (idepicompra != null ? idepicompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Epicompra)) {
            return false;
        }
        Epicompra other = (Epicompra) object;
        if ((this.idepicompra == null && other.idepicompra != null) || (this.idepicompra != null && !this.idepicompra.equals(other.idepicompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Epicompra[ idepicompra=" + idepicompra + " ]";
    }
    
}

