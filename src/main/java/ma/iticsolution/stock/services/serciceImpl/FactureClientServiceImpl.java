package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.FactureClient;
import ma.iticsolution.stock.repository.FactureClientRepo;
import ma.iticsolution.stock.services.FactureClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureClientServiceImpl implements FactureClientService {
    final FactureClientRepo service;

    public FactureClientServiceImpl(FactureClientRepo service) {
        this.service = service;
    }

    @Override
    public List<FactureClient> findAllFactures() {
        return service.findAll();
    }

    @Override
    public List<FactureClient> findAllFacturesClient(Long id) {
        return service.findByCommand_Client_Id(id);
    }

    @Override
    public FactureClient addFacture(FactureClient ff) {
        return service.save(ff);
    }

    @Override
    public FactureClient findFactureById(Long id) {
        return service.findById(id).get();
    }

    @Override
    public FactureClient updateFacture(FactureClient ff, Long id) {
        ff.setId(id);
        return service.save(ff);
    }

    @Override
    public void deleteFacture(Long id) {
        service.deleteById(id);
    }

    @Override
    public FactureClient getLatestFactureClient() {
        return service.findLatestFactureClient();
    }
}
