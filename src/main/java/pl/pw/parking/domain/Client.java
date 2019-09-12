package pl.pw.parking.domain;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
@Data  //gettery i settery
@NoArgsConstructor //pusty konstruktor
@AllArgsConstructor  //konstruktor wszystkoargumentowy
@Builder //wzorzec projektowy builder
@ToString
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Imie nie moze byc puste")

    @Column(name = "firstname")
    private String firstName;

    @NotBlank(message = "Nazwisko nie moze byc puste")
    @Column(name = "lastname")
    private String lastName;


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Car> cars =
            new ArrayList<>();


}
