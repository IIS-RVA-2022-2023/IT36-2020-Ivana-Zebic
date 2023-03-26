package rva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.model.Pacijent;

public interface PacijentRepository extends JpaRepository<Pacijent,Long>{
	public abstract List<Pacijent> findByPrezimeContainingIgnoreCase(String prezime);
}
