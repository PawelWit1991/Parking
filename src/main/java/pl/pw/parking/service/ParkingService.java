package pl.pw.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.parking.repository.CarRepository;
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

            if(parkingRepository.findAll().stream().filter(parkingdb ->
                            (parking.getBoughtDate().equals(parkingdb.getBoughtDate())&&parking.getEndDate().equals(parkingdb.getEndDate()))  ||
                                    ( parkingdb.getBoughtDate().isAfter(parking.getBoughtDate()) && parkingdb.getEndDate().isBefore(parking.getBoughtDate()) &&
                                            parkingdb.getBoughtDate().isAfter(parking.getEndDate()) && parkingdb.getEndDate().isBefore(parking.getEndDate()))
                    ).count()<0) {

                parking.setCar(car);
                parking.setEndDate(LocalDateTime.now().plusHours(parking.getHowMany()));
                parkingRepository.save(parking);
            }
        });
    }
}
