package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import models.Provincia;
import repositorys.ProvinciasRepository;

@Service
public class ProvinciaService {
	@Autowired
	ProvinciasRepository provinciaRepo;
	@Transactional(readOnly = true)
	public List<Provincia> obtenerTodas(){
		return provinciaRepo.findAll();
	}
	@Transactional
	public Provincia guardar(Provincia p) {
	return provinciaRepo.save(p);	
	}
	@Transactional
	public Provincia actualizar(Integer id,Provincia p) throws Exception {
		p = findByid(id);
		return provinciaRepo.save(p);
	}
	public Provincia findByid(Integer id) throws Exception {
		Optional<Provincia> res = provinciaRepo.findById(id);
		if (res.isPresent()) {
			return res.get();
		}else {
			throw new Exception("No existe una localidad con ese ID");
		}
	}
	@Transactional
	public void eliminar(Integer id) {
		provinciaRepo.deleteById(id);	
	}
	
}
