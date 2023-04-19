package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.Command;
import ma.iticsolution.stock.repository.CommandRepo;
import ma.iticsolution.stock.services.CommandService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommandServiceImpl implements CommandService {

    final CommandRepo commandRepo;

    public CommandServiceImpl(CommandRepo commandRepo) {
        this.commandRepo = commandRepo;
    }

    @Override
    public Command addCommand(Command c) {
        return commandRepo.save(c);
    }

    @Override
    public Command findCommandById(Long id) {
        return commandRepo.findById(id).get();
    }

    @Override
    public Command updateCommand(Command c, Long id) {
        c.setId(id);
        return commandRepo.save(c);
    }

    @Override
    public void deleteCommand(Long id) {
        commandRepo.deleteById(id);
    }

    @Override
    public List<Command> findCommandByEtat(String etat) {
        return commandRepo.findCommandByEtatContains(etat);
    }
}
