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
@Table(name = "clientes")
public class Clientes  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclientes")
    private Integer idclientes;
	@Column(name = "nome")
    private String nome;
	@Column(name = "tipo")
    private String tipo;
	@Column(name = "cpf")
    private String cpf;
	@Column(name = "datanascimento")
    @Temporal(TemporalType.DATE)
    private Date datanascimento;
	@Column(name = "logradouro")
    private String logradouro;
	@Column(name = "numero")
    private String numero;
	@Column(name = "complemento")
    private String complemento;
	@Column(name = "bairro")
    private String bairro;
	@Column(name = "cidade")
    private String cidade;
	@Column(name = "estado")
    private String estado;
	@Column(name = "cep")
    private String cep;
	@Column(name = "fonecelular")
    private String fonecelular;
	@Column(name = "fonefixo")
    private String fonefixo;
	@Column(name = "codigosysmo")
    private String codigosysmo;
	@Column(name = "email")
    private String email;
	@Column(name = "contato")
    private String contato;
	
	public Clientes() {
	
	}

	public Integer getIdclientes() {
		return idclientes;
	}

	public void setIdclientes(Integer idclientes) {
		this.idclientes = idclientes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getFonecelular() {
		return fonecelular;
	}

	public void setFonecelular(String fonecelular) {
		this.fonecelular = fonecelular;
	}

	public String getFonefixo() {
		return fonefixo;
	}

	public void setFonefixo(String fonefixo) {
		this.fonefixo = fonefixo;
	}

	public String getCodigosysmo() {
		return codigosysmo;
	}

	public void setCodigosysmo(String codigosysmo) {
		this.codigosysmo = codigosysmo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idclientes == null) ? 0 : idclientes.hashCode());
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
		Clientes other = (Clientes) obj;
		if (idclientes == null) {
			if (other.idclientes != null)
				return false;
		} else if (!idclientes.equals(other.idclientes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Clientes [idclientes=" + idclientes + ", nome=" + nome + "]";
	}
	
	
	
	
	
	

}
