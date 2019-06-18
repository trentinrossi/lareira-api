package br.com.lareira.api.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CASAL")
public class Casal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "casal")
    private List<GrupoPerseverancaCasais> grupoPerseverancaCasaisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "casal")
    private List<LivroPresencaPerseveranca> livroPresencaPerseverancaList;

    @EmbeddedId
    protected CasalPK casalPK;
    
    @Size(max = 45)
	@Column(name = "maridonome")
    private String maridoNome;
    
    @Size(max = 45)
    @Column(name = "maridosobrenome")
    private String maridoSobrenome;
    
    @Column(name = "maridodatanascimento")
    private LocalDate maridoDataNascimento;
    
    @Size(max = 45)
    @Column(name = "maridoprofissao")
    private String maridoProfissao;
    
    @Size(max = 45)
    @Column(name = "maridotelcelular")
    private String maridoTelCelular;
    
    @Size(max = 70)
    @Column(name = "maridoemail")
    private String maridoEmail;
    
    @Size(max = 80)
    @Column(name = "maridoproblemasaude")
    private String maridoProblemaSaude;
    
    @Size(max = 45)
    @Column(name = "esposanome")
    private String esposaNome;
    
    @Size(max = 45)
    @Column(name = "esposasobrenome")
    private String esposaSobrenome;
    
    @Column(name = "esposadatanascimento")
    private LocalDate esposaDataNascimento;
    
    @Size(max = 45)
    @Column(name = "esposaprofissao")
    private String esposaProfissao;
    
    @Size(max = 45)
    @Column(name = "esposatelcelular")
    private String esposaTelCelular;
    
    @Size(max = 70)
    @Column(name = "esposaemail")
    private String esposaEmail;
    
    @Size(max = 80)
    @Column(name = "esposaproblemasaude")
    private String esposaProblemaSaude;
    
    @JoinColumn(name = "idlareira", referencedColumnName = "idlareira", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Lareira lareira;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "casal", fetch = FetchType.EAGER)
    private List<Filho> filhoList;

	public List<GrupoPerseverancaCasais> getGrupoPerseverancaCasaisList() {
		return grupoPerseverancaCasaisList;
	}

	public void setGrupoPerseverancaCasaisList(List<GrupoPerseverancaCasais> grupoPerseverancaCasaisList) {
		this.grupoPerseverancaCasaisList = grupoPerseverancaCasaisList;
	}

	public List<LivroPresencaPerseveranca> getLivroPresencaPerseverancaList() {
		return livroPresencaPerseverancaList;
	}

	public void setLivroPresencaPerseverancaList(List<LivroPresencaPerseveranca> livroPresencaPerseverancaList) {
		this.livroPresencaPerseverancaList = livroPresencaPerseverancaList;
	}

	public CasalPK getCasalPK() {
		return casalPK;
	}

	public void setCasalPK(CasalPK casalPK) {
		this.casalPK = casalPK;
	}

	public String getMaridoNome() {
		return maridoNome;
	}

	public void setMaridoNome(String maridoNome) {
		this.maridoNome = maridoNome;
	}

	public String getMaridoSobrenome() {
		return maridoSobrenome;
	}

	public void setMaridoSobrenome(String maridoSobrenome) {
		this.maridoSobrenome = maridoSobrenome;
	}

	public LocalDate getMaridoDataNascimento() {
		return maridoDataNascimento;
	}

	public void setMaridoDataNascimento(LocalDate maridoDataNascimento) {
		this.maridoDataNascimento = maridoDataNascimento;
	}

	public String getMaridoProfissao() {
		return maridoProfissao;
	}

	public void setMaridoProfissao(String maridoProfissao) {
		this.maridoProfissao = maridoProfissao;
	}

	public String getMaridoTelCelular() {
		return maridoTelCelular;
	}

	public void setMaridoTelCelular(String maridoTelCelular) {
		this.maridoTelCelular = maridoTelCelular;
	}

	public String getMaridoEmail() {
		return maridoEmail;
	}

	public void setMaridoEmail(String maridoEmail) {
		this.maridoEmail = maridoEmail;
	}

	public String getMaridoProblemaSaude() {
		return maridoProblemaSaude;
	}

	public void setMaridoProblemaSaude(String maridoProblemaSaude) {
		this.maridoProblemaSaude = maridoProblemaSaude;
	}

	public String getEsposaNome() {
		return esposaNome;
	}

	public void setEsposaNome(String esposaNome) {
		this.esposaNome = esposaNome;
	}

	public String getEsposaSobrenome() {
		return esposaSobrenome;
	}

	public void setEsposaSobrenome(String esposaSobrenome) {
		this.esposaSobrenome = esposaSobrenome;
	}

	public LocalDate getEsposaDataNascimento() {
		return esposaDataNascimento;
	}

	public void setEsposaDataNascimento(LocalDate esposaDataNascimento) {
		this.esposaDataNascimento = esposaDataNascimento;
	}

	public String getEsposaProfissao() {
		return esposaProfissao;
	}

	public void setEsposaProfissao(String esposaProfissao) {
		this.esposaProfissao = esposaProfissao;
	}

	public String getEsposaTelCelular() {
		return esposaTelCelular;
	}

	public void setEsposaTelCelular(String esposaTelCelular) {
		this.esposaTelCelular = esposaTelCelular;
	}

	public String getEsposaEmail() {
		return esposaEmail;
	}

	public void setEsposaEmail(String esposaEmail) {
		this.esposaEmail = esposaEmail;
	}

	public String getEsposaProblemaSaude() {
		return esposaProblemaSaude;
	}

	public void setEsposaProblemaSaude(String esposaProblemaSaude) {
		this.esposaProblemaSaude = esposaProblemaSaude;
	}

	public Lareira getLareira() {
		return lareira;
	}

	public void setLareira(Lareira lareira) {
		this.lareira = lareira;
	}

	public List<Filho> getFilhoList() {
		return filhoList;
	}

	public void setFilhoList(List<Filho> filhoList) {
		this.filhoList = filhoList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((casalPK == null) ? 0 : casalPK.hashCode());
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
		Casal other = (Casal) obj;
		if (casalPK == null) {
			if (other.casalPK != null)
				return false;
		} else if (!casalPK.equals(other.casalPK))
			return false;
		return true;
	}       
}
