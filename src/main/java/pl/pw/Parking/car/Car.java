package pl.pw.Parking.car;
import org.hibernate.validator.constraints.NotBlank;
import pl.pw.Parking.client.Client;
import javax.persistence.*;


@Entity
@Table(name="cars")
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

    @NotBlank(message = "Wpisz numer rejestracyjny")
    @Column(name = "rejestracja")
    private String registrationNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_id")
    private Client client;


    @Column(unique=true)
    private Long parkingSpace;


    public Car() {
    }

    public Car(Long id) {
        this.id = id;
    }

    public Car(Long id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public Car(Long id,  String brand, String modelCar) {
        this.id = id;
        this.brand = brand;
        this.modelCar = modelCar;
    }

    public Car(Long id,  String brand, String modelCar,String registrationNumber) {
        this.id = id;
        this.brand = brand;
        this.modelCar = modelCar;
        this.registrationNumber = registrationNumber;
    }

    public Car(String brand, String modelCar, String registrationNumber, Client client) {
        this.brand = brand;
        this.modelCar = modelCar;
        this.registrationNumber = registrationNumber;
        this.client = client;
    }

    public Car(Long id, String brand, String modelCar, String registrationNumber, Long parkingSpace, Client client) {
        this.id = id;
        this.brand = brand;
        this.modelCar = modelCar;
        this.registrationNumber = registrationNumber;
        this.parkingSpace = parkingSpace;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(Long parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

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
}
