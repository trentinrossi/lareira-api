package br.com.lareira.api.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class LivroPresencaPerseverancaPK implements Serializable {

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

	@Basic(optional = false)
	@NotNull
	@Column(name = "data")
	private LocalDate data;

	@Basic(optional = false)
	@NotNull
	@Column(name = "hora")
	private LocalDate hora;

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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalDate getHora() {
		return hora;
	}

	public void setHora(LocalDate hora) {
		this.hora = hora;
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
		LivroPresencaPerseverancaPK other = (LivroPresencaPerseverancaPK) obj;
		if (idGP != other.idGP)
			return false;
		if (idLareira != other.idLareira)
			return false;
		return true;
	}
}
