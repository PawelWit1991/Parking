package pl.pw.Parking.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pw.Parking.client.Client;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {


    List<Car> findCarByClientId(Long id);

    @Query(value = "SELECT count(*) FROM Car",
            nativeQuery = true)
    Long countCars();


}
