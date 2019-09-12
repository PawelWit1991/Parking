package pl.pw.parking.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data  //gettery i settery
@NoArgsConstructor //pusty konstruktor
@AllArgsConstructor  //konstruktor wszystkoargumentowy
@Builder //wzorzec projektowy builder
@ToString
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
public class Parking {


    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    private LocalDateTime boughtDate;

    private LocalDateTime endDate;

    @Transient
    private Long howMany;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")

    private Car car;

}
