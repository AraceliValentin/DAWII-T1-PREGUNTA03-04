package pe.edu.i202030295.cl1_jpa_data_valentin_araceli.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class CountryLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String countryCode;
    private String language;
    private Boolean isOfficial;
    private Double percentage;

    @ManyToOne
    @JoinColumn(name = "country_code")
    private Country country;
}
