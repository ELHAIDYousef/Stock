package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.LineCommandFournisseur;


public interface LCFournisseurService {
    LineCommandFournisseur addLineCommand(LineCommandFournisseur lcf);
    LineCommandFournisseur findLineCommandById(Long id);
    LineCommandFournisseur updateLienCommand(LineCommandFournisseur lcf , Long id);
    void deleteCommand(Long id);
}
