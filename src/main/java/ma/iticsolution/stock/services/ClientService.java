package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.Client;

import java.util.List;


public interface ClientService {

    //List<Client> findAllClients();
    Client addClient(Client c);
    Client findClientById(Long id);
    Client updateClient(Client c , Long id);
    void deleteClient(Long id);
    List<Client> findClientByName(String name);

}
