package rva.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import rva.model.Pacijent;
import rva.service.DijagnozaService;
import rva.service.OdeljenjeService;
import rva.service.PacijentService;

public class PacijentController {
	@Autowired
	private PacijentService service;

	@Autowired
	private OdeljenjeService serviceOdeljenje;

	@Autowired
	private DijagnozaService serviceDijagnoza;

	@GetMapping("pacijent")
	public ResponseEntity<?> getPacijent() {
		List<Pacijent> pacijenti = service.getAll();
		if (pacijenti.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No pacijent found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(pacijenti);
	}

	@GetMapping("pacijent/{id}")
	public ResponseEntity<?> getPacijentById(@PathVariable("id") long id) {
		Optional<Pacijent> pacijent = service.getById(id);
		if (pacijent.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No pacijent found for requested id");
		}
		return ResponseEntity.status(HttpStatus.OK).body(pacijent);
	}

	@GetMapping("pacijentPrezime/{prezime}")
	public ResponseEntity<?> getPacijentByPrezime(@PathVariable("prezime") String prezime) {
		Optional<List<Pacijent>> pacijenti = service.getByPrezime(prezime);
		if (pacijenti.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No pacijent found for requested last name");
		}
		return ResponseEntity.status(HttpStatus.OK).body(pacijenti);
	}

	@GetMapping("pacijent/odeljenje/{id}")
	public ResponseEntity<?> getPacijentByOdeljenje(@PathVariable("id") long id) {
		if (!service.getByOdeljenje(serviceOdeljenje.getById(id).get()).get().isEmpty()) {
			return ResponseEntity.ok(service.getByOdeljenje(serviceOdeljenje.getById(id).get()).get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pacijent na trazenom odeljenju nije pronadjen");
	}

	@GetMapping("pacijent/dijagnoza/{id}")
	public ResponseEntity<?> getPacijentByDijagnoza(@PathVariable("id") long id) {
		if (!service.getByDijagnoza(serviceDijagnoza.getByIdDijagnoza(id).get()).get().isEmpty()) {
			return ResponseEntity.ok(service.getByDijagnoza(serviceDijagnoza.getByIdDijagnoza(id).get()).get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pacijent sa trazenom dijagnozom nije pronadjen");
	}

	@PostMapping("pacijent")
	public ResponseEntity<?> addPacijent(@RequestBody Pacijent pacijent) {
		if (!service.existsById(pacijent.getId())) {
			Pacijent noviPacijent = service.addPacijent(pacijent);
			return ResponseEntity.status(HttpStatus.OK).body(noviPacijent);
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Pacijent with requested id already exists");
	}

	@PutMapping("pacijent/{id}")
	public ResponseEntity<?> putPacijent(@RequestBody Pacijent pacijent, @PathVariable("id") long id) {
		pacijent.setId(id);
		if (!service.existsById(pacijent.getId())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pacijent with requested id does not exist");
		}
		Pacijent azuriraniPacijent = service.addPacijent(pacijent);
		return ResponseEntity.status(HttpStatus.OK).body(azuriraniPacijent);
	}
	
	@DeleteMapping("pacijent/{id}")
	public ResponseEntity<?> deletePacijent(@PathVariable("id") long id) {
		if(!service.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pacijent with requested id does not exist");
		}
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Odeljenje with requested id deleted successfully");
	}

}
