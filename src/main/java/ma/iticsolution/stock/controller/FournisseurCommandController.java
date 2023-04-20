package ma.iticsolution.stock.controller;

import ma.iticsolution.stock.entities.Command;
import ma.iticsolution.stock.entities.FournisseurCommand;
import ma.iticsolution.stock.services.FournisseurCommandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/fournisseur/command")
public class FournisseurCommandController {

    FournisseurCommandService fcService;

    public FournisseurCommandController(FournisseurCommandService fcService) {
        this.fcService = fcService;
    }


    @GetMapping("/{id}")
    public FournisseurCommand getCommandById(@PathVariable(name = "id") Long id) {
        return fcService.findCommandById(id);
    }
    @GetMapping("")
    public List<FournisseurCommand> getAllCommands() {
        return fcService.findAllCommands();
    }
    @GetMapping("/get-by-etat")
    public List<FournisseurCommand> getCommandByEtat(@RequestParam(name = "etat",defaultValue = "") String etat) {
        return fcService.findCommandByEtat(etat);
    }

    @PostMapping("/add-command")
    public Command addCommand(@RequestBody FournisseurCommand fc) {
        return fcService.addCommand(fc);
    }

    @PutMapping("/update-command")
    public Command updateCommand(FournisseurCommand fc, Long id) {
        return fcService.updateCommand(fc, id);
    }

    @DeleteMapping("/delete-command/{id}")
    public void deleteCommand(@PathVariable(name = "id") Long id) {
        fcService.deleteCommand(id);
    }
}
