package ma.iticsolution.stock.controller;

import ma.iticsolution.stock.entities.CommandClient;
import ma.iticsolution.stock.services.ClientCommandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/client/command")
@CrossOrigin("*")
public class ClientCommandController {

    ClientCommandService ccService;

    public ClientCommandController(ClientCommandService ccService) {
        this.ccService = ccService;
    }


    @GetMapping("/{id}")
    public CommandClient getCommandById(@PathVariable(name = "id") Long id) {
        return ccService.findCommandById(id);
    }
    @GetMapping
    public List<CommandClient> getAllCommands(){
        return ccService.findAllCommands();
    }

    @GetMapping("/get-by-etat")
    public List<CommandClient> getCommandByEtat(@RequestParam(name = "etat",defaultValue = "") String etat) {
        return ccService.findCommandByEtat(etat);
    }

    @PostMapping
    public CommandClient addCommand(@RequestBody CommandClient cc) {
        return ccService.addCommand(cc);
    }

    @PutMapping("/{id}")
    public CommandClient updateCommand(@RequestBody CommandClient cc, @PathVariable Long id) {
        return ccService.updateCommand(cc, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCommand(@PathVariable(name = "id") Long id) {
        ccService.deleteCommand(id);
    }
}
