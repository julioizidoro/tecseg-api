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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "contas")
public class Contas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontas")
    private Integer idcontas;
    @Column(name = "documento")
    private Integer documento;
    @Column(name = "datacompra")
    @Temporal(TemporalType.DATE)
    private Date datacompra;
    @Column(name = "datavencimento")
    @Temporal(TemporalType.DATE)
    private Date datavencimento;
    @Column(name = "datapagamento")
    @Temporal(TemporalType.DATE)
    private Date datapagamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorcompra")
    private Float valorcompra;
    @Column(name = "valorpago")
    private Float valorpago;
    @Column(name = "formapagamento")
    private String formapagamento;
    @Lob
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "clientes_idclientes", referencedColumnName = "idclientes")
    @ManyToOne(optional = false)
    private Clientes clientes;

    public Contas() {
    }

    public Contas(Integer idcontas) {
        this.idcontas = idcontas;
    }

    public Integer getIdcontas() {
        return idcontas;
    }

    public void setIdcontas(Integer idcontas) {
        this.idcontas = idcontas;
    }

    public Date getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(Date datacompra) {
        this.datacompra = datacompra;
    }

    

    public Date getDatavencimento() {
		return datavencimento;
	}

	public void setDatavencimento(Date datavencimento) {
		this.datavencimento = datavencimento;
	}

	public Date getDatapagamento() {
        return datapagamento;
    }

    public void setDatapagamento(Date datapagamento) {
        this.datapagamento = datapagamento;
    }

    public Float getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(Float valorcompra) {
        this.valorcompra = valorcompra;
    }

    public Float getValorpago() {
        return valorpago;
    }

    public void setValorpago(Float valorpago) {
        this.valorpago = valorpago;
    }

    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    
    public Integer getDocumento() {
		return documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontas != null ? idcontas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contas)) {
            return false;
        }
        Contas other = (Contas) object;
        if ((this.idcontas == null && other.idcontas != null) || (this.idcontas != null && !this.idcontas.equals(other.idcontas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Contas[ idcontas=" + idcontas + " ]";
    }
    
}
