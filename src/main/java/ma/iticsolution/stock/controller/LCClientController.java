package ma.iticsolution.stock.controller;

import ma.iticsolution.stock.entities.CommandClient;
import ma.iticsolution.stock.entities.LineCommandClient;
import ma.iticsolution.stock.services.LCClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client/line-command")
@CrossOrigin("*")
public class LCClientController {

    final LCClientService service;

    public LCClientController(LCClientService service) {
        this.service = service;
    }
    @PostMapping()
    public LineCommandClient addLineCommand(@RequestBody LineCommandCRequest lineCommandCRequest) {
        return service.addLineCommand(lineCommandCRequest.getLine(), lineCommandCRequest.getCommand().getId());
    }

    @GetMapping("/{id}")
    public LineCommandClient findLineCommandById(@PathVariable Long id){
        return service.findLineCommandById(id);
    }
    @PutMapping("/{id}")
    public LineCommandClient updatelineCommand(@RequestBody LineCommandClient lineCommand,@PathVariable Long id){
        return service.updateLienCommand(lineCommand,id);
    }
    @DeleteMapping("/{id}")
    public void deleteLineCommand(@PathVariable Long id){
        service.deleteCommand(id);
    }
}
class LineCommandCRequest{
    LineCommandClient line;
    CommandClient command ;



    public LineCommandCRequest(LineCommandClient line, CommandClient command) {
        this.line = line;
        this.command = command;
    }

    public LineCommandClient getLine() {
        return line;
    }



    public CommandClient getCommand() {
        return command;
    }

    public void setCommand(CommandClient command) {
        this.command = command;
    }

}