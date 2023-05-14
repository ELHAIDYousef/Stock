package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.LineCommandFournisseur;
import ma.iticsolution.stock.repository.FournisseurCommandRepo;
import ma.iticsolution.stock.repository.LineCommandFournisseurRepo;
import ma.iticsolution.stock.services.LCFournisseurService;
import org.springframework.stereotype.Service;

@Service
public class LCFournisseurServiceImpl implements LCFournisseurService {

    final LineCommandFournisseurRepo lcfRepo;
    final FournisseurCommandRepo fcRepo;

    public LCFournisseurServiceImpl(LineCommandFournisseurRepo lcfRepo, FournisseurCommandRepo fcRepo) {
        this.lcfRepo = lcfRepo;
        this.fcRepo = fcRepo;
    }

    @Override
    public LineCommandFournisseur addLineCommand(LineCommandFournisseur lcf , Long commandId) {
        lcf.setCommand(fcRepo.findById(commandId).get());
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
    public void deleteCommand(Long id) {
        lcfRepo.deleteById(id);
    }
}
