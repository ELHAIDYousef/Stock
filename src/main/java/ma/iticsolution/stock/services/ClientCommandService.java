package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.CommandClient;

import java.util.List;


public interface ClientCommandService {

    List<CommandClient> findAllCommands();
    CommandClient addCommand(CommandClient cc);
    CommandClient findCommandById(Long id);
    CommandClient updateCommand(CommandClient cc , Long id);
    void deleteCommand(Long id);
    List<CommandClient> findCommandByEtat(String etat);

}
