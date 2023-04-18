package ma.iticsolution.stock;

import ma.iticsolution.stock.entities.Actor;
import ma.iticsolution.stock.entities.Client;
import ma.iticsolution.stock.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockApplication implements CommandLineRunner {

	final ClientService client;
	public StockApplication(ClientService client) {
		this.client = client;
	}

	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		client.addClient(new Actor(null,"AAAA","addressAA","telA","mailA","postalAAA"));
		client.addClient(new Actor(null,"BBBB","addressBB","telB","mailB","postalBBB"));
		client.addClient(new Actor(null,"BBBB","addressCC","telC","mailC","postalCCC"));
		client.addClient(new Actor(null,"BBBB","addressDD","telD","mailD","postalDDD"));


	}
}
