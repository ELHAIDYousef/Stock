package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.Command;

import java.util.List;


public interface CommandService {

    //public List<Command> findAllCommands();
    public Command addCommand(Command c);
    public Command findCommandById(Long id);
    public Command updateCommand(Command c , Long id);
    public void deleteCommand(Long id);
    public List<Command> findCommandByEtat(String etat);

}
