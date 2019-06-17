package br.com.lareira.api.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRO_PRESENCA_PERSEVERANCA")
public class LivroPresencaPerseveranca implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	protected LivroPresencaPerseverancaPK livroPresencaPerseverancaPK;

	@JoinColumns({ @JoinColumn(name = "idcasalanfitriao", referencedColumnName = "idcasal"),
			@JoinColumn(name = "idlareira", referencedColumnName = "idlareira", insertable = false, updatable = false) })
	@ManyToOne(optional = false)
	private Casal casal;

	@JoinColumns({
			@JoinColumn(name = "idlareira", referencedColumnName = "idlareira", insertable = false, updatable = false),
			@JoinColumn(name = "idgp", referencedColumnName = "idgp", insertable = false, updatable = false) })
	@ManyToOne(optional = false)
	private GrupoPerseveranca grupoPerseveranca;

	public LivroPresencaPerseverancaPK getLivroPresencaPerseverancaPK() {
		return livroPresencaPerseverancaPK;
	}

	public void setLivroPresencaPerseverancaPK(LivroPresencaPerseverancaPK livroPresencaPerseverancaPK) {
		this.livroPresencaPerseverancaPK = livroPresencaPerseverancaPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((livroPresencaPerseverancaPK == null) ? 0 : livroPresencaPerseverancaPK.hashCode());
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
		LivroPresencaPerseveranca other = (LivroPresencaPerseveranca) obj;
		if (livroPresencaPerseverancaPK == null) {
			if (other.livroPresencaPerseverancaPK != null)
				return false;
		} else if (!livroPresencaPerseverancaPK.equals(other.livroPresencaPerseverancaPK))
			return false;
		return true;
	}

}
