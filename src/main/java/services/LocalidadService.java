package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import models.Localidad;
import repositorys.LocalidadRepository;

@Service
public class LocalidadService {
	@Autowired
	LocalidadRepository localidadRepo;
	@Transactional(readOnly = true)
	public List<Localidad> obtenerTodas(){
		return localidadRepo.findAll();
	}
	@Transactional
	public Localidad guardar(Localidad l) {
	return localidadRepo.save(l);	
	}
	@Transactional
	public Localidad actualizar(Integer id,Localidad l) throws Exception {
		l = findByid(id);
		return localidadRepo.save(l);
	}
	public Localidad findByid(Integer id) throws Exception {
		Optional<Localidad> res = localidadRepo.findById(id);
		if (res.isPresent()) {
			return res.get();
		}else {
			throw new Exception("No existe una localidad con ese ID");
		}
	}
	@Transactional
	public void eliminar(Integer id) {
	localidadRepo.deleteById(id);	
	}
	
	
	@Transactional(readOnly = true)
	public List<Localidad>listarProvincias(Integer id) throws Exception{
		
		return  localidadRepo.buscarPorProvincia(id);
	}
}
