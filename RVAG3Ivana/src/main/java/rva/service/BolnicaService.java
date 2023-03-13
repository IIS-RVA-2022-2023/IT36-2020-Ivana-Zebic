package rva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Bolnica;
import rva.repository.BolnicaRepository;

@Service
public class BolnicaService {
	
	@Autowired
	private BolnicaRepository repo;
	
	public List<Bolnica> getAll(){
		return repo.findAll();
	}
	
	public Optional<Bolnica> getById(long id){
		
		return repo.findById(id);
	}
	
	public Optional<List<Bolnica>> getByNaziv(String naziv){
		Optional<List<Bolnica>> bolnica= Optional.of(repo.findByNazivContainingIgnoreCase(naziv));
		return bolnica;
	}
	
	public Bolnica addBolnica(Bolnica bolnica) {
		
		return repo.save(bolnica);
	}
	
	public boolean existsById(long id) {
		
		return getById(id).isPresent();
	}
	
	public void deleteById(long id) {
		
		repo.deleteById(id);
	}
}
