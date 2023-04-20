package ma.iticsolution.stock.repository;


import ma.iticsolution.stock.entities.ClientCommand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClientCommandRepo extends JpaRepository<ClientCommand,Long> {

    List<ClientCommand> findCommandByEtat(String etat);
}
