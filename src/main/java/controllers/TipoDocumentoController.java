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

import models.TiposDocumentos;
import services.TiposDocumentosService;

@RestController
@RequestMapping("/tipos_documentos")
public class TipoDocumentoController {
	@Autowired
	TiposDocumentosService documentosService;

	@GetMapping()
	public List<TiposDocumentos> listarTodas() {
		return documentosService.obtenerTodas();
	}

	@PostMapping()
	public TiposDocumentos guardar(@RequestBody TiposDocumentos t) {
		return documentosService.guardar(t);
	}

	@PutMapping()
	public TiposDocumentos update(@PathVariable("id_tipodocumento") Integer id, @RequestBody TiposDocumentos l) throws Exception {
		return documentosService.actualizar(id, l);
	}

	@DeleteMapping()
	public void eliminar(@PathVariable("id_tipodocumento") Integer id) {
		documentosService.eliminar(id);
	}
}
