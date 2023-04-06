package rva.model;

import java.io.Serializable;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Odeljenje implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "ODELJENJE_ID_GENERATOR", sequenceName = "ODELJENJE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ODELJENJE_ID_GENERATOR")
	private long id;
	
	private String naziv;
	private String lokacija;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "bolnica")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Bolnica bolnica;
	
	@JsonIgnore
	@OneToMany(mappedBy = "odeljenje")
	private List<Pacijent> pacijent;
	
	
	public Odeljenje() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getLokacija() {
		return lokacija;
	}

	public void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}

	public Bolnica getBolnica() {
		return bolnica;
	}

	public void setBolnica(Bolnica bolnica) {
		this.bolnica = bolnica;
	}
	
	public List<Pacijent> getPacijent() {
		return pacijent;
	}

	public void setPacijent(List<Pacijent> pacijent) {
		this.pacijent = pacijent;
	}

}
