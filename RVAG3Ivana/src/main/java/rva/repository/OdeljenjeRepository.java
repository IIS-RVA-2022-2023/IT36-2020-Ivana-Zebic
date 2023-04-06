package rva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rva.model.Bolnica;
import rva.model.Odeljenje;

public interface OdeljenjeRepository extends JpaRepository<Odeljenje,Long> {
	
	public abstract List<Odeljenje> findByNazivContainingIgnoreCase(String naziv);

	public abstract List<Odeljenje> findByBolnica(Bolnica bolnica);
	
	@Query(value = "SELECT * FROM odeljenje WHERE lokacija LIKE %:lokacija%", nativeQuery = true)
	List<Odeljenje> findOdeljenjaByLokacijaContaining(@Param("lokacija") String lokacija);

}

//minimalno jedna pretraga treba da bude preko integera tacnije findBy...(int nekiInt) ili boolean]
// findbyIznosGreaterThan (int iznos)