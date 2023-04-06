package rva.controller;

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
import rva.service.BolnicaService;

@CrossOrigin
@RestController
public class BolnicaController {
	@Autowired
	private BolnicaService service;
	
	@GetMapping("bolnica")
	public ResponseEntity<?> getAllBolnica() {
		List<Bolnica> bolnice = service.getAll();
		if (bolnice.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hospitals found.");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(bolnice);
		}
	}
	
	@GetMapping("bolnica/{id}")
	public ResponseEntity<?> getBolnicaById(@PathVariable("id") long id){
		Optional <Bolnica> bolnice = service.getBolnicaById(id);
		if (service.existsById(id)) {
			return ResponseEntity.ok(bolnice);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Requested resource does not exist");
		}
	}
	
	@GetMapping("bolnica/{naziv}")
	public ResponseEntity<?> getBolnicaByNaziv(@PathVariable("naziv") String naziv){
		Optional <List<Bolnica>> bolnice = service.getByNazivBolnica(naziv);
		if(bolnice.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hospitals with requested name not found");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(bolnice);
		}
	}
	
	@PostMapping("bolnica")
	public ResponseEntity<?> postBolnica(@RequestBody Bolnica bolnica){
		if(!service.existsById(bolnica.getId())) {
			Bolnica novaBolnica = service.addBolnica(bolnica);
			return ResponseEntity.status(HttpStatus.OK).body(novaBolnica);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Hospital with this id already exists");
		}
	}
	
	@PutMapping("bolnica/{id}")
	public ResponseEntity<?> putBolnica(@RequestBody Bolnica bolnica,@PathVariable("id") long id){
		bolnica.setId(id);
		if(!service.existsById(bolnica.getId())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bolnica with requested id not found");
		}
		Bolnica azuriranaBolnica= service.addBolnica(bolnica);
		return ResponseEntity.status(HttpStatus.OK).body(azuriranaBolnica);
	}
	
	@DeleteMapping("bolnica/{id}")
	public ResponseEntity<?> deleteBolnica(@PathVariable("id") long id){
		if(!service.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find bolnica with requested id");
		}
		service.deleteByIdBolnica(id);
		return ResponseEntity.status(HttpStatus.OK).body("Bolnica with requested id deleted successfully");
	}
}
