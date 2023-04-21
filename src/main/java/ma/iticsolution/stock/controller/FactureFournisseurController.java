package ma.iticsolution.stock.controller;

import ma.iticsolution.stock.entities.FactureFournisseur;
import ma.iticsolution.stock.services.FactureFournisseurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseur/facture")
public class FactureFournisseurController {
    final FactureFournisseurService service;

    public FactureFournisseurController(FactureFournisseurService service) {
        this.service = service;
    }
    @GetMapping("")
    public List<FactureFournisseur> findAllFactures(){
        return service.findAllFactures();
    }
    @GetMapping("/{id}")
    public FactureFournisseur findById(@PathVariable Long id){
        return service.findFactureById(id);
    }
    @PostMapping("/add-facture")
    public FactureFournisseur addFacture(@RequestBody FactureFournisseur facture){
        return service.addFacture(facture);
    }
    @PutMapping("/update-facture/{id}")
    public FactureFournisseur updateFacture(@RequestBody FactureFournisseur facture,@PathVariable Long id){
        return service.updateFacture(facture,id);
    }
    @DeleteMapping("/delete-facture/{id}")
    public void deleteFacture(@PathVariable Long id){
        service.deleteFacture(id);
    }
}
