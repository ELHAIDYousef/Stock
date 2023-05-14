package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.LineCommandClient;
import ma.iticsolution.stock.repository.ClientCommandRepo;
import ma.iticsolution.stock.repository.LineCommandClientRepo;
import ma.iticsolution.stock.services.LCClientService;
import org.springframework.stereotype.Service;


@Service
public class LCClientServiceImpl implements LCClientService {

    final LineCommandClientRepo lccRepo;
    final ClientCommandRepo ccRepo;

    public LCClientServiceImpl(LineCommandClientRepo lccRepo, ClientCommandRepo ccRepo) {
        this.lccRepo = lccRepo;
        this.ccRepo = ccRepo;
    }


    @Override
    public LineCommandClient addLineCommand(LineCommandClient lcc, Long commandId) {
        lcc.setCommand(ccRepo.findById(commandId).get());
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
