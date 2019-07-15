package pl.pw.parking.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pw.parking.repository.ClientRepository;
import pl.pw.parking.domain.Client;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientService {

//    @Autowired
//    private ClientDao clientDao;
    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client) {
        return clientRepository.save(client);
    }



    public Client update(Client client) {
        return clientRepository.findById(client.getId()).map(clientdb -> {

            if(client.getFirstName()!=null){
                clientdb.setFirstName(client.getFirstName());
            }
            if(client.getLastName()!=null){
                clientdb.setLastName(client.getLastName());
            }

          return  clientRepository.save(clientdb);
        }).orElse(null);
    }

    public void delete(long id) {
        clientRepository.deleteById(id);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();

    }

    public Client findByClientId(Long id){
        return clientRepository.findById(id).orElse(new Client());
    }

}
