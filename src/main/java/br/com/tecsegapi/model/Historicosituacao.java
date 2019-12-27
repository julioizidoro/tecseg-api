package br.com.tecsegapi.model;

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

@Entity
@Table(name = "historicosituacao")
public class Historicosituacao {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhistoricosituacao")
    private Integer idhistoricosituacao;
	@Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
	@JoinColumn(name = "funcionario_idfuncionario", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    private Funcionario funcionario;
	@JoinColumn(name = "codigoafastamento_idcodigoafastamento", referencedColumnName = "idcodigoafastamento")
    @ManyToOne(optional = false)
    private Codigoafastamento codigoafastamento;
	@JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;
	
	public Historicosituacao() {
	
	}

	public Integer getIdhistoricosituacao() {
		return idhistoricosituacao;
	}

	public void setIdhistoricosituacao(Integer idhistoricosituacao) {
		this.idhistoricosituacao = idhistoricosituacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Codigoafastamento getCodigoafastamento() {
		return codigoafastamento;
	}

	public void setCodigoafastamento(Codigoafastamento codigoafastamento) {
		this.codigoafastamento = codigoafastamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idhistoricosituacao == null) ? 0 : idhistoricosituacao.hashCode());
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
		Historicosituacao other = (Historicosituacao) obj;
		if (idhistoricosituacao == null) {
			if (other.idhistoricosituacao != null)
				return false;
		} else if (!idhistoricosituacao.equals(other.idhistoricosituacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Historicosituacao [idhistoricosituacao=" + idhistoricosituacao + "]";
	}
	
	
	
	

}
