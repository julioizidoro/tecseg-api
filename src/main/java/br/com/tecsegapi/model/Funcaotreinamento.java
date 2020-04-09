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
import javax.persistence.Table;

@Entity
@Table(name = "funcaotreinamento")
public class Funcaotreinamento implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfuncaotreinamento")
    private Integer idfuncaotreinamento;
    @JoinColumn(name = "funcao_idfuncao", referencedColumnName = "idfuncao")
    @ManyToOne(optional = false)
    private Funcao funcao;
    @JoinColumn(name = "treinamentoparticipante_idtreinamentoparticipante", referencedColumnName = "idtreinamentoparticipante")
    @ManyToOne(optional = false)
    private Treinamentoparticipante treinamentoparticipante;

    public Funcaotreinamento() {
    }

    public Funcaotreinamento(Integer idfuncaotreinamento) {
        this.idfuncaotreinamento = idfuncaotreinamento;
    }

    public Integer getIdfuncaotreinamento() {
        return idfuncaotreinamento;
    }

    public void setIdfuncaotreinamento(Integer idfuncaotreinamento) {
        this.idfuncaotreinamento = idfuncaotreinamento;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public Treinamentoparticipante getTreinamentoparticipante() {
        return treinamentoparticipante;
    }

    public void setTreinamentoparticipante(Treinamentoparticipante treinamentoparticipante) {
        this.treinamentoparticipante = treinamentoparticipante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfuncaotreinamento != null ? idfuncaotreinamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcaotreinamento)) {
            return false;
        }
        Funcaotreinamento other = (Funcaotreinamento) object;
        if ((this.idfuncaotreinamento == null && other.idfuncaotreinamento != null) || (this.idfuncaotreinamento != null && !this.idfuncaotreinamento.equals(other.idfuncaotreinamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Funcaotreinamento[ idfuncaotreinamento=" + idfuncaotreinamento + " ]";
    }
    
}

