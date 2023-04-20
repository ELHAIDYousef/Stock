package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.FactureFournisseur;
import ma.iticsolution.stock.repository.FactureFournisseurRepo;
import ma.iticsolution.stock.services.FactureFournisseurService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FactureFournisseurServiceImpl implements FactureFournisseurService {
    final FactureFournisseurRepo service;

    public FactureFournisseurServiceImpl(FactureFournisseurRepo service) {
        this.service = service;
    }

    @Override
    public List<FactureFournisseur> findAllFactures() {
        return service.findAll();
    }

    @Override
    public List<FactureFournisseur> findAllFacturesFournisseur(Long id) {
        return service.findByCommand_Fournisseur_Id(id);
    }

    @Override
    public FactureFournisseur addFacture(FactureFournisseur ff) {
        return service.save(ff);
    }

    @Override
    public FactureFournisseur findFactureById(Long id) {
        return service.findById(id).get();
    }

    @Override
    public FactureFournisseur updateFacture(FactureFournisseur ff, Long id) {
        ff.setId(id);
        return service.save(ff);
    }

    @Override
    public void deleteFacture(Long id) {
        service.deleteById(id);
    }
}
