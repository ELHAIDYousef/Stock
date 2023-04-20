package ma.iticsolution.stock.controller;

import ma.iticsolution.stock.entities.ClientCommand;
import ma.iticsolution.stock.services.ClientCommandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/client/command")
public class ClientCommandController {

    ClientCommandService ccService;

    public ClientCommandController(ClientCommandService ccService) {
        this.ccService = ccService;
    }


    @GetMapping("/{id}")
    public ClientCommand getCommandById(@PathVariable(name = "id") Long id) {
        return ccService.findCommandById(id);
    }
    @GetMapping("get-all")
    public List<ClientCommand> getAllCommands(){
        return ccService.findAllCommands();
    }

    @GetMapping("/get-by-etat")
    public List<ClientCommand> getCommandByEtat(@RequestParam(name = "etat",defaultValue = "") String etat) {
        return ccService.findCommandByEtat(etat);
    }

    @PostMapping("/add-command")
    public ClientCommand addCommand(@RequestBody ClientCommand cc) {
        return ccService.addCommand(cc);
    }

    @PutMapping("/update-command")
    public ClientCommand updateCommand(ClientCommand cc, Long id) {
        return ccService.updateCommand(cc, id);
    }

    @DeleteMapping("/delete-command/{id}")
    public void deleteCommand(@PathVariable(name = "id") Long id) {
        ccService.deleteCommand(id);
    }
}
