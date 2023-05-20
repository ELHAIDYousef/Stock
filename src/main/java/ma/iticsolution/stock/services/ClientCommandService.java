package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.CommandClient;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.util.List;


public interface ClientCommandService {

    List<CommandClient> findAllCommands();
    CommandClient addCommand(CommandClient cc);
    CommandClient findCommandById(Long id);
    CommandClient updateCommand(CommandClient cc , Long id);
    void deleteCommand(Long id);
    List<CommandClient> findCommandByEtat(String etat);

    ResponseEntity<byte[]> generateReport() throws FileNotFoundException, JRException;
}
