package pl.pw.Parking.car;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.Parking.parking.Parking;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarService {

    @Autowired
    private CarDao carDao;
    @Autowired
    private CarService carService;
    @Autowired
    private CarRepository carRepository;

    public void save(Car car) {
        carDao.saveCar(car);
    }

    public Car find(long id) {
        Car car = carDao.findById(id);
        return car;
    }

    public void update(Car car) {
        carDao.update(car);
    }

    public void delete(long id) {
        Car found = find(id);
        carDao.delete(found);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();

    }

    public List<Car> findCarByClientId(Long id){
        return carRepository.findCarByClientId(id);
    }

    public Long getFreeSpaces() {
        return Parking.parkingSpaces-carRepository.countCars();
    }

}
