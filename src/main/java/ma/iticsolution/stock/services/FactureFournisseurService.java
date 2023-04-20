package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.FactureFournisseur;

import java.util.List;


public interface FactureFournisseurService {

    List<FactureFournisseur> findAllFactures();
    List<FactureFournisseur> findAllFacturesFournisseur(Long id);
    FactureFournisseur addFacture(FactureFournisseur ff);
    FactureFournisseur findFactureById(Long id);
    FactureFournisseur updateFacture(FactureFournisseur ff , Long id);
    void deleteFacture(Long id);

}
