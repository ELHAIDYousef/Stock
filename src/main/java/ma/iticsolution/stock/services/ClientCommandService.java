package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.ClientCommand;

import java.util.List;


public interface ClientCommandService {

    List<ClientCommand> findAllCommands();
    ClientCommand addCommand(ClientCommand cc);
    ClientCommand findCommandById(Long id);
    ClientCommand updateCommand(ClientCommand cc , Long id);
    void deleteCommand(Long id);
    List<ClientCommand> findCommandByEtat(String etat);

}
