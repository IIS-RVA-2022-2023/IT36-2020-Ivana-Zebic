package rva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.model.Pacijent;

public interface PacijentRepository extends JpaRepository<Pacijent,Long>{

}
