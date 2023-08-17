package rva.model;

import java.io.Serializable;
import java.util.Date;


//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;


//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Pacijent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PACIJENT_ID_GENERATOR", sequenceName = "PACIJENT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PACIJENT_ID_GENERATOR")
	private long id;

	private String ime;
	private String prezime;
	private boolean zdr_osiguranje;
	
	@Column(name = "datum_rodjenja")
	private Date datumRodjenja;

	
	@ManyToOne
	@JoinColumn(name = "odeljenje")
	//@OnDelete(action = OnDeleteAction.CASCADE)
	private Odeljenje odeljenje;

	
	@ManyToOne
	@JoinColumn(name = "dijagnoza")
	//@OnDelete(action = OnDeleteAction.CASCADE)
	private Dijagnoza dijagnoza;

	public Pacijent() {

	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public boolean isZdr_osiguranje() {
		return zdr_osiguranje;
	}

	public void setZdr_osiguranje(boolean zdr_osiguranje) {
		this.zdr_osiguranje = zdr_osiguranje;
	}

	public Date getDatum_rodjenja() {
		return datumRodjenja;
	}

	public void setDatum_rodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Odeljenje getOdeljenje() {
		return odeljenje;
	}

	public void setOdeljenje(Odeljenje odeljenje) {
		this.odeljenje = odeljenje;
	}

	public Dijagnoza getDijagnoza() {
		return dijagnoza;
	}

	public void setDijagnoza(Dijagnoza dijagnoza) {
		this.dijagnoza = dijagnoza;
	}

}
