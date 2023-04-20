package ma.iticsolution.stock.repository;

import ma.iticsolution.stock.entities.FactureFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactureFournisseurRepo extends JpaRepository<FactureFournisseur,Long> {
    List<FactureFournisseur> findByCommand_Fournisseur_Id(Long id);

}
