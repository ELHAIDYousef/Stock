package ma.iticsolution.stock.controller;

import ma.iticsolution.stock.entities.LineCommandFournisseur;
import ma.iticsolution.stock.services.LCFournisseurService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fournisseur/line-command")
@CrossOrigin("*")
public class LCFournisseurController {

    final LCFournisseurService service;

    public LCFournisseurController(LCFournisseurService service) {
        this.service = service;
    }
    @PostMapping
    public LineCommandFournisseur addLineCommand(@RequestBody LineCommandFournisseur lineCommand){
        return service.addLineCommand(lineCommand);
    }
    @GetMapping("/{id}")
    public LineCommandFournisseur findLineCommandById(@PathVariable Long id){
        return service.findLineCommandById(id);
    }
    @PutMapping("/{id}")
    public LineCommandFournisseur updatelineCommand(@RequestBody LineCommandFournisseur lineCommand,@PathVariable Long id){
        return service.updateLienCommand(lineCommand,id);
    }
    @DeleteMapping("/{id}")
    public void deleteLineCommand(@PathVariable Long id){
        service.deleteCommand(id);
    }
}
