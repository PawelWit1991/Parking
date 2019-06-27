package pl.pw.parking.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public void save(Client client) {
        clientRepository.save(client);
    }



    public void update(Client client) {
        clientRepository.findById(client.getId()).ifPresent(clientdb -> {

            if(client.getFirstName()!=null){
                clientdb.setFirstName(client.getFirstName());
            }
            if(client.getLastName()!=null){
                clientdb.setLastName(clientdb.getLastName());
            }

            clientRepository.save(clientdb);
        });
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
