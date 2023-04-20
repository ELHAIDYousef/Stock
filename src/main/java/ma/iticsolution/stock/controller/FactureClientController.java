package ma.iticsolution.stock.controller;

import ma.iticsolution.stock.entities.FactureClient;
import ma.iticsolution.stock.services.FactureClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/facture")
public class FactureClientController {
    final FactureClientService service;

    public FactureClientController(FactureClientService service) {
        this.service = service;
    }
    @GetMapping("")
    public List<FactureClient> findAllFactures(){
        return service.findAllFactures();
    }
    @GetMapping("/{id}")
    public FactureClient findById(@PathVariable Long id){
        return service.findFactureById(id);
    }
    @PostMapping("/add-facture")
    public FactureClient addFacture(@RequestBody FactureClient facture){
        return service.addFacture(facture);
    }
    @PutMapping("/update-facture")
    public FactureClient updateFacture(@RequestBody FactureClient facture,Long id){
        return service.updateFacture(facture,id);
    }
    @DeleteMapping("/delete-facture/{id}")
    public void deleteFacture(@PathVariable Long id){
        service.deleteFacture(id);
    }
}
