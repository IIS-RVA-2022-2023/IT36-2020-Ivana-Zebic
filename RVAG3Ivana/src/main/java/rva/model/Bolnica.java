package rva.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Bolnica implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "BOLNICA_ID_GENERATOR", sequenceName = "BOLNICA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOLNICA_ID_GENERATOR")
	private long id;
	
	private String naziv;
	private String adresa;
	private double budzet;
	
	//@OneToMany(mappedBy = "bolnica")
	@JsonIgnore
	@OneToMany(mappedBy = "bolnica", cascade = CascadeType.REMOVE)
	private List<Odeljenje> odeljenje;
	
	
	public Bolnica() {
		
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
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public double getBudzet() {
		return budzet;
	}
	public void setBudzet(double budzet) {
		this.budzet = budzet;
	}
	
	public List<Odeljenje> getOdeljenje() {
		return odeljenje;
	}

	public void setOdeljenje(List<Odeljenje> odeljenje) {
		this.odeljenje = odeljenje;
	}

}
