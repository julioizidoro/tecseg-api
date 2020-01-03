package br.com.tecsegapi.model;

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
import javax.persistence.Transient;

@Entity
@Table(name = "treinamentoparticipante")
public class Treinamentoparticipante {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtreinamentoparticipante")
    private Integer idtreinamentoparticipante;
	@Column(name = "compareceu")
    private boolean compareceu;
	@Column(name = "nota")
    private Double nota;
	@JoinColumn(name = "funcionario_idfuncionario", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    private Funcionario funcionario;
	@JoinColumn(name = "treinamento_idtreinamento", referencedColumnName = "idtreinamento")
    @ManyToOne(optional = false)
    private Treinamento treinamento;
	@JoinColumn(name = "loja_idloja", referencedColumnName = "idloja")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Loja loja;
	
	public Treinamentoparticipante() {
		
	}

	public Integer getIdtreinamentoparticipante() {
		return idtreinamentoparticipante;
	}

	public void setIdtreinamentoparticipante(Integer idtreinamentoparticipante) {
		this.idtreinamentoparticipante = idtreinamentoparticipante;
	}

	public boolean isCompareceu() {
		return compareceu;
	}

	public void setCompareceu(boolean compareceu) {
		this.compareceu = compareceu;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Treinamento getTreinamento() {
		return treinamento;
	}

	public void setTreinamento(Treinamento treinamento) {
		this.treinamento = treinamento;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idtreinamentoparticipante == null) ? 0 : idtreinamentoparticipante.hashCode());
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
		Treinamentoparticipante other = (Treinamentoparticipante) obj;
		if (idtreinamentoparticipante == null) {
			if (other.idtreinamentoparticipante != null)
				return false;
		} else if (!idtreinamentoparticipante.equals(other.idtreinamentoparticipante))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Treinamentoparticipante [idtreinamentoparticipante=" + idtreinamentoparticipante + "]";
	}
	
	
	
	
	

}
