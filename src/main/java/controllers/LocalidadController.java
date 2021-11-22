package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Localidad;
import services.LocalidadService;

@RestController
@RequestMapping("/localidades")
public class LocalidadController {
	@Autowired
	private LocalidadService localserv;

	@GetMapping()
	public List<Localidad> listarTodas() {
		return localserv.obtenerTodas();
	}

	@GetMapping()
	public List<Localidad> listarProvincias(@PathVariable("id_provincias") Integer id) throws Exception {

		return localserv.listarProvincias(id);
	}

	@PostMapping()
	public Localidad guardar(@RequestBody Localidad l) {
		return localserv.guardar(l);
	}

	@PutMapping()
	public Localidad update(@PathVariable("id_localidad") Integer id,@RequestBody Localidad l) throws Exception {
     return localserv.actualizar(id, l);
	}
	@DeleteMapping()
	public void eliminar(@PathVariable("id_localidad") Integer id) {
		localserv.eliminar(id);
	}
	
}
