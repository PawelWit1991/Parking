package pl.pw.parking.dao;


import org.springframework.stereotype.Component;
import pl.pw.parking.domain.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class ClientDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveClient(Client client) {
        entityManager.persist(client);

    }

    public Client findById(long id) {
        return entityManager.find(Client.class, id);
    }

    public void update(Client client) {
        entityManager.merge(client);
    }

    public void delete(Client client) {
        entityManager.remove(entityManager.contains(client) ?
                client : entityManager.merge(client));
    }

}
