package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.FactureClient;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.util.List;


public interface FactureClientService {

    List<FactureClient> findAllFactures();
    FactureClient addFacture(FactureClient fc,Long id);
    List<FactureClient> findAllFacturesClient(Long id);
    FactureClient findFactureById(Long id);
    FactureClient updateFacture(FactureClient fc , Long id);
    void deleteFacture(Long id);

    FactureClient getLatestFactureClient();

    ResponseEntity<byte[]> generateReport(Long id) throws FileNotFoundException, JRException;
}
