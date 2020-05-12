/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecsegapi.model;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "funcionario")
public class Funcionario  {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfuncionario")
    private Integer idfuncionario;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Column(name = "dataadmissao")
    @Temporal(TemporalType.DATE)
    private Date dataadmissao;
    @Column(name = "dataexame")
    @Temporal(TemporalType.DATE)
    private Date dataexame;
    @Size(max = 15)
    @Column(name = "situacao")
    private String situacao;
    @JoinColumn(name = "funcao_idfuncao", referencedColumnName = "idfuncao")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Funcao funcao;
    @JoinColumn(name = "loja_idloja", referencedColumnName = "idloja")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Loja loja;
    @Size(max = 14)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 30)
    @Column(name = "rg")
    private String rg;
    @Size(max = 2)
    @Column(name = "uf")
    private String uf;
    @Column(name = "datanascimento")
    @Temporal(TemporalType.DATE)
    private Date datanascimento;
    @Size(max = 14)
    @Column(name = "pis")
    private String pis;
    @Size(max = 40)
    @Column(name = "ctps")
    private String ctps;
    @Column(name = "serie")
    private String serie;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "matricula")
    private int matricula;
	@JoinColumn(name = "setor_idsetor", referencedColumnName = "idsetor")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Setor setor;
	@Column(name = "datasituacao")
    @Temporal(TemporalType.DATE)
    private Date datasituacao;
	@Column(name = "dataexp1")
    @Temporal(TemporalType.DATE)
    private Date dataexp1;
	@Column(name = "dataexp2")
    @Temporal(TemporalType.DATE)
    private Date dataexp2;
	@Column(name = "diasexp1")
    private int diasexp1;
	@Column(name = "diasexp2")
    private int diasexp2;
	@Column(name = "pcd")
    private boolean pcd;
	@Column(name = "tipopcd")
    private String tipopcd;
	@Column(name = "fone")
    private String fone;
	@Column(name = "nacionalidade")
    private String nacionalidade;
	@Transient
	private boolean participa;
	
    
    
    public Funcionario() {
    	setParticipa(false);
    }

    public boolean isParticipa() {
		return participa;
	}

	public void setParticipa(boolean participa) {
		this.participa = participa;
	}

	public Funcionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Integer getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataadmissao() {
        return dataadmissao;
    }

    public void setDataadmissao(Date dataadmissao) {
        this.dataadmissao = dataadmissao;
    }

    public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}


	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Date getDataexame() {
		return dataexame;
	}

	public void setDataexame(Date dataexame) {
		this.dataexame = dataexame;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	

	public Date getDatasituacao() {
		return datasituacao;
	}

	public void setDatasituacao(Date datasituacao) {
		this.datasituacao = datasituacao;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Date getDataexp1() {
		return dataexp1;
	}

	public void setDataexp1(Date dataexp1) {
		this.dataexp1 = dataexp1;
	}

	public Date getDataexp2() {
		return dataexp2;
	}

	public void setDataexp2(Date dataexp2) {
		this.dataexp2 = dataexp2;
	}

	public int getDiasexp1() {
		return diasexp1;
	}

	public void setDiasexp1(int diasexp1) {
		this.diasexp1 = diasexp1;
	}

	public int getDiasexp2() {
		return diasexp2;
	}

	public void setDiasexp2(int diasexp2) {
		this.diasexp2 = diasexp2;
	}

	

	public boolean isPcd() {
		return pcd;
	}

	public void setPcd(boolean pcd) {
		this.pcd = pcd;
	}

	public String getTipopcd() {
		return tipopcd;
	}

	public void setTipopcd(String tipopcd) {
		this.tipopcd = tipopcd;
	}

	

	

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idfuncionario != null ? idfuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idfuncionario == null && other.idfuncionario != null) || (this.idfuncionario != null && !this.idfuncionario.equals(other.idfuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tecseg.model.Funcionario[ idfuncionario=" + idfuncionario + " ]";
    }
    
}
