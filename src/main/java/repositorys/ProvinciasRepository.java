package repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Provincia;
@Repository
public interface ProvinciasRepository extends JpaRepository<Provincia,Integer> {

}
