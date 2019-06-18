package br.com.lareira.api.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "GRUPO_PERSEVERANCA")
public class GrupoPerseveranca implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	protected GrupoPerseverancaPK grupoPerseverancaPK;

	@Size(max = 45)
	@Column(name = "nome")
	private String nome;

	@Column(name = "datainicio")
	private LocalDate dataInicio;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoPerseveranca")
	private List<GrupoPerseverancaCasais> grupoPerseverancaCasaisList;

	@JoinColumn(name = "idlareira", referencedColumnName = "idlareira", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Lareira lareira;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoPerseveranca")
	private List<LivroPresencaPerseveranca> livroPresencaPerseverancaList;

	public GrupoPerseverancaPK getGrupoPerseverancaPK() {
		return grupoPerseverancaPK;
	}

	public void setGrupoPerseverancaPK(GrupoPerseverancaPK grupoPerseverancaPK) {
		this.grupoPerseverancaPK = grupoPerseverancaPK;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public List<GrupoPerseverancaCasais> getGrupoPerseverancaCasaisList() {
		return grupoPerseverancaCasaisList;
	}

	public void setGrupoPerseverancaCasaisList(List<GrupoPerseverancaCasais> grupoPerseverancaCasaisList) {
		this.grupoPerseverancaCasaisList = grupoPerseverancaCasaisList;
	}

	public Lareira getLareira() {
		return lareira;
	}

	public void setLareira(Lareira lareira) {
		this.lareira = lareira;
	}

	public List<LivroPresencaPerseveranca> getLivroPresencaPerseverancaList() {
		return livroPresencaPerseverancaList;
	}

	public void setLivroPresencaPerseverancaList(List<LivroPresencaPerseveranca> livroPresencaPerseverancaList) {
		this.livroPresencaPerseverancaList = livroPresencaPerseverancaList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grupoPerseverancaPK == null) ? 0 : grupoPerseverancaPK.hashCode());
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
		GrupoPerseveranca other = (GrupoPerseveranca) obj;
		if (grupoPerseverancaPK == null) {
			if (other.grupoPerseverancaPK != null)
				return false;
		} else if (!grupoPerseverancaPK.equals(other.grupoPerseverancaPK))
			return false;
		return true;
	}

}
