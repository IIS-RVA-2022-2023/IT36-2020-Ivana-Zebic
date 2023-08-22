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

import rva.model.Dijagnoza;
import rva.service.DijagnozaService;

@CrossOrigin
@RestController
public class DijagnozaController {
	@Autowired
	private DijagnozaService service;
	
	@GetMapping("dijagnoza")
	public ResponseEntity<?> getAllDijagnoza(){
		List<Dijagnoza> dijagnoze = service.getAllDijagnoza();
		if(dijagnoze.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No dijagnoza found");	
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(dijagnoze);
		}
	}
	
	@GetMapping("dijagnoza/{id}")
	public ResponseEntity<?> getDijagnozaById (@PathVariable("id") long id){
		Optional<Dijagnoza> dijagnoze = service.getByIdDijagnoza(id);
		if(service.existsByIdDijagnoza(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(dijagnoze);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No dijagnoza found for given id");
		}
	}
	
	@GetMapping("dijagnoza/{naziv}")
	public ResponseEntity<?> getDijagnozaByNaziv (@PathVariable("naziv") String naziv){
		Optional<List<Dijagnoza>> dijagnoze = service.getByNazivDijagnoza(naziv);
		if (dijagnoze.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No dijagnoza found for requested name");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(dijagnoze);
		}
	}
	
	@PostMapping("dijagnoza")
	public ResponseEntity<?> postDijagnoza(@RequestBody Dijagnoza dijagnoza){
		if(!service.existsByIdDijagnoza(dijagnoza.getId())) {
			Dijagnoza novaDijagnoza = service.addDijagnoza(dijagnoza);
			return ResponseEntity.status(HttpStatus.OK).body(novaDijagnoza);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Dijagnoza with requested id already exists");
		}
	}
	
	@PutMapping("dijagnoza/{id}")
	public ResponseEntity<?> putDijagnoza(@RequestBody Dijagnoza dijagnoza,@PathVariable("id") long id){
		dijagnoza.setId(id);
		if(!service.existsByIdDijagnoza(dijagnoza.getId())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dijagnoza with requested id does not exist");
		} 
		Dijagnoza azuriranaDijagnoza = service.addDijagnoza(dijagnoza);
		return ResponseEntity.status(HttpStatus.OK).body(azuriranaDijagnoza);
	}
	
	@DeleteMapping("dijagnoza/{id}")
	public ResponseEntity<?> deleteDijagnoza(@PathVariable long id){
		if(!service.existsByIdDijagnoza(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dijagnoza with requested id does not exist");
		} 
		service.deleteDijagnozaById(id);
		return ResponseEntity.ok("Dijagnoza with requested id deleted successfully");
	}
}
