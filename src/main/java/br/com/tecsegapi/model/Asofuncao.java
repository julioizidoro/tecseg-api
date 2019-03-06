package br.com.tecsegapi.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "asofuncao")
public class Asofuncao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idasofuncao")
    private Integer idasofuncao;
    @Column(name = "periodo")
    private Integer periodo;
    @JoinColumn(name = "funcao_idfuncao", referencedColumnName = "idfuncao")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Funcao funcao;
    @JoinColumn(name = "tipoatestado_idtipoatestado", referencedColumnName = "idtipoatestado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tipoatestado tipoatestado;
    
    public Asofuncao() {
    }

    public Asofuncao(Integer idasofuncao) {
        this.idasofuncao = idasofuncao;
    }

    public Integer getIdasofuncao() {
        return idasofuncao;
    }

    public void setIdasofuncao(Integer idasofuncao) {
        this.idasofuncao = idasofuncao;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

   

    public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public Tipoatestado getTipoatestado() {
		return tipoatestado;
	}

	public void setTipoatestado(Tipoatestado tipoatestado) {
		this.tipoatestado = tipoatestado;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idasofuncao != null ? idasofuncao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asofuncao)) {
            return false;
        }
        Asofuncao other = (Asofuncao) object;
        if ((this.idasofuncao == null && other.idasofuncao != null) || (this.idasofuncao != null && !this.idasofuncao.equals(other.idasofuncao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tecseg.model.Asofuncao[ idasofuncao=" + idasofuncao + " ]";
    }
    
}

