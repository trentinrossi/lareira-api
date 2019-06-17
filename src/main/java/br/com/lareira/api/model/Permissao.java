package br.com.lareira.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PERMISSAO")
public class Permissao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	protected PermissaoPK permissaoPK;

	@Column(name = "caninsert")
	private Boolean canInsert;

	@Column(name = "canupdate")
	private Boolean canUpdate;

	@Column(name = "candelete")
	private Boolean canDelete;

	@Column(name = "canview")
	private Boolean canView;

	@JoinColumn(name = "idgrupo", referencedColumnName = "idgrupo", insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Grupo grupo;

	@JoinColumn(name = "identidade", referencedColumnName = "identidade", insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Entidade entidade;

	public PermissaoPK getPermissaoPK() {
		return permissaoPK;
	}

	public void setPermissaoPK(PermissaoPK permissaoPK) {
		this.permissaoPK = permissaoPK;
	}

	public Boolean getCanInsert() {
		return canInsert;
	}

	public void setCanInsert(Boolean canInsert) {
		this.canInsert = canInsert;
	}

	public Boolean getCanUpdate() {
		return canUpdate;
	}

	public void setCanUpdate(Boolean canUpdate) {
		this.canUpdate = canUpdate;
	}

	public Boolean getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(Boolean canDelete) {
		this.canDelete = canDelete;
	}

	public Boolean getCanView() {
		return canView;
	}

	public void setCanView(Boolean canView) {
		this.canView = canView;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((permissaoPK == null) ? 0 : permissaoPK.hashCode());
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
		Permissao other = (Permissao) obj;
		if (permissaoPK == null) {
			if (other.permissaoPK != null)
				return false;
		} else if (!permissaoPK.equals(other.permissaoPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Permissao [permissaoPK=" + permissaoPK + ", canInsert=" + canInsert + ", canUpdate=" + canUpdate
				+ ", canDelete=" + canDelete + ", canView=" + canView + ", grupo=" + grupo.getNome() + ", entidade=" + entidade.getNomeTabelaBanco()
				+ "]";
	}
}
