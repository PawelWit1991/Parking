package pl.pw.parking.car;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.parking.domain.Car;
import pl.pw.parking.domain.Parking;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarService {

//    @Autowired
//    private CarDao carDao;
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
        return carRepository.findAll();

    }

    public List<Car> findCarByClientId(Long id){
        return carRepository.findCarByClientId(id);
    }





    public List<Integer> parkingSpaces(){

        List<Integer> parkingSpaces=new ArrayList<>();

        for (int i = 0; i < 51; i++) {
            parkingSpaces.add(i);
        }

        return parkingSpaces;
    }

}
