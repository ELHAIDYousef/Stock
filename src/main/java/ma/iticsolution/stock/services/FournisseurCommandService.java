package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.CommandFournisseur;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.util.List;


public interface FournisseurCommandService {

    List<CommandFournisseur> findAllCommands();
    CommandFournisseur addCommand(CommandFournisseur fc);
    CommandFournisseur findCommandById(Long id);
    CommandFournisseur updateCommand(CommandFournisseur fc , Long id);
    void deleteCommand(Long id);
    List<CommandFournisseur> findCommandByEtat(String etat);

    ResponseEntity<byte[]> generateReport() throws FileNotFoundException, JRException;
}
