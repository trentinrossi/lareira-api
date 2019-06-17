package br.com.lareira.api.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "FILHO")
public class Filho implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected FilhoPK filhoPK;

	@Size(max = 45)
	@Column(name = "nome")
	private String nome;

	@Size(max = 2)
	@Column(name = "sexo")
	private String sexo;

	@Column(name = "datanascimento")
	@Temporal(TemporalType.DATE)
	private LocalDate dataNascimento;

	@JoinColumns({
			@JoinColumn(name = "idcasal", referencedColumnName = "idcasal", insertable = false, updatable = false),
			@JoinColumn(name = "idlareira", referencedColumnName = "idlareira", insertable = false, updatable = false) })
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Casal casal;

	public FilhoPK getFilhoPK() {
		return filhoPK;
	}

	public void setFilhoPK(FilhoPK filhoPK) {
		this.filhoPK = filhoPK;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Casal getCasal() {
		return casal;
	}

	public void setCasal(Casal casal) {
		this.casal = casal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filhoPK == null) ? 0 : filhoPK.hashCode());
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
		Filho other = (Filho) obj;
		if (filhoPK == null) {
			if (other.filhoPK != null)
				return false;
		} else if (!filhoPK.equals(other.filhoPK))
			return false;
		return true;
	}
}
