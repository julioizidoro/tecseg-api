/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecsegapi.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;



/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "loja")
public class Loja  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idloja")
    private Integer idloja;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Column(name = "razaosocial")
    private String razaosicual;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "codigosalutar")
    private int codigosalutar;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "numero")
    private String numero;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado")
    private String estado;
    @Column(name = "cep")
    private String cep;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "nomefantasia")
    private String nomefantasia;
    
    

    public Loja() {
    }

    public Loja(Integer idloja) {
        this.idloja = idloja;
    }

    public Integer getIdloja() {
        return idloja;
    }

    public void setIdloja(Integer idloja) {
        this.idloja = idloja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaosicual() {
		return razaosicual;
	}

	public void setRazaosicual(String razaosicual) {
		this.razaosicual = razaosicual;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getCodigosalutar() {
		return codigosalutar;
	}

	public void setCodigosalutar(int codigosalutar) {
		this.codigosalutar = codigosalutar;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNomefantasia() {
		return nomefantasia;
	}

	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
	}


	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idloja != null ? idloja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loja)) {
            return false;
        }
        Loja other = (Loja) object;
        if ((this.idloja == null && other.idloja != null) || (this.idloja != null && !this.idloja.equals(other.idloja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tecseg.model.Loja[ idloja=" + idloja + " ]";
    }
    
}
