package ma.iticsolution.stock.controller;

import ma.iticsolution.stock.entities.LineCommandClient;
import ma.iticsolution.stock.services.LCClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client/command")
public class LCClientController {

    final LCClientService service;

    public LCClientController(LCClientService service) {
        this.service = service;
    }
    @PostMapping("/add-line-command")
    public LineCommandClient addLineCommand(@RequestBody LineCommandClient lineCommand){
        return service.addLineCommand(lineCommand);
    }
    @GetMapping("/line-command/{id}")
    public LineCommandClient findLineCommandById(@PathVariable Long id){
        return service.findLineCommandById(id);
    }
    @PutMapping("/update-line-command/{id}")
    public LineCommandClient updatelineCommand(@RequestBody LineCommandClient lineCommand,@PathVariable Long id){
        return service.updateLienCommand(lineCommand,id);
    }
    @DeleteMapping("/delete-line-command/{id}")
    public void deleteLineCommand(@PathVariable Long id){
        service.deleteCommand(id);
    }
}
