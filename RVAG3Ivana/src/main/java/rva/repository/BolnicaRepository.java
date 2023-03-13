package rva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.model.Bolnica;

public interface BolnicaRepository extends JpaRepository<Bolnica,Long>{
	
	public abstract List<Bolnica> findByNazivContainingIgnoreCase(String naziv);
}
