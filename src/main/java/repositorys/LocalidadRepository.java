package repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import models.Localidad;
@Repository
public interface LocalidadRepository extends JpaRepository<Localidad,Integer> {

	@Query("SELECT L FROM Localidad L WHERE L.id_provincias LIKE : idProvincias")
	public List<Localidad>buscarPorProvincia(@Param("idProvincias")Integer idProvincia);
}
