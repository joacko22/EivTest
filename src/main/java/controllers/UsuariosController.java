package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import models.Usuarios;
import services.UsuarioService;

@RestController
public class UsuariosController {
	@Autowired
	UsuarioService userService;

	@GetMapping()
	public List<Usuarios> findAll() {
		return userService.obtenerTodos();
	}

	@PostMapping()
	public Usuarios guardar(Usuarios user) {
		return userService.guardar(user);
	}

	@PutMapping()
	public Usuarios actualizar(@PathVariable("id_tipodocumento") Integer id,@RequestBody Usuarios user) throws Exception {
		return userService.update(id, user);
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@DeleteMapping()
	public void borrar(Integer id) {
        userService.eliminar(id);
	}
}
