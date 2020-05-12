package br.com.tecsegapi.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "setor")
public class Setor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsetor")
    private Integer idsetor;
	@Size(max = 50)
    @Column(name = "nome")
    private String nome;
	@JoinColumn(name = "funcionario_idfuncionario", referencedColumnName = "idfuncionario")
	@JsonIgnoreProperties("setor")
    @ManyToOne(optional = false)
    private Funcionario funcionario;
	
	public Setor() {
	
	}

	
	public Integer getIdsetor() {
		return idsetor;
	}



	public void setIdsetor(Integer idsetor) {
		this.idsetor = idsetor;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Setor other = (Setor) obj;
		if (idsetor == null) {
			if (other.idsetor != null)
				return false;
		} else if (!idsetor.equals(other.idsetor))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idsetor == null) ? 0 : idsetor.hashCode());
		return result;
	}


	@Override
	public String toString() {
		return "Setor [nome=" + nome + "]";
	}
	
	
	
	

}
