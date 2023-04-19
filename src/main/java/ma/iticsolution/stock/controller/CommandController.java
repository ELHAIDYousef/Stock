package ma.iticsolution.stock.controller;

import ma.iticsolution.stock.entities.Command;
import ma.iticsolution.stock.services.CommandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "command")
public class CommandController {

    CommandService commandService;

    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }


    @GetMapping("/{id}")
    public Command getCommandById(@PathVariable(name = "id") Long id) {
        return commandService.findCommandById(id);
    }

    @GetMapping("")
    public List<Command> getCommandByEtat(@RequestParam(name = "etat",defaultValue = "") String etat) {
        return commandService.findCommandByEtat(etat);
    }

    @PostMapping("/add-command")
    public Command addCommand(@RequestBody Command command) {
        return commandService.addCommand(command);
    }

    @PutMapping("/update-command")
    public Command updateCommand(Command command, Long id) {
        return commandService.updateCommand(command, id);
    }

    @DeleteMapping("/delete-command/{id}")
    public void deleteCommand(@PathVariable(name = "id") Long id) {
        commandService.deleteCommand(id);
    }
}
