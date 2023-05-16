package ma.iticsolution.stock.controller;

import ma.iticsolution.stock.entities.FactureClient;
import ma.iticsolution.stock.services.FactureClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public String getLatestFactureClient() {
        FactureClient latestFactureClient = service.getLatestFactureClient();
        if (latestFactureClient != null && latestFactureClient.getCodeFacture() != null) {
            return latestFactureClient.getCodeFacture();
        } else {
            return "0000";
        }
    }

    @GetMapping("/{id}")
    public FactureClient findById(@PathVariable Long id){
        return service.findFactureById(id);
    }
    @PostMapping
    public FactureClient addFacture(@RequestBody FactureClient facture){
        return service.addFacture(facture);
    }
    @PutMapping("/{id}")
    public FactureClient updateFacture(@RequestBody FactureClient facture,@PathVariable Long id){
        return service.updateFacture(facture,id);
    }
    @DeleteMapping("/{id}")
    public void deleteFacture(@PathVariable Long id){
        service.deleteFacture(id);
    }
}
