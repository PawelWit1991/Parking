package pl.pw.Parking.client;

import org.hibernate.validator.constraints.NotBlank;
import pl.pw.Parking.car.Car;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Imie nie moze byc puste")

    @Column(name = "firstname")
    private String firstName;

    @NotBlank(message = "Nazwisko nie moze byc puste")
    @Column(name = "lastname")
    private String lastName;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)

    private List<Car> cars =
            new ArrayList<>();


    public Client() {
    }

    public Client(String firstName, String lastName, List<Car> cars) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cars = cars;
    }

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
