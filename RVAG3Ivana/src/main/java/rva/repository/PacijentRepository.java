package rva.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rva.model.Dijagnoza;
import rva.model.Odeljenje;
import rva.model.Pacijent;

public interface PacijentRepository extends JpaRepository<Pacijent, Long> {
	public abstract List<Pacijent> findByPrezimeContainingIgnoreCase(String prezime);

	public abstract List<Pacijent> findByOdeljenje(Odeljenje odeljenje);

	public abstract List<Pacijent> findByDijagnoza(Dijagnoza dijagnoza);

	@Query(value = " SELECT * FROM pacijent where datum_rodjenja > :datumRodjenja ORDER BY datum_rodjenja", nativeQuery = true)
	public abstract List<Pacijent> findBydatumRodjenjaGreaterThanOrderBydatumRodjenja(
			@Param("datumRodjenja") Date datumRodjenja);
}
