package repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import models.Usuarios;
@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios,Integer>{
	
	@Query("SELECT a from Usuarios a WHERE a.nombre_usuario LIKE :nombre")
	public  Usuarios findByUser(@Param("nombre_usuario") String nombre);
}
