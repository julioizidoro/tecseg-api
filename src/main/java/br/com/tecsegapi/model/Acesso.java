package br.com.tecsegapi.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acesso")
public class Acesso implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idacesso")
    private Integer idaacesso;
	@Column(name = "nome")
    private String nome;
	@Column(name = "clientes")
    private Boolean clientes;
	@Column(name = "funcionarios")
    private Boolean funcionarios;
	@Column(name = "funcao")
    private Boolean funcao;
	@Column(name = "loja")
    private Boolean loja;
	@Column(name = "treinamento")
    private Boolean treinamento;
	@Column(name = "tipoexame")
    private Boolean tipoexame;
	@Column(name = "acesso")
    private Boolean acesso;
	@Column(name = "usuario")
    private Boolean usuairo;
	@Column(name = "agendamento")
    private Boolean agendamento;
	@Column(name = "controle")
    private Boolean controle;
	@Column(name = "relatorios")
    private Boolean relatorios;
	@Column(name = "afastamento")
    private Boolean afastamento;
	@Column(name = "salutar")
    private Boolean salutar;
	@Column(name = "turma")
    private Boolean turma;
	@Column(name = "produto")
    private Boolean produto;
	@Column(name = "produtogrupo")
    private Boolean produtogrupo;
	@Column(name = "epitipo")
    private Boolean epitipo;
	@Column(name = "fornecedor")
    private Boolean fornecedor;
	@Column(name = "epicompras")
    private Boolean epicompras;
	@Column(name = "epicontrole")
    private Boolean epicontorle;
	@Column(name = "uniformes")
    private Boolean uniformes;
	@Column(name = "epi")
    private Boolean epi;
	@Column(name = "epibaixa")
    private boolean epibaixa;
	@Column(name = "contas")
    private boolean contas;
	@Column(name = "contausuario")
    private boolean contausuario;
	
	
	public Acesso() {
		
	}

	public Integer getIdaacesso() {
		return idaacesso;
	}

	public void setIdaacesso(Integer idaacesso) {
		this.idaacesso = idaacesso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	public Boolean getClientes() {
		return clientes;
	}

	public void setClientes(Boolean clientes) {
		this.clientes = clientes;
	}

	public Boolean getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Boolean funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Boolean getFuncao() {
		return funcao;
	}

	public void setFuncao(Boolean funcao) {
		this.funcao = funcao;
	}

	public Boolean getLoja() {
		return loja;
	}

	public void setLoja(Boolean loja) {
		this.loja = loja;
	}

	public Boolean getTreinamento() {
		return treinamento;
	}

	public void setTreinamento(Boolean treinamento) {
		this.treinamento = treinamento;
	}

	public Boolean getTipoexame() {
		return tipoexame;
	}

	public void setTipoexame(Boolean tipoexame) {
		this.tipoexame = tipoexame;
	}

	public Boolean getAcesso() {
		return acesso;
	}

	public void setAcesso(Boolean acesso) {
		this.acesso = acesso;
	}

	public Boolean getUsuairo() {
		return usuairo;
	}

	public void setUsuairo(Boolean usuairo) {
		this.usuairo = usuairo;
	}

	public Boolean getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Boolean agendamento) {
		this.agendamento = agendamento;
	}

	public Boolean getControle() {
		return controle;
	}

	public void setControle(Boolean controle) {
		this.controle = controle;
	}

	public Boolean getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(Boolean relatorios) {
		this.relatorios = relatorios;
	}

	public Boolean getAfastamento() {
		return afastamento;
	}

	public void setAfastamento(Boolean afastamento) {
		this.afastamento = afastamento;
	}

	public Boolean getSalutar() {
		return salutar;
	}

	public void setSalutar(Boolean salutar) {
		this.salutar = salutar;
	}

	public Boolean getTurma() {
		return turma;
	}

	public void setTurma(Boolean turma) {
		this.turma = turma;
	}

	public Boolean getProduto() {
		return produto;
	}

	public void setProduto(Boolean produto) {
		this.produto = produto;
	}

	public Boolean getProdutogrupo() {
		return produtogrupo;
	}

	public void setProdutogrupo(Boolean produtogrupo) {
		this.produtogrupo = produtogrupo;
	}

	public Boolean getEpitipo() {
		return epitipo;
	}

	public void setEpitipo(Boolean epitipo) {
		this.epitipo = epitipo;
	}

	public Boolean getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Boolean fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Boolean getEpicompras() {
		return epicompras;
	}

	public void setEpicompras(Boolean epicompras) {
		this.epicompras = epicompras;
	}

	public Boolean getEpicontorle() {
		return epicontorle;
	}

	public void setEpicontorle(Boolean epicontorle) {
		this.epicontorle = epicontorle;
	}

	public Boolean getUniformes() {
		return uniformes;
	}

	public void setUniformes(Boolean uniformes) {
		this.uniformes = uniformes;
	}

	public Boolean getEpi() {
		return epi;
	}

	public void setEpi(Boolean epi) {
		this.epi = epi;
	}

	public boolean isEpibaixa() {
		return epibaixa;
	}

	public void setEpibaixa(boolean epibaixa) {
		this.epibaixa = epibaixa;
	}

	

	public boolean isContas() {
		return contas;
	}

	public void setContas(boolean contas) {
		this.contas = contas;
	}

	public boolean isContausuario() {
		return contausuario;
	}

	public void setContausuario(boolean contausuario) {
		this.contausuario = contausuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idaacesso == null) ? 0 : idaacesso.hashCode());
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
		Acesso other = (Acesso) obj;
		if (idaacesso == null) {
			if (other.idaacesso != null)
				return false;
		} else if (!idaacesso.equals(other.idaacesso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Acesso [idaacesso=" + idaacesso + "]";
	}
}
