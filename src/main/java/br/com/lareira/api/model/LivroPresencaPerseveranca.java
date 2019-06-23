package br.com.lareira.api.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "LIVRO_PRESENCA_PERSEVERANCA")
public class LivroPresencaPerseveranca implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpresenca")
	private Long idPresenca;

	@NotNull
	@JoinColumn(name = "idgp", insertable = false, updatable = false, nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private GrupoPerseveranca grupoPerseveranca;

	@NotNull
	@JoinColumn(name = "idcasalanfitriao", insertable = false, updatable = false, nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Casal casal;

	@NotNull
	private LocalDate data;

	@NotNull
	private LocalTime hora;

	public Long getIdPresenca() {
		return idPresenca;
	}

	public void setIdPresenca(Long idPresenca) {
		this.idPresenca = idPresenca;
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPresenca == null) ? 0 : idPresenca.hashCode());
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
		if (idPresenca == null) {
			if (other.idPresenca != null)
				return false;
		} else if (!idPresenca.equals(other.idPresenca))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LivroPresencaPerseveranca [idPresenca=" + idPresenca + ", grupoPerseveranca=" + grupoPerseveranca
				+ ", casal=" + casal + ", data=" + data + ", hora=" + hora + "]";
	}

}
