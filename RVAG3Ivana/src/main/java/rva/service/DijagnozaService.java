package rva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Dijagnoza;
import rva.repository.DijagnozaRepository;

@Service 
public class DijagnozaService {

	@Autowired
	private DijagnozaRepository repo;
	
	public List<Dijagnoza> getAllDijagnoza(){
		return repo.findAll();
	}
	
	public Optional<Dijagnoza> getByIdDijagnoza(long id){
		
		return repo.findById(id);
	}
	
	public Optional<List<Dijagnoza>> getByNazivDijagnoza(String naziv){
		Optional<List<Dijagnoza>> dijagnoza= Optional.of(repo.findByNazivContainingIgnoreCase(naziv));
		return dijagnoza;
	}
	
	public Dijagnoza addDijagnoza(Dijagnoza dijagnoza) {
		
		return repo.save(dijagnoza);
	}
	
	public boolean existsByIdDijagnoza(long id) {
		
		return getByIdDijagnoza(id).isPresent();
	}
	
	public void deleteDijagnozaById(long id) {
		
		repo.deleteById(id);
	}
}
