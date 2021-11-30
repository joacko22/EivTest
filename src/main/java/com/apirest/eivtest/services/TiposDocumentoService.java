package com.apirest.eivtest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.eivtest.models.TipoDocumento;
import com.apirest.eivtest.repositorys.TipoDocumentoRepository;

@Service
public class TiposDocumentoService {

	@Autowired
	TipoDocumentoRepository documentoRepo;
	@Transactional(readOnly = true)
	public List<TipoDocumento> obtenerTodas(){
		return documentoRepo.findAll();
	}
	@Transactional
	public TipoDocumento guardar(TipoDocumento t) {
	return documentoRepo.save(t);	
	}
	@Transactional
	public TipoDocumento actualizar(Integer id,TipoDocumento t) throws Exception {
		t = findByid(id);
		return documentoRepo.save(t);
	}
	public TipoDocumento findByid(Integer id) throws Exception {
		Optional<TipoDocumento> res = documentoRepo.findById(id);
		if (res.isPresent()) {
			return res.get();
		}else {
			throw new Exception("No existe una localidad con ese ID");
		}
	}
	@Transactional
	public void eliminar(Integer id) {
		documentoRepo.deleteById(id);	
	}
	
}
