package pl.pw.parking.car;

import java.time.*;

public class CarFeeUtils {
    public static void main(String[] args) {
        calculateFee();
    }

    public static void calculateFee() {

        long rentDays = 35;
        Boolean rentInactive = false;

        LocalDate startFeeDate = LocalDate.of(2019, Month.MAY, 1);
        LocalDate startFeeDatePlusDays = startFeeDate.plusDays(rentDays);
//        LocalDate endFeeDate = LocalDate.of(2019, Month.MAY, 5);

        LocalDate now = LocalDate.now();

        LocalDate nowMinusRentDays = now.minusDays(rentDays);
        System.out.println(nowMinusRentDays);


        if (startFeeDatePlusDays.isAfter(nowMinusRentDays)) {
            rentInactive = true;
        }


        System.out.println("rentInactive : " + rentInactive);
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime newZonedDateTime = zonedDateTime.minus(Period.ofDays(4));
        ZonedDateTime newerZonedDateTime = zonedDateTime.plus(Period.ofDays(4));
        LocalTime now2=LocalTime.now();
        System.out.println(now2.plusMinutes(110).equals(now));
    }
}
