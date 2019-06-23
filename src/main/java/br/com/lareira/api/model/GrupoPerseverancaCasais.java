package br.com.lareira.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "GRUPO_PERSEVERANCA_CASAIS")
public class GrupoPerseverancaCasais implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idgpcasal")
	private Long idGpCasal;

	@NotNull
	@JoinColumn(name = "idgp", insertable = false, updatable = false, nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private GrupoPerseveranca grupoPerseveranca;

	@NotNull
	@JoinColumn(name = "idcasal", insertable = false, updatable = false, nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Casal casal;

	@NotNull
	@JoinColumn(name = "idgpfuncao", insertable = false, updatable = false, nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private GrupoPerseverancaFuncao grupoPerseverancaFuncao;

	public Long getIdGpCasal() {
		return idGpCasal;
	}

	public void setIdGpCasal(Long idGpCasal) {
		this.idGpCasal = idGpCasal;
	}

	public GrupoPerseveranca getGrupoPerseveranca() {
		return grupoPerseveranca;
	}

	public void setGrupoPerseveranca(GrupoPerseveranca grupoPerseveranca) {
		this.grupoPerseveranca = grupoPerseveranca;
	}

	public Casal getCasal() {
		return casal;
	}

	public void setCasal(Casal casal) {
		this.casal = casal;
	}

	public GrupoPerseverancaFuncao getGrupoPerseverancaFuncao() {
		return grupoPerseverancaFuncao;
	}

	public void setGrupoPerseverancaFuncao(GrupoPerseverancaFuncao grupoPerseverancaFuncao) {
		this.grupoPerseverancaFuncao = grupoPerseverancaFuncao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGpCasal == null) ? 0 : idGpCasal.hashCode());
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
		GrupoPerseverancaCasais other = (GrupoPerseverancaCasais) obj;
		if (idGpCasal == null) {
			if (other.idGpCasal != null)
				return false;
		} else if (!idGpCasal.equals(other.idGpCasal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GrupoPerseverancaCasais [idGpCasal=" + idGpCasal + ", grupoPerseveranca=" + grupoPerseveranca
				+ ", casal=" + casal + ", grupoPerseverancaFuncao=" + grupoPerseverancaFuncao + "]";
	}

}
