package ma.iticsolution.stock.repository;

import ma.iticsolution.stock.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepo extends JpaRepository<Client,Long> {

    List<Client> findClientByNameContains(String name);
}
