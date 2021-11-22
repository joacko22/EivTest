package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import models.TiposDocumentos;
import repositorys.TipoDocumentoRepository;

@Service
public class TiposDocumentosService {

	@Autowired
	TipoDocumentoRepository documentoRepo;
	@Transactional(readOnly = true)
	public List<TiposDocumentos> obtenerTodas(){
		return documentoRepo.findAll();
	}
	@Transactional
	public TiposDocumentos guardar(TiposDocumentos t) {
	return documentoRepo.save(t);	
	}
	@Transactional
	public TiposDocumentos actualizar(Integer id,TiposDocumentos t) throws Exception {
		t = findByid(id);
		return documentoRepo.save(t);
	}
	public TiposDocumentos findByid(Integer id) throws Exception {
		Optional<TiposDocumentos> res = documentoRepo.findById(id);
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
