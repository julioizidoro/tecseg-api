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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "treinamento")
public class Treinamento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtreinamento")
    private Integer idtreinamento;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "hora")
    private String hora;
    @Column(name = "duracao")
    private String duracao;
    @Size(max =100)
    @Column(name = "instrutor")
    private String instrutor;
    @Column(name = "conteudo")
    @Lob
    private String conteudo;
    @Size(max =9)
    @Column(name = "local")
    private String local;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "situacao")
    private String situacao;
    @JoinColumn(name = "treinamentotipo_idtreinamentotipo", referencedColumnName = "idtreinamentotipo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Treinamentotipo treinamentotipo;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;
    
	public Treinamento() {
		
	}

	public Integer getIdtreinamento() {
		return idtreinamento;
	}

	public void setIdtreinamento(Integer idtreinamento) {
		this.idtreinamento = idtreinamento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(String instrutor) {
		this.instrutor = instrutor;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Treinamentotipo getTreinamentotipo() {
		return treinamentotipo;
	}

	public void setTreinamentotipo(Treinamentotipo treinamentotipo) {
		this.treinamentotipo = treinamentotipo;
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
		result = prime * result + ((idtreinamento == null) ? 0 : idtreinamento.hashCode());
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
		Treinamento other = (Treinamento) obj;
		if (idtreinamento == null) {
			if (other.idtreinamento != null)
				return false;
		} else if (!idtreinamento.equals(other.idtreinamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Treinamento [idtreinamento=" + idtreinamento + "]";
	}
	
	
    
    

}
