package ma.iticsolution.stock.services.serciceImpl;

import ma.iticsolution.stock.entities.Actor;
import ma.iticsolution.stock.entities.Client;
import ma.iticsolution.stock.repository.ClientRepo;
import ma.iticsolution.stock.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
    final ClientRepo clientRepo;

    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }


    @Override
    public Client addClient(Client c) {
        return clientRepo.save(c);
    }



    @Override
    public Client findClientById(Long id) {
        return clientRepo.findById(id).get();
    }


    @Override
    public Client updateClient(Client c, Long id) {
        c.setId(id);
        return clientRepo.save(c);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }

    @Override
    public List<Client> findClientByName(String name) {
        return clientRepo.findClientByNameContains(name);
    }
}
