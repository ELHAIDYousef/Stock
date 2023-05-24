package ma.iticsolution.stock.repository;


import ma.iticsolution.stock.entities.CommandFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FournisseurCommandRepo extends JpaRepository<CommandFournisseur,Long> {

    List<CommandFournisseur> findCommandByEtat(String etat);
    @Query("select c from CommandFournisseur c order by c.fournisseur.name")
    List<CommandFournisseur> findOrderByName();

}
