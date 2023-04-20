package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.LineCommandClient;

import java.util.List;

public interface LCClientService {
    List<LineCommandClient> findAllCommands();
    LineCommandClient addLineCommand(LineCommandClient lcc);
    LineCommandClient findLineCommandById(Long id);
    LineCommandClient updateLienCommand(LineCommandClient lcc , Long id);
    void deleteCommand(Long id);
}
