package br.com.tecsegapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "planilha")
public class Planilha implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "matricula")
    private Integer matricula;
	@Column(name = "nome_funcionario")
    private String nome_funcionario;
	@Column(name = "nascimento")
	 @Temporal(TemporalType.DATE)
    private Date nascimento;
	@Column(name = "sexo")
    private String sexo;
	@Column(name = "situacao")
    private String situacao;
	@Column(name = "dataadmissao")
	@Temporal(TemporalType.DATE)
    private Date dataadmissao;
	@Column(name = "pis")
    private String pis;
	@Column(name = "rg")
    private String rg;
	@Column(name = "ufrg")
    private String ufrg;
	@Column(name = "cpf")
    private String cpf;
	@Column(name = "ctps")
    private String ctps;
    @Column(name = "cbo")
    private String cbo;
    @Column(name = "setor")
    private String setor;
    @Column(name = "cargo")
    private String cargo;
    
	public Planilha() {
	
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome_funcionario() {
		return nome_funcionario;
	}

	public void setNome_funcionario(String nome_funcionario) {
		this.nome_funcionario = nome_funcionario;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getDataadmissao() {
		return dataadmissao;
	}

	public void setDataadmissao(Date dataadmissao) {
		this.dataadmissao = dataadmissao;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getUfrg() {
		return ufrg;
	}

	public void setUfrg(String ufrg) {
		this.ufrg = ufrg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	

	public String getCbo() {
		return cbo;
	}

	public void setCbo(String cbo) {
		this.cbo = cbo;
	}

	



	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Planilha other = (Planilha) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Planilha [nome_funcionario=" + nome_funcionario + "]";
	}
	
	
    
    
	
	

}
