package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.CommandFournisseur;

import java.util.List;


public interface FournisseurCommandService {

    List<CommandFournisseur> findAllCommands();
    CommandFournisseur addCommand(CommandFournisseur fc);
    CommandFournisseur findCommandById(Long id);
    CommandFournisseur updateCommand(CommandFournisseur fc , Long id);
    void deleteCommand(Long id);
    List<CommandFournisseur> findCommandByEtat(String etat);

}
