package ma.iticsolution.stock.controller;


import ma.iticsolution.stock.entities.Fournisseur;
import ma.iticsolution.stock.services.FournisseurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/fournisseur")
public class FournisseurController {

    FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @GetMapping("/{id}")
    public Fournisseur getFournisseurById(@PathVariable(name = "id") Long id) {
        return fournisseurService.findFournisseurById(id);
    }
    @GetMapping
    public List<Fournisseur> getFournisseurByName(@RequestParam(name = "name",defaultValue = "") String name) {
        return fournisseurService.findFournisseurByName(name);
    }
    @PostMapping
    public Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.addFournisseur(fournisseur);
    }
    @PutMapping("/{id}")
    public Fournisseur updateFournisseur(@RequestBody Fournisseur fournisseur,@PathVariable Long id) {
        return fournisseurService.updateFournisseur(fournisseur, id);
    }
    @DeleteMapping("/{id}")
    public void deleteFournisseur(@PathVariable(name = "id") Long id) {
        fournisseurService.deleteFournisseur(id);
    }
}
