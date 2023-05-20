package ma.iticsolution.stock.repository;


import ma.iticsolution.stock.entities.CommandClient;
import ma.iticsolution.stock.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ClientCommandRepo extends JpaRepository<CommandClient,Long> {

    List<CommandClient> findCommandByEtat(String etat);
    @Query("select c from CommandClient c order by c.client.name")
    List<CommandClient> findOrderByName();
}
