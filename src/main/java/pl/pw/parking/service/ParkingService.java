package pl.pw.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.parking.car.CarRepository;
import pl.pw.parking.domain.Parking;
import pl.pw.parking.repository.ParkingRepository;

import java.time.LocalDateTime;

@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;
    @Autowired
    private CarRepository carRepository;


    public void save(Parking parking) {

        carRepository.findById(parking.getCar().getId()).ifPresent(car -> {

            parking.setCar(car);
            parking.setEndDate(LocalDateTime.now().plusHours(parking.getHowMany()));
            parkingRepository.save(parking);
        });
    }
}
