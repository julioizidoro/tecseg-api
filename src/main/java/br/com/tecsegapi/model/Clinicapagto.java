package br.com.tecsegapi.model;

import java.io.Serializable;
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

@Entity
@Table(name = "clinicapagto")
public class Clinicapagto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclinicapagto")
    private Integer idclinicapagto;
    @Column(name = "funcionarios")
    private Integer funcionarios;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorfuncionarios")
    private Float valorfuncionarios;
    @Column(name = "valorexames")
    private Float valorexames;
    @Column(name = "valortotal")
    private Float valortotal;
    @Column(name = "mesano")
    private String mesano;
    @JoinColumn(name = "clinica_idclinica", referencedColumnName = "idclinica")
    @ManyToOne(optional = false)
    private Clinica clinica;
    @JoinColumn(name = "loja_idloja", referencedColumnName = "idloja")
    @ManyToOne(optional = false)
    private Loja loja;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinicapagto")
    private List<Clinicapagtoexame> clinicapagtoexameList;

    public Clinicapagto() {
    }

    public Clinicapagto(Integer idclinicapagto) {
        this.idclinicapagto = idclinicapagto;
    }

    public Integer getIdclinicapagto() {
        return idclinicapagto;
    }

    public void setIdclinicapagto(Integer idclinicapagto) {
        this.idclinicapagto = idclinicapagto;
    }

    public Integer getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Integer funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Float getValorfuncionarios() {
        return valorfuncionarios;
    }

    public void setValorfuncionarios(Float valorfuncionarios) {
        this.valorfuncionarios = valorfuncionarios;
    }

    public Float getValorexames() {
        return valorexames;
    }

    public void setValorexames(Float valorexames) {
        this.valorexames = valorexames;
    }

    public Float getValortotal() {
        return valortotal;
    }

    public void setValortotal(Float valortotal) {
        this.valortotal = valortotal;
    }

    public String getMesano() {
        return mesano;
    }

    public void setMesano(String mesano) {
        this.mesano = mesano;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
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

    public List<Clinicapagtoexame> getClinicapagtoexameList() {
        return clinicapagtoexameList;
    }

    public void setClinicapagtoexameList(List<Clinicapagtoexame> clinicapagtoexameList) {
        this.clinicapagtoexameList = clinicapagtoexameList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclinicapagto != null ? idclinicapagto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clinicapagto)) {
            return false;
        }
        Clinicapagto other = (Clinicapagto) object;
        if ((this.idclinicapagto == null && other.idclinicapagto != null) || (this.idclinicapagto != null && !this.idclinicapagto.equals(other.idclinicapagto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Clinicapagto[ idclinicapagto=" + idclinicapagto + " ]";
    }
    
}

