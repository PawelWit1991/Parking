package pl.pw.parking.car;


import org.springframework.stereotype.Component;
import pl.pw.parking.domain.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Component
public class CarDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveCar(Car car) {
        entityManager.persist(car);

    }

    public Car findById(long id) {
        return entityManager.find(Car.class, id);
    }

    public void update(Car car) {
        entityManager.merge(car);
    }

    public void delete(Car car) {
        entityManager.remove(entityManager.contains(car) ?
                car : entityManager.merge(car));
    }

}
