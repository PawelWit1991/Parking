package pl.pw.parking.client;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pw.parking.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {




}
