package ma.iticsolution.stock.repository;

import ma.iticsolution.stock.entities.FactureClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactureClientRepo extends JpaRepository<FactureClient,Long> {
    List<FactureClient> findByCommand_Client_Id(Long id);
}
