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



	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}
}
