package br.com.tecsegapi.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "treinamentoarquivo")
public class Treinamentoarquivo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtreinamentoarquivo")
    private Integer idtreinamentoarquivo;
	@Size(max =200)
	@Column(name = "nome")
	private String nome;
	@Column(name = "datainclusao")
    @Temporal(TemporalType.DATE)
    private Date datainclusao;
	@Column(name = "dataexclusao")
    @Temporal(TemporalType.DATE)
    private Date dataexclusao;
	@Column(name = "excluido")
    private boolean excluido;
	@JoinColumn(name = "treinamento_idtreinamento", referencedColumnName = "idtreinamento")
    @ManyToOne(optional = false)
    private Treinamento treinamento;
	
	public Treinamentoarquivo() {
		
	}

	public Integer getIdtreinamentoarquivo() {
		return idtreinamentoarquivo;
	}

	public String getNome() {
		return nome;
	}

	public Date getDatainclusao() {
		return datainclusao;
	}

	public Date getDataexclusao() {
		return dataexclusao;
	}

	public boolean isExcluido() {
		return excluido;
	}

	public Treinamento getTreinamento() {
		return treinamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idtreinamentoarquivo == null) ? 0 : idtreinamentoarquivo.hashCode());
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
		Treinamentoarquivo other = (Treinamentoarquivo) obj;
		if (idtreinamentoarquivo == null) {
			if (other.idtreinamentoarquivo != null)
				return false;
		} else if (!idtreinamentoarquivo.equals(other.idtreinamentoarquivo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Treinamentoarquivo [idtreinamentoarquivo=" + idtreinamentoarquivo + "]";
	}
	
	
	

}
