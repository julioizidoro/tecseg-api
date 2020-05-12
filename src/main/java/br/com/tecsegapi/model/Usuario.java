package br.com.tecsegapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario")
	private int idusuario;
	@NotEmpty
	@Size(max = 100)
	@Column(name = "nome")
	private String nome;
	@Column(name = "datanascimento")
    @Temporal(TemporalType.DATE)
    private Date nascimento;
	@NotEmpty
	@Size(max = 45)
	@Column(name = "login")
	private String login;
	@NotEmpty
	@Size(max = 200)
	@Column(name = "senha")
	private String senha;
	@NotEmpty
	@Size(max = 1)
	@Column(name = "sexo")
	private String sexo;
	@NotEmpty
	@Size(max = 200)
	@Column(name = "email")
	private String email;
	@NotEmpty
	@Size(max = 15)
	@Column(name = "fonecelular")
	private String fonecelular;
	@Column(name = "situacao")
	private boolean situacao;
	@JoinColumn(name = "acesso_idacesso", referencedColumnName = "idacesso")
	@OneToOne(optional = false, fetch = FetchType.EAGER)
	private Acesso acesso;
	@Column(name = "urlfoto")
	private String urlfoto;
	@Column(name = "urlassinatura")
	private String urlassinatura;
	@Column(name = "registromte")
	private String registromte;
	@JoinColumn(name = "funcao_idfuncao", referencedColumnName = "idfuncao")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Funcao funcao;
	
	
	public Usuario() {
		
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFonecelular() {
		return fonecelular;
	}

	public void setFonecelular(String fonecelular) {
		this.fonecelular = fonecelular;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

	public String getUrlfoto() {
		return urlfoto;
	}

	public void setUrlfoto(String urlfoto) {
		this.urlfoto = urlfoto;
	}

	public String getUrlassinatura() {
		return urlassinatura;
	}

	public void setUrlassinatura(String urlassinatura) {
		this.urlassinatura = urlassinatura;
	}

	public String getRegistromte() {
		return registromte;
	}

	public void setRegistromte(String registromte) {
		this.registromte = registromte;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idusuario;
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
		Usuario other = (Usuario) obj;
		if (idusuario != other.idusuario)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + idusuario + ", nome=" + nome + "]";
	}
}
	