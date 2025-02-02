package br.com.lareira.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "LAREIRA")
public class Lareira implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlareira")
    private Long idLareira;
	
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    
    @Size(max = 100)
    @Column(name = "endereco")
    private String endereco;
    
    @Size(max = 45)
    @Column(name = "bairro")
    private String bairro;
    
    @Size(max = 45)
    @Column(name = "CEP")
    private String cep;
    
    @Size(max = 45)
    @Column(name = "cidade")
    private String cidade;
    
    @Size(max = 2)
    @Column(name = "estado")
    private String estado;
    
    @Size(max = 45)
    @Column(name = "telefone")
    private String telefone;

	public Long getIdLareira() {
		return idLareira;
	}

	public void setIdLareira(Long idLareira) {
		this.idLareira = idLareira;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLareira == null) ? 0 : idLareira.hashCode());
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
		Lareira other = (Lareira) obj;
		if (idLareira == null) {
			if (other.idLareira != null)
				return false;
		} else if (!idLareira.equals(other.idLareira))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lareira [idLareira=" + idLareira + ", nome=" + nome + ", endereco=" + endereco + ", bairro=" + bairro
				+ ", cep=" + cep + ", cidade=" + cidade + ", estado=" + estado + ", telefone=" + telefone + "]";
	}
	
}
