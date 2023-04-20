package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.ClientCommand;
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
    public List<ClientCommand> findAllCommands() {
        return ccRepo.findAll();
    }

    @Override
    public ClientCommand addCommand(ClientCommand cc) {
        return ccRepo.save(cc);
    }

    @Override
    public ClientCommand findCommandById(Long id) {
        return ccRepo.findById(id).get();
    }

    @Override
    public ClientCommand updateCommand(ClientCommand cc, Long id) {
        cc.setId(id);
        return ccRepo.save(cc);
    }

    @Override
    public void deleteCommand(Long id) {
        ccRepo.deleteById(id);
    }

    @Override
    public List<ClientCommand> findCommandByEtat(String etat) {
        return ccRepo.findCommandByEtat(etat);
    }
}
