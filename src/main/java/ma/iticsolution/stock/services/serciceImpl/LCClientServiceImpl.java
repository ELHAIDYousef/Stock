package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.LineCommandClient;
import ma.iticsolution.stock.repository.LineCommandClientRepo;
import ma.iticsolution.stock.services.LCClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LCClientServiceImpl implements LCClientService {

    final LineCommandClientRepo lccRepo;

    public LCClientServiceImpl(LineCommandClientRepo lccRepo) {
        this.lccRepo = lccRepo;
    }

    @Override
    public List<LineCommandClient> findAllCommands() {
        return lccRepo.findAll();
    }

    @Override
    public LineCommandClient addLineCommand(LineCommandClient lcc) {
        return lccRepo.save(lcc);
    }

    @Override
    public LineCommandClient findLineCommandById(Long id) {
        return lccRepo.findById(id).get();
    }

    @Override
    public LineCommandClient updateLienCommand(LineCommandClient lcc, Long id) {
        lcc.setId(id);
        return lccRepo.save(lcc);
    }

    @Override
    public void deleteCommand(Long id) {
        lccRepo.deleteById(id);
    }
}
