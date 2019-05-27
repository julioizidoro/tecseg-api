package br.com.tecsegapi.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "setor")
public class Setor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsetor")
    private Integer idsetor;
	@Size(max = 50)
    @Column(name = "nome")
    private String nome;

	public Setor() {
	
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idsetor == null) ? 0 : idsetor.hashCode());
		return result;
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
	public String toString() {
		return "Setor [nome=" + nome + "]";
	}
	
	
	
	

}
