package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.LineCommandFournisseur;
import ma.iticsolution.stock.repository.LineCommandFournisseurRepo;
import ma.iticsolution.stock.services.LCFournisseurService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LCFournisseurServiceImpl implements LCFournisseurService {

    final LineCommandFournisseurRepo lcfRepo;

    public LCFournisseurServiceImpl(LineCommandFournisseurRepo lcfRepo) {
        this.lcfRepo = lcfRepo;
    }

    @Override
    public List<LineCommandFournisseur> findAllCommands() {
        return lcfRepo.findAll();
    }

    @Override
    public LineCommandFournisseur addLineCommand(LineCommandFournisseur lcf) {
        return lcfRepo.save(lcf);
    }

    @Override
    public LineCommandFournisseur findLineCommandById(Long id) {
        return lcfRepo.findById(id).get();
    }

    @Override
    public LineCommandFournisseur updateLienCommand(LineCommandFournisseur lcf, Long id) {
        lcf.setId(id);
        return lcfRepo.save(lcf);
    }
    @Override
    public List<LineCommandFournisseur> getLineCommandsByCommand(Long id) {
        return lcfRepo.findByCommand_Id(id);
    }

    @Override
    public void deleteCommand(Long id) {
        lcfRepo.deleteById(id);
    }
}
