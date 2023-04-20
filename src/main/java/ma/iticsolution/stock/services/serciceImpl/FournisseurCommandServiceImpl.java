package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.FournisseurCommand;
import ma.iticsolution.stock.repository.FournisseurCommandRepo;
import ma.iticsolution.stock.services.FournisseurCommandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurCommandServiceImpl implements FournisseurCommandService {

    final FournisseurCommandRepo fcRepo;

    public FournisseurCommandServiceImpl(FournisseurCommandRepo fcRepo) {
        this.fcRepo = fcRepo;
    }


    @Override
    public List<FournisseurCommand> findAllCommands() {
        return fcRepo.findAll();
    }

    @Override
    public FournisseurCommand addCommand(FournisseurCommand fc) {
        return fcRepo.save(fc);
    }

    @Override
    public FournisseurCommand findCommandById(Long id) {
        return fcRepo.findById(id).get();
    }

    @Override
    public FournisseurCommand updateCommand(FournisseurCommand fc, Long id) {
        fc.setId(id);
        return fcRepo.save(fc);
    }

    @Override
    public void deleteCommand(Long id) {
        fcRepo.deleteById(id);
    }

    @Override
    public List<FournisseurCommand> findCommandByEtat(String etat) {
        return fcRepo.findCommandByEtat(etat);
    }
}
