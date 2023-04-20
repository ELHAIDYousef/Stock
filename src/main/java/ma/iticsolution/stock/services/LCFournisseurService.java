package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.LineCommandFournisseur;

import java.util.List;

public interface LCFournisseurService {
    List<LineCommandFournisseur> findAllCommands();
    LineCommandFournisseur addLineCommand(LineCommandFournisseur lcf);
    LineCommandFournisseur findLineCommandById(Long id);
    LineCommandFournisseur updateLienCommand(LineCommandFournisseur lcf , Long id);
    List<LineCommandFournisseur> getLineCommandsByCommand(Long id);
    void deleteCommand(Long id);
}
