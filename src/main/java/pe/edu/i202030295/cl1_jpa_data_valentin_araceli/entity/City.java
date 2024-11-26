package pe.edu.i202030295.cl1_jpa_data_valentin_araceli.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String district;
    private Integer population;

    @ManyToOne
    @JoinColumn(name = "country_code")
    private Country country;
}
