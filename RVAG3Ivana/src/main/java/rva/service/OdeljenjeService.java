package rva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Bolnica;
import rva.model.Odeljenje;
import rva.repository.OdeljenjeRepository;

@Service
public class OdeljenjeService {
	
	@Autowired
	private OdeljenjeRepository repo; //dependency injection 
	
	public List<Odeljenje> getAll(){
		return repo.findAll();
	}
	
	public Optional<Odeljenje> getById(long id){
		return repo.findById(id);
	}
	
	public Optional<List<Odeljenje>> findByNaziv(String naziv){
		Optional<List<Odeljenje>> odeljenje= Optional.of(repo.findByNazivContainingIgnoreCase(naziv));
		return odeljenje;
	}

	public Optional<List<Odeljenje>> findOdeljenjeByBolnica(Bolnica bolnica){
		Optional<List<Odeljenje>> odeljenjeBol= Optional.of(repo.findByBolnica(bolnica));
		return odeljenjeBol;
	}
	
	public Optional<List<Odeljenje>> findOdeljenjeByLokacija(String lokacija){
		return Optional.of(repo.findOdeljenjaByLokacijaContaining(lokacija));
	}
	
	public Odeljenje addOdeljenje(Odeljenje odeljenje) {
		return repo.save(odeljenje);
	}
	
	public boolean existsById(long id) {
		return getById(id).isPresent();
	}
	
	public void deleteOdeljenje(long id) {
		repo.deleteById(id);
	}
}
