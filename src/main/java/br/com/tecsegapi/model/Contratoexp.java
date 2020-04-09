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
@Table(name = "contratoexp")
public class Contratoexp implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontratoexp")
    private Integer idcontratoexp;
    @Column(name = "datavencendo")
    @Temporal(TemporalType.DATE)
    private Date datavencendo;
    @Column(name = "diasvencendo")
    private Integer diasvencendo;
    @Column(name = "tipovencimento")
    private String tipovencimento;
    @JoinColumn(name = "funcionario_idfuncionario", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    private Funcionario funcionario;

    public Contratoexp() {
    }

    public Contratoexp(Integer idcontratoexp) {
        this.idcontratoexp = idcontratoexp;
    }

    public Integer getIdcontratoexp() {
        return idcontratoexp;
    }

    public void setIdcontratoexp(Integer idcontratoexp) {
        this.idcontratoexp = idcontratoexp;
    }

    public Date getDatavencendo() {
        return datavencendo;
    }

    public void setDatavencendo(Date datavencendo) {
        this.datavencendo = datavencendo;
    }

    public Integer getDiasvencendo() {
        return diasvencendo;
    }

    public void setDiasvencendo(Integer diasvencendo) {
        this.diasvencendo = diasvencendo;
    }

    public String getTipovencimento() {
        return tipovencimento;
    }

    public void setTipovencimento(String tipovencimento) {
        this.tipovencimento = tipovencimento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontratoexp != null ? idcontratoexp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contratoexp)) {
            return false;
        }
        Contratoexp other = (Contratoexp) object;
        if ((this.idcontratoexp == null && other.idcontratoexp != null) || (this.idcontratoexp != null && !this.idcontratoexp.equals(other.idcontratoexp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Contratoexp[ idcontratoexp=" + idcontratoexp + " ]";
    }
    
}

