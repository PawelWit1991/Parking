package pl.pw.Parking.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Long> {


    @Query("select c from Client c where c.id = ?1")
    Client findByClientId(Long id);

}
