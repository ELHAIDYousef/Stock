package ma.iticsolution.stock.repository;

import ma.iticsolution.stock.entities.FactureClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FactureClientRepo extends JpaRepository<FactureClient,Long> {
    List<FactureClient> findByCommand_Client_Id(Long id);
    @Query(value = "SELECT * FROM facture_client ORDER BY date_facture DESC LIMIT 1", nativeQuery = true)
    FactureClient findLatestFactureClient();
}
