package ma.iticsolution.stock.repository;


import ma.iticsolution.stock.entities.CommandClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClientCommandRepo extends JpaRepository<CommandClient,Long> {

    List<CommandClient> findCommandByEtat(String etat);
}
