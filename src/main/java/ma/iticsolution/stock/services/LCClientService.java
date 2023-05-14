package ma.iticsolution.stock.services;


import ma.iticsolution.stock.entities.LineCommandClient;


public interface LCClientService {
    LineCommandClient addLineCommand(LineCommandClient lcc, Long commandId);
    LineCommandClient findLineCommandById(Long id);
    LineCommandClient updateLienCommand(LineCommandClient lcc , Long id);
    void deleteCommand(Long id);
}
