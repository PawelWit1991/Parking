package pl.pw.Parking.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientDao clientDao;
    @Autowired
    private ClientRepository clientRepository;

    public void save(Client client) {
        clientDao.saveClient(client);
    }

    public Client find(long id) {
        Client client = clientDao.findById(id);
        return client;
    }

    public void update(Client client) {
        clientDao.update(client);
    }

    public void delete(long id) {
        Client found = find(id);
        clientDao.delete(found);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();

    }


}
