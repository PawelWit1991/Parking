package pl.pw.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.pw.parking.domain.Client;
import pl.pw.parking.service.ClientService;
import sun.misc.Cleaner;

import java.util.List;

@RequestMapping("/v1/client")
@RestController
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/list")
    public List<Client> getClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id){

        return clientService.findByClientId(id);
    }


    @PostMapping
    public Client createClient(@RequestBody Client client){

        return clientService.save(client);
    }

    @PutMapping
    public Client updateClient(@RequestBody Client client){

        return clientService.update(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){

        clientService.delete(id);
    }


}
