package br.com.lareira.api.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GRUPO_PERSEVERANCA_CASAIS")
public class GrupoPerseverancaCasais implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	protected GrupoPerseverancaCasaisPK grupoPerseverancaCasaisPK;
	
	@JoinColumns({
			@JoinColumn(name = "idcasal", referencedColumnName = "idcasal", insertable = false, updatable = false),
			@JoinColumn(name = "idlareira", referencedColumnName = "idlareira", insertable = false, updatable = false) })
	@ManyToOne(optional = false)
	private Casal casal;
	
	@JoinColumns({
			@JoinColumn(name = "idlareira", referencedColumnName = "idlareira", insertable = false, updatable = false),
			@JoinColumn(name = "idgp", referencedColumnName = "idgp", insertable = false, updatable = false) })
	@ManyToOne(optional = false)	
	private GrupoPerseveranca grupoPerseveranca;
	
	@JoinColumn(name = "idgpfuncao", referencedColumnName = "idgpfuncao")
	@ManyToOne(optional = false)
	private GrupoPerseverancaFuncao idGPFuncao;

	public GrupoPerseverancaCasaisPK getGrupoPerseverancaCasaisPK() {
		return grupoPerseverancaCasaisPK;
	}

	public void setGrupoPerseverancaCasaisPK(GrupoPerseverancaCasaisPK grupoPerseverancaCasaisPK) {
		this.grupoPerseverancaCasaisPK = grupoPerseverancaCasaisPK;
	}

	public Casal getCasal() {
		return casal;
	}

	public void setCasal(Casal casal) {
		this.casal = casal;
	}

	public GrupoPerseveranca getGrupoPerseveranca() {
		return grupoPerseveranca;
	}

	public void setGrupoPerseveranca(GrupoPerseveranca grupoPerseveranca) {
		this.grupoPerseveranca = grupoPerseveranca;
	}

	public GrupoPerseverancaFuncao getIdGPFuncao() {
		return idGPFuncao;
	}

	public void setIdGPFuncao(GrupoPerseverancaFuncao idGPFuncao) {
		this.idGPFuncao = idGPFuncao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grupoPerseverancaCasaisPK == null) ? 0 : grupoPerseverancaCasaisPK.hashCode());
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
		if (grupoPerseverancaCasaisPK == null) {
			if (other.grupoPerseverancaCasaisPK != null)
				return false;
		} else if (!grupoPerseverancaCasaisPK.equals(other.grupoPerseverancaCasaisPK))
			return false;
		return true;
	}

}
