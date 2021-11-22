package repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import models.Persona;
@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer>  {
	@Query("SELECT a from Persona a WHERE a.correo_electronico LIKE :correo_electronico")
	public Persona buscarPorEmail(@Param("correo_electronico") String email);
	
	public List<Persona>findByEmail(String email);
	@Query("SELECT p FROM Persona p WHERE p.es_argentino = true")
	public Persona buscarArgentinos(@Param("es_argentino")Boolean esargentino);
	
}
