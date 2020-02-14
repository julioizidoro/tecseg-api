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
@Table(name = "epi")
public class Epi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idepi")
    private Integer idepi;
    @Column(name = "diasrevisao")
    private Integer diasrevisao;
    @Column(name = "diasvalidade")
    private Integer diasvalidade;
    @Column(name = "devolver")
    private String devolver;
    @JoinColumn(name = "epitipo_idepitipo", referencedColumnName = "idepitipo")
    @ManyToOne(optional = false)
    private Epitipo epitipo;
    @JoinColumn(name = "estoque_idestoque", referencedColumnName = "idestoque")
    @ManyToOne(optional = false)
    private Estoque estoque;

    public Epi() {
    }

    public Epi(Integer idepi) {
        this.idepi = idepi;
    }

    public Integer getIdepi() {
        return idepi;
    }

    public void setIdepi(Integer idepi) {
        this.idepi = idepi;
    }

    public Integer getDiasrevisao() {
        return diasrevisao;
    }

    public void setDiasrevisao(Integer diasrevisao) {
        this.diasrevisao = diasrevisao;
    }

    public Integer getDiasvalidade() {
        return diasvalidade;
    }

    public void setDiasvalidade(Integer diasvalidade) {
        this.diasvalidade = diasvalidade;
    }

    

    public String getDevolver() {
		return devolver;
	}

	public void setDevolver(String devolver) {
		this.devolver = devolver;
	}

	public Epitipo getEpitipo() {
        return epitipo;
    }

    public void setEpitipo(Epitipo epitipo) {
        this.epitipo = epitipo;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idepi != null ? idepi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Epi)) {
            return false;
        }
        Epi other = (Epi) object;
        if ((this.idepi == null && other.idepi != null) || (this.idepi != null && !this.idepi.equals(other.idepi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Epi[ idepi=" + idepi + " ]";
    }
    
}
