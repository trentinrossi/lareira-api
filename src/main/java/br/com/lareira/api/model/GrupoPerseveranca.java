package br.com.lareira.api.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "GRUPO_PERSEVERANCA")
public class GrupoPerseveranca implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idgp")
	private Long idGp;

	@NotNull
	@JoinColumn(name = "idlareira", insertable = false, updatable = false, nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Lareira lareira;

	@Size(max = 45)
	@Column(name = "nome")
	private String nome;

	@Column(name = "datainicio")
	private LocalDate dataInicio;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoPerseveranca")
	private List<GrupoPerseverancaCasais> grupoPerseverancaCasaisList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoPerseveranca")
	private List<LivroPresencaPerseveranca> livroPresencaPerseverancaList;

	public Long getIdGp() {
		return idGp;
	}

	public void setIdGp(Long idGp) {
		this.idGp = idGp;
	}

	public Lareira getLareira() {
		return lareira;
	}

	public void setLareira(Lareira lareira) {
		this.lareira = lareira;
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
		result = prime * result + ((idGp == null) ? 0 : idGp.hashCode());
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
		if (idGp == null) {
			if (other.idGp != null)
				return false;
		} else if (!idGp.equals(other.idGp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GrupoPerseveranca [idGp=" + idGp + ", lareira=" + lareira + ", nome=" + nome + ", dataInicio="
				+ dataInicio + ", grupoPerseverancaCasaisList=" + grupoPerseverancaCasaisList
				+ ", livroPresencaPerseverancaList=" + livroPresencaPerseverancaList + "]";
	}

}
