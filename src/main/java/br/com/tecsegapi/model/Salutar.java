package br.com.tecsegapi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "salutar")
public class Salutar implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsalutar")
    private Integer idsalutar;
	@Column(name = "nome")
    private String nome;
	@Column(name = "dataemissao")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
	@Column(name = "admitidos")
    private Integer admitidos;
	@Column(name = "afastados")
    private Integer afastados;
	@Column(name = "inativos")
    private Integer inativos;
	@Column(name = "ativos")
    private Integer ativos;
	@Column(name = "total")
    private Integer total;
	@JoinColumn(name = "loja_idloja", referencedColumnName = "idloja")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Loja loja;
	@JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;
	
	public Integer getAtivos() {
		return ativos;
	}

	public void setAtivos(Integer ativos) {
		this.ativos = ativos;
	}

	
	

	
	public Salutar() {
	
	}

	public Integer getIdsalutar() {
		return idsalutar;
	}

	public void setIdsalutar(Integer idsalutar) {
		this.idsalutar = idsalutar;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataemissao() {
		return dataemissao;
	}

	public void setDataemissao(Date dataemissao) {
		this.dataemissao = dataemissao;
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

	

	public Integer getAdmitidos() {
		return admitidos;
	}

	public void setAdmitidos(Integer admitidos) {
		this.admitidos = admitidos;
	}

	public Integer getAfastados() {
		return afastados;
	}

	public void setAfastados(Integer afastados) {
		this.afastados = afastados;
	}

	

	public Integer getInativos() {
		return inativos;
	}

	public void setInativos(Integer inativos) {
		this.inativos = inativos;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idsalutar == null) ? 0 : idsalutar.hashCode());
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
		Salutar other = (Salutar) obj;
		if (idsalutar == null) {
			if (other.idsalutar != null)
				return false;
		} else if (!idsalutar.equals(other.idsalutar))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Salutar [idsalutar=" + idsalutar + "]";
	}

	

}
