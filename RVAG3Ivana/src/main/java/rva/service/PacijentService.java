package rva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Pacijent;
import rva.repository.PacijentRepository;

@Service
public class PacijentService {

	@Autowired
	private PacijentRepository repo;
	
	public List<Pacijent> getAll() {
		return repo.findAll();
	}
	
	public Optional<Pacijent> getById(long id){
		return repo.findById(id);
	}
	
	public Optional<List<Pacijent>> getByPrezime(String prezime){
		Optional<List<Pacijent>> pacijent = Optional.of(repo.findByPrezimeContainingIgnoreCase(prezime));
		return pacijent;
	}
	
	public Pacijent addPacijent(Pacijent pacijent) {
		return repo.save(pacijent);
	}
	
	public boolean existsById(long id) {
		return getById(id).isPresent();
	}
	
	public void deleteById(long id) {
		repo.deleteById(id);
	}
	
	
}
