package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.Actor;
import ma.iticsolution.stock.entities.Fournisseur;

import java.util.List;


public interface FournisseurService {

    //public List<Fournisseur> findAllFournisseurs();
    public Fournisseur addFournisseur(Fournisseur c);
    public Fournisseur findFournisseurById(Long id);
    public Fournisseur updateFournisseur(Fournisseur c , Long id);
    public void deleteFournisseur(Long id);
    public List<Fournisseur> findFournisseurByName(String name);

}
