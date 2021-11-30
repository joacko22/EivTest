package com.apirest.eivtest.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.eivtest.models.Provincia;
@Repository
public interface ProvinciasRepository extends JpaRepository<Provincia,Integer> {

}
