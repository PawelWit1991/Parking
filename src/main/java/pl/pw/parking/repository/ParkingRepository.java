package pl.pw.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pw.parking.domain.Parking;

public interface ParkingRepository extends JpaRepository<Parking, Long> {


}
