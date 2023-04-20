package ma.iticsolution.stock.repository;

import ma.iticsolution.stock.entities.LineCommandFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineCommandFournisseurRepo extends JpaRepository<LineCommandFournisseur,Long> {
    List<LineCommandFournisseur> findByCommand_Id(Long id);
}
