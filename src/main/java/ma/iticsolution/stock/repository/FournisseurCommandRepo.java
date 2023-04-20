package ma.iticsolution.stock.repository;


import ma.iticsolution.stock.entities.FournisseurCommand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FournisseurCommandRepo extends JpaRepository<FournisseurCommand,Long> {

    List<FournisseurCommand> findCommandByEtat(String etat);
}
