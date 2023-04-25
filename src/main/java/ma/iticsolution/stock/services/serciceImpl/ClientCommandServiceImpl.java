package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.CommandClient;
import ma.iticsolution.stock.repository.ClientCommandRepo;
import ma.iticsolution.stock.services.ClientCommandService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientCommandServiceImpl implements ClientCommandService {

    final ClientCommandRepo ccRepo;

    public ClientCommandServiceImpl(ClientCommandRepo ccRepo) {
        this.ccRepo = ccRepo;
    }


    @Override
    public List<CommandClient> findAllCommands() {
        return ccRepo.findAll();
    }

    @Override
    public CommandClient addCommand(CommandClient cc) {
        return ccRepo.save(cc);
    }

    @Override
    public CommandClient findCommandById(Long id) {
        return ccRepo.findById(id).get();
    }

    @Override
    public CommandClient updateCommand(CommandClient cc, Long id) {
        cc.setId(id);
        return ccRepo.save(cc);
    }

    @Override
    public void deleteCommand(Long id) {
        ccRepo.deleteById(id);
    }

    @Override
    public List<CommandClient> findCommandByEtat(String etat) {
        return ccRepo.findCommandByEtat(etat);
    }
}
