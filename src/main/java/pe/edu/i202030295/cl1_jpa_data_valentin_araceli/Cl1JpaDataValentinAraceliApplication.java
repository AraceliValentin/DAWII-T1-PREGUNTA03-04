package pe.edu.i202030295.cl1_jpa_data_valentin_araceli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202030295.cl1_jpa_data_valentin_araceli.entity.Country;
import pe.edu.i202030295.cl1_jpa_data_valentin_araceli.repository.CountryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class Cl1JpaDataValentinAraceliApplication implements CommandLineRunner {

	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataValentinAraceliApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Lista de códigos de países a eliminar
		List<String> countriesToDelete = List.of("COL", "ARG");

		// Filtrar para verificar que los países existan antes de eliminarlos
		List<String> existingCountries = countriesToDelete.stream()
				.filter(code -> countryRepository.existsByCode(code))
				.collect(Collectors.toList());

		// Eliminar si existen
		if (!existingCountries.isEmpty()) {
			countryRepository.deleteAllById(existingCountries);
			System.out.println("Se eliminaron los países: " + existingCountries);
		} else {
			System.out.println("No se encontraron países con los códigos especificados.");
		}
	}
	}


