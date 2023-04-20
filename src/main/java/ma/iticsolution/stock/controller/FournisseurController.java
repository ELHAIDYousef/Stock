package ma.iticsolution.stock.controller;


import ma.iticsolution.stock.entities.Fournisseur;
import ma.iticsolution.stock.services.FournisseurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/fournisseur")
public class FournisseurController {

    FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @GetMapping("/{id}")
    public Fournisseur getFournisseurById(@PathVariable(name = "id") Long id) {
        return fournisseurService.findFournisseurById(id);
    }
    @GetMapping("")
    public List<Fournisseur> getFournisseurByName(@RequestParam(name = "name",defaultValue = "") String name) {
        return fournisseurService.findFournisseurByName(name);
    }
    @PostMapping("/add-fournisseur")
    public Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.addFournisseur(fournisseur);
    }
    @PutMapping("/update-fournisseur")
    public Fournisseur updateFournisseur(Fournisseur fournisseur, Long id) {
        return fournisseurService.updateFournisseur(fournisseur, id);
    }
    @DeleteMapping("/delete-fournisseur/{id}")
    public void deleteFournisseur(@PathVariable(name = "id") Long id) {
        fournisseurService.deleteFournisseur(id);
    }
}
