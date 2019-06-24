package br.com.lareira.api.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "FILHO")
public class Filho implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfilho")
    private Long idFilho;

	@JoinColumn(name = "idcasal")
	@ManyToOne
	private Casal casal;
	
	@NotEmpty
	@Size(max = 45)
	@Column(name = "nome")
	private String nome;

	@Size(max = 2)
	@Column(name = "sexo")
	private String sexo;

	@Column(name = "datanascimento")
	private LocalDate dataNascimento;

	public Long getIdFilho() {
		return idFilho;
	}

	public void setIdFilho(Long idFilho) {
		this.idFilho = idFilho;
	}

	public Casal getCasal() {
		return casal;
	}

	public void setCasal(Casal casal) {
		this.casal = casal;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFilho == null) ? 0 : idFilho.hashCode());
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
		if (idFilho == null) {
			if (other.idFilho != null)
				return false;
		} else if (!idFilho.equals(other.idFilho))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Filho [idFilho=" + idFilho + ", casal=" + casal + ", nome=" + nome + ", sexo=" + sexo
				+ ", dataNascimento=" + dataNascimento + "]";
	}
}
