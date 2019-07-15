package pl.pw.parking.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.parking.repository.CarRepository;
import pl.pw.parking.domain.Car;


import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarService {


    @Autowired
    private CarService carService;
    @Autowired
    private CarRepository carRepository;

    public void save(Car car) {
        carRepository.save(car);
    }

    public Car find(long id) {
        Car car = carRepository.findById(id).orElse(new Car());
        return car;
    }

    public void update(Car car) {
        carRepository.findById(car.getId()).ifPresent(c->{
            if(car.getBrand()!=null){
                c.setBrand(car.getBrand());
            }
            if(car.getModelCar()!=null){
                c.setModelCar(car.getModelCar());
            }

            if(car.getRegistrationNumber()!=null){
                c.setRegistrationNumber(car.getRegistrationNumber());
            }

            carRepository.save(c);
        });
    }

    public void delete(long id) {
       carRepository.deleteById(id);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll().stream().map(car -> {
                if(car.getParking()!=null) {
                    if (car.getParking().getBoughtDate().isBefore(LocalDateTime.now())) {
                        car.getParking().setHowMany(Duration.between(LocalDateTime.now(), car.getParking().getEndDate()).toMinutes());
                    } else {
                        car.getParking().setHowMany(Duration.between(car.getParking().getBoughtDate(), car.getParking().getEndDate()).toMinutes());
                    }

                    if (car.getParking().getHowMany() < 0) {
                        car.getParking().setHowMany(0L);
                    }

                }
                else {
//                    car.getParking().setHowMany(0L);
                    return car;
                }
                return car;

        }).collect(Collectors.toList());

    }



    public List<Car> findCarByClientId(Long id){
        return carRepository.findCarByClientId(id);
    }






}
