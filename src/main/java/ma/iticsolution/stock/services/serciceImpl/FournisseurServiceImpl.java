package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.Actor;
import ma.iticsolution.stock.entities.Client;
import ma.iticsolution.stock.entities.Fournisseur;
import ma.iticsolution.stock.repository.ClientRepo;
import ma.iticsolution.stock.repository.FournisseurRepo;
import ma.iticsolution.stock.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    FournisseurRepo fournisseurRepo;

    public FournisseurServiceImpl(FournisseurRepo fournisseurRepo) {
        this.fournisseurRepo = fournisseurRepo;
    }


    @Override
    public Fournisseur addFournisseur(Fournisseur c) {
        return fournisseurRepo.save(c);
    }

    @Override
    public Fournisseur findFournisseurById(Long id) {
        return fournisseurRepo.findById(id).get();
    }


    @Override
    public Fournisseur updateFournisseur(Fournisseur c, Long id) {
        c.setId(id);
        return fournisseurRepo.save(c);
    }

    @Override
    public void deleteFournisseur(Long id) {
        fournisseurRepo.deleteById(id);
    }

    @Override
    public List<Fournisseur> findFournisseurByName(String name) {
        return fournisseurRepo.findFournisseurByNameContains(name);
    }
}
