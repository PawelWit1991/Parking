package pl.pw.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.pw.parking.domain.Car;
import pl.pw.parking.domain.Parking;
import pl.pw.parking.service.ParkingService;

@Controller
@RequestMapping("/parking")
public class ParkingController {


    @Autowired
    private ParkingService parkingService;


    @GetMapping("/create/{id}")
    public String getCreate(Model model, @PathVariable Long id) {

        model.addAttribute("parking", Parking.builder()
                .car(Car.builder().id(id).build())
                .build());

        return "parking/create";

    }

    @PostMapping("/create")
    public String postCreate(Parking parking) {

        parkingService.save(parking);

        return "redirect:/car/all";

    }
}
