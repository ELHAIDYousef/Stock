package ma.iticsolution.stock.controller;


import ma.iticsolution.stock.entities.CommandFournisseur;
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
    public LineCommandFournisseur addLineCommand(@RequestBody LineCommandFRequest lineCommandFRequest){
        return service.addLineCommand(lineCommandFRequest.getLine(), lineCommandFRequest.getCommand().getId());
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
class LineCommandFRequest {
    LineCommandFournisseur line;
    CommandFournisseur command ;



    public LineCommandFRequest(LineCommandFournisseur line, CommandFournisseur command) {
        this.line = line;
        this.command = command;
    }

    public LineCommandFournisseur getLine() {
        return line;
    }

    public CommandFournisseur getCommand() {
        return command;
    }

    public void setCommand(CommandFournisseur command) {
        this.command = command;
    }
}
