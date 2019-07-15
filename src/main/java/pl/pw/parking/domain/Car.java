package pl.pw.parking.domain;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Table(name="cars")
@Data  //gettery i settery
@NoArgsConstructor //pusty konstruktor
@AllArgsConstructor  //konstruktor wszystkoargumentowy
@Builder //wzorzec projektowy builder
@ToString
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Wpisz marke")
    @Column
    private String brand;

    @NotBlank(message = "Wpisz model")
    @Column(name = "model")
    private String modelCar;

    @NotBlank(message = "Wpisz numer rejestracyjny")
    @Column(name = "rejestracja")
    private String registrationNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_id")
    private Client client;


    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private Parking parking;


}
