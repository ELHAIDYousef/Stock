package ma.iticsolution.stock.repository;


import ma.iticsolution.stock.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FournisseurRepo extends JpaRepository<Fournisseur, Long> {
    List<Fournisseur> findFournisseurByNameContains(String name);
}
