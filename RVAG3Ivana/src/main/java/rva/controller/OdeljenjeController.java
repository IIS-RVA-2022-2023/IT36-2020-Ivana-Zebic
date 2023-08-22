package rva.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rva.model.Bolnica;
import rva.model.Odeljenje;
import rva.service.BolnicaService;
import rva.service.OdeljenjeService;

@CrossOrigin
@RestController
public class OdeljenjeController {
	
	@Autowired 
	private OdeljenjeService service;
	
	@Autowired
	private BolnicaService serviceBolnica;
	
	@GetMapping("odeljenje")
	public ResponseEntity<?> getAllOdeljenje(){
		List<Odeljenje> odeljenja = service.getAll();
		if(odeljenja.isEmpty()) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body("No odeljenje found");
		} 
		return ResponseEntity.status(HttpStatus.OK).body(odeljenja);
	}
	
	@GetMapping("odeljenje/{id}")
	public ResponseEntity<?> getOdeljenjeById(@PathVariable("id") long id){
		Optional<Odeljenje> odeljenja = service.getById(id); 
		if(odeljenja.isEmpty()) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body("No odeljenje found for requested id");
		}
		return ResponseEntity.status(HttpStatus.OK).body(odeljenja);
	}
	
	@GetMapping("odeljenje/naziv/{naziv}")
	public ResponseEntity<?> getOdeljenjeByNaziv(@PathVariable("naziv") String naziv){ 
		Optional<List<Odeljenje>> odeljenja = service.findByNaziv(naziv);
		if(odeljenja.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(odeljenja);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No odeljenje found for requested name");
	}
	
	// ISPRAVITI ??????????????
	@GetMapping("odeljenje/bolnica/{id}")
	public ResponseEntity<?> getAllOdeljenja(@PathVariable("id") Long id){
		Optional<Bolnica> bolnice = serviceBolnica.getBolnicaById(id);
		if(bolnice.isPresent()) {
			Optional<List<Odeljenje>> odeljenja = service.findOdeljenjeByBolnica(bolnice.get());
			if (odeljenja.isPresent()) {
				return ResponseEntity.status(HttpStatus.OK).body(odeljenja);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No odeljenja found in requested Bolnica");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No odeljenja found in requested Bolnica");
	}
	
	@GetMapping("odeljenje/lokacija/{lokacija}")
	public ResponseEntity<?> getOdeljenjeByLokacija(@PathVariable("lokacija") String lokacija){
		Optional<List<Odeljenje>> odeljenja = service.findOdeljenjeByLokacija(lokacija);
		if(odeljenja.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No odeljenja found in requested location");
		}
		return ResponseEntity.status(HttpStatus.OK).body(odeljenja);
	}

	@PostMapping("odeljenje")
	public ResponseEntity<?> addOdeljenje(@RequestBody Odeljenje odeljenje){
		Odeljenje savedOdeljenje;
		if(!service.existsById(odeljenje.getId())) {
			savedOdeljenje = service.addOdeljenje(odeljenje);
		} else {
			List<Odeljenje> listOdeljenje = service.getAll();
			long topValue = 1;
			for (int i = 0; i< listOdeljenje.size(); i++)
			{
				if (topValue <= listOdeljenje.get(i).getId()) {
					topValue = listOdeljenje.get(i).getId();
				}
				if (i == listOdeljenje.size() - 1) {
					topValue++;
				}
			}
			odeljenje.setId(topValue);
			savedOdeljenje = service.addOdeljenje(odeljenje);
		}
		URI uri = URI.create("/odeljenje/" + savedOdeljenje.getId());
		return ResponseEntity.created(uri).body(savedOdeljenje);
		
	}
	
	@PutMapping("odeljenje/{id}")
	public ResponseEntity<?> putOdeljenje(@RequestBody Odeljenje odeljenje, @PathVariable("id") long id){
		odeljenje.setId(id);
		if(!service.existsById(odeljenje.getId())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Odeljenje with requested id does not exist");
		}
		Odeljenje azuriranoOdeljenje = service.addOdeljenje(odeljenje);
		return ResponseEntity.status(HttpStatus.OK).body(azuriranoOdeljenje);
	}
	
	@DeleteMapping("odeljenje/{id}")
	public ResponseEntity<?> deleteOdeljenje(@PathVariable long id){
		if(service.existsById(id)) {
			service.deleteOdeljenje(id);
			return ResponseEntity.ok("Odeljenje with requested id deleted successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Odeljenje with requested id does not exist");
	}
}
