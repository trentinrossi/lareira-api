package br.com.lareira.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ENTIDADE")
public class Entidade implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "identidade")
	private Integer idEntidade;

	@Size(max = 45)
	@Column(name = "nome")
	private String nome;
	
	@Size(max = 45)
	@Column(name = "nometabelabanco")
	private String nomeTabelaBanco;
	
	@Size(max = 100)
	@Column(name = "descricao")
	private String descricao;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "entidade", fetch = FetchType.EAGER)
	private List<Permissao> permissaoList;

	public Integer getIdEntidade() {
		return idEntidade;
	}

	public void setIdEntidade(Integer idEntidade) {
		this.idEntidade = idEntidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeTabelaBanco() {
		return nomeTabelaBanco;
	}

	public void setNomeTabelaBanco(String nomeTabelaBanco) {
		this.nomeTabelaBanco = nomeTabelaBanco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Permissao> getPermissaoList() {
		return permissaoList;
	}

	public void setPermissaoList(List<Permissao> permissaoList) {
		this.permissaoList = permissaoList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEntidade == null) ? 0 : idEntidade.hashCode());
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
		Entidade other = (Entidade) obj;
		if (idEntidade == null) {
			if (other.idEntidade != null)
				return false;
		} else if (!idEntidade.equals(other.idEntidade))
			return false;
		return true;
	}
}
