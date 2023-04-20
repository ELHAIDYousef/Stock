package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.FournisseurCommand;

import java.util.List;


public interface FournisseurCommandService {

    List<FournisseurCommand> findAllCommands();
    FournisseurCommand addCommand(FournisseurCommand fc);
    FournisseurCommand findCommandById(Long id);
    FournisseurCommand updateCommand(FournisseurCommand fc , Long id);
    void deleteCommand(Long id);
    List<FournisseurCommand> findCommandByEtat(String etat);

}
