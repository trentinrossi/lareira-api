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
@Table(name = "PERMISSAO")
public class Permissao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpermissao")
    private Long idPermissao;

	@NotNull
	@Column(name = "idgrupo")
	private Long idGrupo;

	@NotNull
	@Column(name = "identidade")
	private Long idEntidade;

	@JoinColumn(name = "idgrupo", referencedColumnName = "idgrupo", insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Grupo grupo;

	@JoinColumn(name = "identidade", referencedColumnName = "identidade", insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Entidade entidade;

	@NotNull
	@Column(name = "caninsert")
	private Boolean canInsert;

	@NotNull
	@Column(name = "canupdate")
	private Boolean canUpdate;

	@NotNull
	@Column(name = "candelete")
	private Boolean canDelete;

	@NotNull
	@Column(name = "canview")
	private Boolean canView;

	public Long getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}

	public Long getIdEntidade() {
		return idEntidade;
	}

	public void setIdEntidade(Long idEntidade) {
		this.idEntidade = idEntidade;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEntidade == null) ? 0 : idEntidade.hashCode());
		result = prime * result + ((idGrupo == null) ? 0 : idGrupo.hashCode());
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
		if (idEntidade == null) {
			if (other.idEntidade != null)
				return false;
		} else if (!idEntidade.equals(other.idEntidade))
			return false;
		if (idGrupo == null) {
			if (other.idGrupo != null)
				return false;
		} else if (!idGrupo.equals(other.idGrupo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Permissao [idGrupo=" + idGrupo + ", idEntidade=" + idEntidade + ", grupo=" + grupo + ", entidade="
				+ entidade + ", canInsert=" + canInsert + ", canUpdate=" + canUpdate + ", canDelete=" + canDelete
				+ ", canView=" + canView + "]";
	}

}
