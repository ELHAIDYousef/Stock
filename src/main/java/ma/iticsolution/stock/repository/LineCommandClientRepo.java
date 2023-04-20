package ma.iticsolution.stock.repository;


import ma.iticsolution.stock.entities.LineCommandClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineCommandClientRepo extends JpaRepository<LineCommandClient,Long> {

    List<LineCommandClient> findByCommand_Id(Long id);
}
