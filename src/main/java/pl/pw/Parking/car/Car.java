package pl.pw.Parking.car;

import org.hibernate.validator.constraints.NotBlank;
import pl.pw.Parking.client.Client;


import javax.persistence.*;


@Entity
@Table
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Wpisz marke")
    @Column

    private String brand;

    @NotBlank(message = "Wpisz model")
    @Column(name = "model")
    private String modelCar;


    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @NotBlank(message = "Wpisz numer rejestracyjny")
    @Column(name = "rejestracja")
    private String registrationNumber;


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", modelCar='" + modelCar + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", client=" + client +
                '}';
    }

    public Car(String brand, String modelCar, String registrationNumber, Client client) {
        this.brand = brand;
        this.modelCar = modelCar;
        this.registrationNumber = registrationNumber;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car() {
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public Car(String brand, String modelCar) {
        this.brand = brand;
        this.modelCar = modelCar;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

//    @NotBlank(message = "Wybierz wlasciciela")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_id")
    private Client client;


}
