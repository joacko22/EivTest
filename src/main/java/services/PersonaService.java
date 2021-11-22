package services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import models.Persona;
import repositorys.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	PersonaRepository personRepo;

	@Transactional(readOnly = true)
	public ArrayList<Persona> obtenerPersonas() {
		return (ArrayList<Persona>) personRepo.findAll();

	}

	@Transactional(readOnly = true)
	public Persona buscarEmail(String email) {
		return personRepo.buscarPorEmail(email);
	}

	@Transactional
	public Persona guardar(Persona p) {
		return personRepo.save(p);
	}

	@Transactional
	public Persona update(Integer id, Persona p) throws Exception {
		p = findById(id);
		return personRepo.save(p);
	}

	public Persona findById(Integer id) throws Exception {
		Optional<Persona> res = personRepo.findById(id);
		if (res.isPresent()) {
			return res.get();
		} else {
			throw new Exception("no existe una Persona con ese ID");
		}
	}

	@Transactional
	public void eliminar(Integer id) {

		personRepo.deleteById(id);
	}

	public void validar(Persona p) throws Exception {
		if (!p.getGenero().equals("M") || !p.getGenero().equals("F") || p.getGenero() == null) {
			throw new Exception("Genero ingresado incorrecto");
		}
		if (p.getEmail() == null || p.getEmail().isEmpty() || p.getEmail().contains("  ")) {
			throw new Exception("Debe tener un email valido");
		}
		if (!personRepo.findByEmail(p.getEmail()).isEmpty()) {
			throw new Exception("el email ya existe");
		}
		if (p.getCodigo_postal() == null) {
			throw new Exception("el codigo postal no puede ser vacio");
		}
		if (p.getFoto_cara() == null) {
			throw new Exception("falta una foto");
		}
		if (p.getIdLocalidad() == null) {
			throw new Exception("no existe una localidad con ese id");
		}
	}

}
