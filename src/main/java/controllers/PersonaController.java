package controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

import models.Persona;
import services.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired
	PersonaService personaserv;
	
	@GetMapping
	public ArrayList<Persona> obtenerPersonas(){
		return personaserv.obtenerPersonas();
	}
	
	@PostMapping()
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy") // pasar fecha a json
	public Persona guardar(@RequestBody Persona person) {
		return this.personaserv.guardar(person);
	}
	
	@PutMapping()
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	public Persona actualizar(@RequestBody Persona p,@PathVariable("id_tipodocumento") Integer id) throws Exception{
		return this.personaserv.update(id,p);
	}
	
	@DeleteMapping()
	public void eliminar(@PathVariable("id_tipodocumento") Integer id) {
		personaserv.eliminar(id);
		
	}
	
	
}



