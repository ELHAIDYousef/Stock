package ma.iticsolution.stock.controller;

import ma.iticsolution.stock.entities.Command;
import ma.iticsolution.stock.entities.CommandFournisseur;
import ma.iticsolution.stock.services.FournisseurCommandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/fournisseur/command")
public class FournisseurCommandController {

    FournisseurCommandService fcService;

    public FournisseurCommandController(FournisseurCommandService fcService) {
        this.fcService = fcService;
    }


    @GetMapping("/{id}")
    public CommandFournisseur getCommandById(@PathVariable(name = "id") Long id) {
        return fcService.findCommandById(id);
    }
    @GetMapping
    public List<CommandFournisseur> getAllCommands() {
        return fcService.findAllCommands();
    }
    @GetMapping("/get-by-etat")
    public List<CommandFournisseur> getCommandByEtat(@RequestParam(name = "etat",defaultValue = "") String etat) {
        return fcService.findCommandByEtat(etat);
    }

    @PostMapping
    public Command addCommand(@RequestBody CommandFournisseur fc) {
        return fcService.addCommand(fc);
    }

    @PutMapping("/{id}")
    public Command updateCommand(@RequestBody CommandFournisseur fc, @PathVariable Long id) {
        return fcService.updateCommand(fc, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCommand(@PathVariable(name = "id") Long id) {
        fcService.deleteCommand(id);
    }
}
