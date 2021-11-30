package com.apirest.eivtest.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apirest.eivtest.models.TipoDocumento;
@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento,Integer>{

	@Query("SELECT t FROM TiposDocumentos WHERE t.validar_como_cuit = true")
	public List<TipoDocumento>buscarCuit(@Param("validar_como_cuit")Boolean validarcuit);
}
