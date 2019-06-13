package pl.pw.Parking.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.pw.Parking.car.Car;
import pl.pw.Parking.car.CarService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {


    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private CarService carService;

    @ModelAttribute("cars")
    public List<Car> getPublishers() {
        return carService.getAllCars();
    }

    @ModelAttribute("clients")
    public List<Client> getClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/add")
    public String add(Model model) {
        Client client=new Client();
        model.addAttribute("client",client);

        return "client/add";
    }


    //sposob bez walidacji
//    @PostMapping("/add")
//    @ResponseBody
//
//    public String addedCar(Model model, @RequestParam String firstName, @RequestParam String lastName ){
//
//
//       Client client=new Client(firstName,lastName);
//        model.addAttribute("client",client);
//        clientService.save(client);
//
//
//        return "cars/komunikatDodania";
//
//    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processRegistration(@Valid Client client, BindingResult result) {
        if (result.hasErrors()) {
            return "client/add";
        }
        clientDao.saveClient(client);
        return "redirect:/client/all";
    }

    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "client/all";
    }

    @RequestMapping("/delete/{id}")

    public String delete(@PathVariable Long id) {
        clientService.delete(id);
        return "redirect:/client/all";
    }

    @RequestMapping("/edit/{id}")

    public String editClient(@PathVariable Long id, Model model) {
        Client client= clientService.find(id);
        model.addAttribute("client",client);
        clientService.update(client);
        return "client/edit";
    }

    @PostMapping("/edit/{id}")       // w ten sposob odbieram edytowana clienta z widoku edit.jsp

    public String editedBook(@Valid Client client){

        clientService.update(client);

        return "redirect:/client/all";
    }


}
