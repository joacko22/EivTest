package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Provincia;
import services.ProvinciaService;

@RestController
@RequestMapping("/provincias")
public class ProvinciaController {
	@Autowired
	ProvinciaService provinciaServicio;

	@PostMapping()
	public Provincia guardar(@RequestBody Provincia p) {
		return provinciaServicio.guardar(p);
	}

	@PutMapping()
	public Provincia update(@PathVariable("id_provincia") Integer id, @RequestBody Provincia p) throws Exception {
		return provinciaServicio.actualizar(id, p);
	}

	@DeleteMapping()
	public void eliminar(@PathVariable("id_provincia") Integer id) {
		provinciaServicio.eliminar(id);
	}

}
