package ma.iticsolution.stock.controller;

import ma.iticsolution.stock.entities.Client;
import ma.iticsolution.stock.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "client")
public class ClientController {

    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /*@GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }*/

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable(name = "id") Long id) {
        return clientService.findClientById(id);
    }

    @GetMapping("")
    public List<Client> getClientByName(@RequestParam(name = "name",defaultValue = "") String name) {
        return clientService.findClientByName(name);
    }

    @PostMapping("/add-client")
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PutMapping("/update-client")
    public Client updateClient(Client client, Long id) {
        return clientService.updateClient(client, id);
    }

    @DeleteMapping("/delete-client/{id}")
    public void deleteClient(@PathVariable(name = "id") Long id) {
        clientService.deleteClient(id);
    }
}
