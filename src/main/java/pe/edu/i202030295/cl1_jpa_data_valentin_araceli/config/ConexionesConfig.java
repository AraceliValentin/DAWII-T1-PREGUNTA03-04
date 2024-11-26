package pe.edu.i202030295.cl1_jpa_data_valentin_araceli.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConexionesConfig {

    @Bean
    public DataSource dataSource() {

        HikariConfig hikariConfig = new HikariConfig();

        // Carga las credenciales desde las variables de entorno
        hikariConfig.setJdbcUrl(System.getenv("DB_WORLD_URL"));
        hikariConfig.setUsername(System.getenv("DB_WORLD_USER"));
        hikariConfig.setPassword(System.getenv("DB_WORLD_PASS"));
        hikariConfig.setDriverClassName(System.getenv("DB_WORLD_DRIVER"));

        // Configuración personalizada del pool
        hikariConfig.setMaximumPoolSize(30);
        hikariConfig.setMinimumIdle(4);
        hikariConfig.setIdleTimeout(240000);  // 4 minutos en milisegundos
        hikariConfig.setConnectionTimeout(45000);  // 45 segundos en milisegundos

        return new HikariDataSource(hikariConfig);
    }


}
