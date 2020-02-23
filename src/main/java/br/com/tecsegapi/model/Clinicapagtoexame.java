package br.com.tecsegapi.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "clinicapagtoexame")
public class Clinicapagtoexame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclinicapagtoexame")
    private Integer idclinicapagtoexame;
    @Column(name = "quantidade")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorunitario")
    private Float valorunitario;
    @Column(name = "valortotal")
    private Float valortotal;
    @JoinColumn(name = "clinicapagto_idclinicapagto", referencedColumnName = "idclinicapagto")
    @ManyToOne(optional = false)
    private Clinicapagto clinicapagto;
    @JoinColumn(name = "asotipo_idasotipo", referencedColumnName = "idasotipo")
	@ManyToOne(optional = false)
	private Asotipo asotipo;
    
    public Clinicapagtoexame() {
    }

    public Clinicapagtoexame(Integer idclinicapagtoexame) {
        this.idclinicapagtoexame = idclinicapagtoexame;
    }

    public Integer getIdclinicapagtoexame() {
        return idclinicapagtoexame;
    }

    public void setIdclinicapagtoexame(Integer idclinicapagtoexame) {
        this.idclinicapagtoexame = idclinicapagtoexame;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(Float valorunitario) {
        this.valorunitario = valorunitario;
    }

    public Float getValortotal() {
        return valortotal;
    }

    public void setValortotal(Float valortotal) {
        this.valortotal = valortotal;
    }

    public Clinicapagto getClinicapagto() {
        return clinicapagto;
    }

    public void setClinicapagto(Clinicapagto clinicapagto) {
        this.clinicapagto = clinicapagto;
    }

    public Asotipo getAsotipo() {
		return asotipo;
	}

	public void setAsotipo(Asotipo asotipo) {
		this.asotipo = asotipo;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idclinicapagtoexame != null ? idclinicapagtoexame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clinicapagtoexame)) {
            return false;
        }
        Clinicapagtoexame other = (Clinicapagtoexame) object;
        if ((this.idclinicapagtoexame == null && other.idclinicapagtoexame != null) || (this.idclinicapagtoexame != null && !this.idclinicapagtoexame.equals(other.idclinicapagtoexame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Clinicapagtoexame[ idclinicapagtoexame=" + idclinicapagtoexame + " ]";
    }
    
}
