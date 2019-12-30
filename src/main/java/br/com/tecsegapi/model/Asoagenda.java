package br.com.tecsegapi.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "asoagenda")
public class Asoagenda implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idasoagenda")
    private Integer idasoagenda;
	@Column(name = "dataexame")
    @Temporal(TemporalType.DATE)
    private Date dataexame;
	@Size(max = 10)
    @Column(name = "hora")
    private String hora;
	@Size(max = 10)
    @Column(name = "situacao")
    private String situacao;
	@Column(name = "datacancelamento")
    @Temporal(TemporalType.DATE)
    private Date datacancelamento;
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getDatacancelamento() {
		return datacancelamento;
	}
	public void setDatacancelamento(Date datacancelamento) {
		this.datacancelamento = datacancelamento;
	}
	@JoinColumn(name = "funcionario_idfuncionario", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    private Funcionario funcionario;
	@JoinColumn(name = "asotipo_idasotipo", referencedColumnName = "idasotipo")
	@ManyToOne(optional = false)
	private Asotipo asotipo;
	@JoinColumn(name = "funcao_idfuncao", referencedColumnName = "idfuncao")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Funcao funcao;
	@JoinColumn(name = "clinica_idclinica", referencedColumnName = "idclinica")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Clinica clinica;
	@JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;
	
	public Integer getIdasoagenda() {
		return idasoagenda;
	}
	public void setIdasoagenda(Integer idasoagenda) {
		this.idasoagenda = idasoagenda;
	}
	public Date getDataexame() {
		return dataexame;
	}
	public void setDataexame(Date dataexame) {
		this.dataexame = dataexame;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Asotipo getAsotipo() {
		return asotipo;
	}
	public void setAsotipo(Asotipo asotipo) {
		this.asotipo = asotipo;
	}
	public Funcao getFuncao() {
		return funcao;
	}
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	
	
	public Clinica getClinica() {
		return clinica;
	}
	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idasoagenda == null) ? 0 : idasoagenda.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asoagenda other = (Asoagenda) obj;
		if (idasoagenda == null) {
			if (other.idasoagenda != null)
				return false;
		} else if (!idasoagenda.equals(other.idasoagenda))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Asoagenda [idasoagenda=" + idasoagenda + "]";
	}
	
	
	
	

}
