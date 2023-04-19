package ma.iticsolution.stock.repository;


import ma.iticsolution.stock.entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommandRepo extends JpaRepository<Command,Long> {

    List<Command> findCommandByEtatContains(String etat);
}
