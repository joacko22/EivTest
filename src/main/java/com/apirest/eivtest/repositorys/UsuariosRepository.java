package com.apirest.eivtest.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apirest.eivtest.models.Usuario;
@Repository
public interface UsuariosRepository extends JpaRepository<Usuario,Integer>{
	
	@Query("SELECT a from Usuarios a WHERE a.nombre_usuario LIKE :nombre")
	public  Usuario findByUser(@Param("nombre_usuario") String nombre);
}
