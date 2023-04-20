package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.FactureClient;

import java.util.List;


public interface FactureClientService {

    List<FactureClient> findAllFactures();
    FactureClient addFacture(FactureClient fc);
    List<FactureClient> findAllFacturesClient(Long id);
    FactureClient findFactureById(Long id);
    FactureClient updateFacture(FactureClient fc , Long id);
    void deleteFacture(Long id);

}
