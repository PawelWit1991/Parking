package pl.pw.parking.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.pw.parking.service.CarService;
import pl.pw.parking.domain.Car;
import pl.pw.parking.domain.Client;
import pl.pw.parking.service.ClientService;

import javax.validation.Valid;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;
    @Autowired
    private ClientService clientService;


    @ModelAttribute("clients")
    public List<Client> getClients() {
        return clientService.getAllClients();
    }



    @GetMapping("/add")
    public String add(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "car/add";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid Car car, BindingResult result) {

        if (result.hasErrors()) {
            return "car/add";
        }
        carService.save(car);
        return "redirect:/car/all";
    }

    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "car/carsList";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        carService.delete(id);
        return "redirect:/car/all";
    }

    @RequestMapping("/edit/{id}")

    public String editCar(@PathVariable Long id, Model model) {
        Car car = carService.find(id);
        model.addAttribute("car", car);
        carService.update(car);
        return "car/edit";
    }

    @PostMapping("/edit/{id}")

    public String editCar(@Valid Car car) {

        carService.update(car);

        return "redirect:/car/all";
    }

    @RequestMapping("/clientCars/{id}")


    public String findByClientId(@PathVariable Long id, Model model) {

        model.addAttribute("clientCars", carService.findCarByClientId(id));
        model.addAttribute("client", clientService.findByClientId(id));

        return "car/clientCars";


    }

    @GetMapping("/stopTime")
    public String time() {

        return "car/stopTime";
    }

//    @RequestMapping(value = "/stopTime", method = RequestMethod.POST)
//    public String time() {
//
//
//
//        return "redirect:/";
//    }

    @PostMapping("/stopTime")
    @ResponseBody

    public String time(@RequestParam String mins) {

        long minsL=Long.parseLong(mins);
        LocalTime now=LocalTime.now();
        LocalTime toOver=now.plusMinutes(minsL);

        return toOver.toString();

    }
}
