package ma.iticsolution.stock.controller;

import ma.iticsolution.stock.entities.FactureClient;
import ma.iticsolution.stock.services.FactureClientService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/client/facture")
@CrossOrigin("*")
public class FactureClientController {
    final FactureClientService service;

    public FactureClientController(FactureClientService service) {
        this.service = service;
    }
    @GetMapping
    public List<FactureClient> findAllFactures(){
        return service.findAllFactures();
    }
    @GetMapping("/latest")
    public FactureClient getLatestFactureClient() {
        FactureClient latestFactureClient = service.getLatestFactureClient();
        return latestFactureClient;
    }

    @GetMapping("/{id}")
    public FactureClient findById(@PathVariable Long id){
        return service.findFactureById(id);
    }
    @PostMapping("/{id}")
    public FactureClient addFacture(@RequestBody FactureClient facture , @PathVariable Long id){
        return service.addFacture(facture,id);
    }
    @PutMapping("/{id}")
    public FactureClient updateFacture(@RequestBody FactureClient facture,@PathVariable Long id){
        return service.updateFacture(facture,id);
    }
    @DeleteMapping("/{id}")
    public void deleteFacture(@PathVariable Long id){
        service.deleteFacture(id);
    }

    @GetMapping("/report/{id}")
    public ResponseEntity<byte[]> generateReport(@PathVariable Long id) throws FileNotFoundException, JRException {
        return service.generateReport(id);
    }
}
