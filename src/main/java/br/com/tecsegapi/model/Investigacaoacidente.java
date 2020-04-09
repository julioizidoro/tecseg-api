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
@Table(name = "investigacaoacidente")
public class Investigacaoacidente implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinvestigacaoacidente")
    private Integer idinvestigacaoacidente;
    @Column(name = "numeroacidenteanterior")
    private Integer numeroacidenteanterior;
    @Column(name = "tomaremediocontrolado")
    private String tomaremediocontrolado;
    @Column(name = "qual")
    private String qual;
    @Column(name = "houveafastamento")
    private String houveafastamento;
    @Column(name = "tipoacidente")
    private String tipoacidente;
    @Column(name = "naturezalesao")
    private String naturezalesao;
    @Column(name = "partecorpo")
    private String partecorpo;
    @Column(name = "agentecausador")
    private String agentecausador;
    @Column(name = "hospital")
    private String hospital;
    @Column(name = "dataacidente")
    @Temporal(TemporalType.DATE)
    private Date dataacidente;
    @Column(name = "hora")
    private String hora;
    @Column(name = "local")
    private String local;
    @Column(name = "horastrabalho")
    private String horastrabalho;
    @Column(name = "fonefuncionario")
    private String fonefuncionario;
    @Lob
    @Column(name = "descricaoacidente")
    private String descricaoacidente;
    @JoinColumn(name = "funcionario_idfuncionario", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    private Funcionario funcionario;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Investigacaoacidente() {
    }

    public Investigacaoacidente(Integer idinvestigacaoacidente) {
        this.idinvestigacaoacidente = idinvestigacaoacidente;
    }

    public Integer getIdinvestigacaoacidente() {
        return idinvestigacaoacidente;
    }

    public void setIdinvestigacaoacidente(Integer idinvestigacaoacidente) {
        this.idinvestigacaoacidente = idinvestigacaoacidente;
    }

    public Integer getNumeroacidenteanterior() {
        return numeroacidenteanterior;
    }

    public void setNumeroacidenteanterior(Integer numeroacidenteanterior) {
        this.numeroacidenteanterior = numeroacidenteanterior;
    }

    public String getTomaremediocontrolado() {
        return tomaremediocontrolado;
    }

    public void setTomaremediocontrolado(String tomaremediocontrolado) {
        this.tomaremediocontrolado = tomaremediocontrolado;
    }

    public String getQual() {
        return qual;
    }

    public void setQual(String qual) {
        this.qual = qual;
    }

    public String getHouveafastamento() {
        return houveafastamento;
    }

    public void setHouveafastamento(String houveafastamento) {
        this.houveafastamento = houveafastamento;
    }

    public String getTipoacidente() {
        return tipoacidente;
    }

    public void setTipoacidente(String tipoacidente) {
        this.tipoacidente = tipoacidente;
    }

    public String getNaturezalesao() {
        return naturezalesao;
    }

    public void setNaturezalesao(String naturezalesao) {
        this.naturezalesao = naturezalesao;
    }

    public String getPartecorpo() {
        return partecorpo;
    }

    public void setPartecorpo(String partecorpo) {
        this.partecorpo = partecorpo;
    }

    public String getAgentecausador() {
        return agentecausador;
    }

    public void setAgentecausador(String agentecausador) {
        this.agentecausador = agentecausador;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Date getDataacidente() {
        return dataacidente;
    }

    public void setDataacidente(Date dataacidente) {
        this.dataacidente = dataacidente;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getHorastrabalho() {
        return horastrabalho;
    }

    public void setHorastrabalho(String horastrabalho) {
        this.horastrabalho = horastrabalho;
    }

    public String getFonefuncionario() {
        return fonefuncionario;
    }

    public void setFonefuncionario(String fonefuncionario) {
        this.fonefuncionario = fonefuncionario;
    }

    public String getDescricaoacidente() {
        return descricaoacidente;
    }

    public void setDescricaoacidente(String descricaoacidente) {
        this.descricaoacidente = descricaoacidente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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
        hash += (idinvestigacaoacidente != null ? idinvestigacaoacidente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Investigacaoacidente)) {
            return false;
        }
        Investigacaoacidente other = (Investigacaoacidente) object;
        if ((this.idinvestigacaoacidente == null && other.idinvestigacaoacidente != null) || (this.idinvestigacaoacidente != null && !this.idinvestigacaoacidente.equals(other.idinvestigacaoacidente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Investigacaoacidente[ idinvestigacaoacidente=" + idinvestigacaoacidente + " ]";
    }
    
}
