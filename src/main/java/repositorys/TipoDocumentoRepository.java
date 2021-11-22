package repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import models.TiposDocumentos;
@Repository
public interface TipoDocumentoRepository extends JpaRepository<TiposDocumentos,Integer>{

	@Query("SELECT t FROM TiposDocumentos WHERE t.validar_como_cuit = true")
	public List<TiposDocumentos>buscarCuit(@Param("validar_como_cuit")Boolean validarcuit);
}
