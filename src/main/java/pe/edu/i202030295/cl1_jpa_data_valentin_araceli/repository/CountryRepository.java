package pe.edu.i202030295.cl1_jpa_data_valentin_araceli.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import pe.edu.i202030295.cl1_jpa_data_valentin_araceli.entity.Country;

import java.util.List;
import java.util.Optional;


public interface CountryRepository extends CrudRepository<Country, String> {

    // Búsqueda por código del país
    Optional<Country> findByCode(String code);

    boolean existsByCode(String code);

}
