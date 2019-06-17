package br.com.lareira.api.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class GrupoPerseverancaPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@NotNull
	@Column(name = "idlareira")
	private int idLareira;

	@Basic(optional = false)
	@NotNull
	@Column(name = "idgp")
	private int idGP;

	public int getIdLareira() {
		return idLareira;
	}

	public void setIdLareira(int idLareira) {
		this.idLareira = idLareira;
	}

	public int getIdGP() {
		return idGP;
	}

	public void setIdGP(int idGP) {
		this.idGP = idGP;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idGP;
		result = prime * result + idLareira;
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
		GrupoPerseverancaPK other = (GrupoPerseverancaPK) obj;
		if (idGP != other.idGP)
			return false;
		if (idLareira != other.idLareira)
			return false;
		return true;
	}

}
