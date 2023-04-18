package ma.iticsolution.stock.services;

import ma.iticsolution.stock.entities.Actor;
import ma.iticsolution.stock.entities.Client;

import java.util.List;


public interface ClientService {

    //public List<Client> findAllClients();
    public Client addClient(Client c);
    public Client findClientById(Long id);
    public Client updateClient(Client c , Long id);
    public void deleteClient(Long id);
    public List<Client> findClientByName(String name);

}
