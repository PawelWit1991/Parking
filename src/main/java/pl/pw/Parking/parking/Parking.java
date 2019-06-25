package pl.pw.Parking.parking;

import pl.pw.Parking.car.Car;

import javax.persistence.*;

@Entity
@Table
public class Parking {

   public final static long parkingSpaces = 50;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String parkingSpace;


   public Parking() {
   }

   public Parking(Long id, String parkingSpace) {
      this.id = id;
      this.parkingSpace = parkingSpace;
   }

   public static long getParkingSpaces() {
      return parkingSpaces;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getParkingSpace() {
      return parkingSpace;
   }

   public void setParkingSpace(String parkingSpace) {
      this.parkingSpace = parkingSpace;
   }

   @Override
   public String toString() {
      return "Parking{" +
              "parkingSpace=" + parkingSpace +
              '}';
   }
}
