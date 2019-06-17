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
@Table(name = "GRUPO_PERSEVERANCA_FUNCAO")
public class GrupoPerseverancaFuncao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idgpfuncao")
	private Integer idGPFuncao;

	@Size(max = 50)
	@Column(name = "nome")
	private String nome;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idGPFuncao", fetch = FetchType.LAZY)
	private List<GrupoPerseverancaCasais> grupoPerseverancaCasaisList;

	public Integer getIdGPFuncao() {
		return idGPFuncao;
	}

	public void setIdGPFuncao(Integer idGPFuncao) {
		this.idGPFuncao = idGPFuncao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<GrupoPerseverancaCasais> getGrupoPerseverancaCasaisList() {
		return grupoPerseverancaCasaisList;
	}

	public void setGrupoPerseverancaCasaisList(List<GrupoPerseverancaCasais> grupoPerseverancaCasaisList) {
		this.grupoPerseverancaCasaisList = grupoPerseverancaCasaisList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGPFuncao == null) ? 0 : idGPFuncao.hashCode());
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
		GrupoPerseverancaFuncao other = (GrupoPerseverancaFuncao) obj;
		if (idGPFuncao == null) {
			if (other.idGPFuncao != null)
				return false;
		} else if (!idGPFuncao.equals(other.idGPFuncao))
			return false;
		return true;
	}

}
