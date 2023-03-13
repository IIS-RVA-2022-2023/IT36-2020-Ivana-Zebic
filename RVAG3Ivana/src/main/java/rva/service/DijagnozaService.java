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
	
	public List<Dijagnoza> getAll(){
		return repo.findAll();
	}
	
	public Optional<Dijagnoza> getById(long id){
		
		return repo.findById(id);
	}
	
	public Optional<List<Dijagnoza>> getByNaziv(String naziv){
		Optional<List<Dijagnoza>> dijagnoza= Optional.of(repo.findByNazivContainingIgnoreCase(naziv));
		return dijagnoza;
	}
	
	public Dijagnoza addDijagnoza(Dijagnoza dijagnoza) {
		
		return repo.save(dijagnoza);
	}
	
	public boolean existsById(long id) {
		
		return getById(id).isPresent();
	}
	
	public void deleteById(long id) {
		
		repo.deleteById(id);
	}
}
