package ma.iticsolution.stock.services;


import ma.iticsolution.stock.entities.Fournisseur;

import java.util.List;


public interface FournisseurService {

    //List<Fournisseur> findAllFournisseurs();
    Fournisseur addFournisseur(Fournisseur c);
    Fournisseur findFournisseurById(Long id);
    Fournisseur updateFournisseur(Fournisseur c , Long id);
    void deleteFournisseur(Long id);
    List<Fournisseur> findFournisseurByName(String name);

}
