package br.com.tecsegapi.model.exportar;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "campeche")
public class Campeche implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Matricula")
    private String matricula;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Pais")
    private String pais;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "Identidade")
    private String identidade;
    @Column(name = "CTPS")
    private String ctps;
    @Column(name = "Serie_CTPS")
    private String serieCTPS;
    @Column(name = "Celular")
    private String celular;
    @Column(name = "Nascimento")
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    @Column(name = "Sexo")
    private String sexo;
    @Column(name = "Admiss\u00e3o")
    @Temporal(TemporalType.DATE)
    private Date admissão;
    @Column(name = "PIS")
    private String pis;
    @Column(name = "Cargo")
    private String cargo;
    @Column(name = "CBO")
    private String cbo;
    @Column(name = "Setor")
    private String setor;

    public Campeche() {
    }

    public Campeche(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getSerieCTPS() {
        return serieCTPS;
    }

    public void setSerieCTPS(String serieCTPS) {
        this.serieCTPS = serieCTPS;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getAdmissão() {
        return admissão;
    }

    public void setAdmissão(Date admissão) {
        this.admissão = admissão;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCbo() {
        return cbo;
    }

    public void setCbo(String cbo) {
        this.cbo = cbo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campeche)) {
            return false;
        }
        Campeche other = (Campeche) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Campeche[ matricula=" + matricula + " ]";
    }
    
}
