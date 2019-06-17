package br.com.lareira.api.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class FilhoPK implements Serializable {

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
    @Column(name = "idcasal")
    private int idCasal;
    
    @Basic(optional = false)
    @Column(name = "Idfilho")
    private int idFilho;

	public int getIdLareira() {
		return idLareira;
	}

	public void setIdLareira(int idLareira) {
		this.idLareira = idLareira;
	}

	public int getIdCasal() {
		return idCasal;
	}

	public void setIdCasal(int idCasal) {
		this.idCasal = idCasal;
	}

	public int getIdFilho() {
		return idFilho;
	}

	public void setIdFilho(int idFilho) {
		this.idFilho = idFilho;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCasal;
		result = prime * result + idFilho;
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
		FilhoPK other = (FilhoPK) obj;
		if (idCasal != other.idCasal)
			return false;
		if (idFilho != other.idFilho)
			return false;
		if (idLareira != other.idLareira)
			return false;
		return true;
	}
}
