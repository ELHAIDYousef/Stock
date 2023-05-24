package ma.iticsolution.stock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@SpringBootApplication
@ComponentScan({ "ma.iticsolution.stock.security", "ma.iticsolution.stock.security"})
public class StockApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		var userDetailsService =
				new InMemoryUserDetailsManager();

		var user = User.withUsername("admin")
				.password("1234")
				.authorities("ADMIN")
				.build();

		userDetailsService.createUser(user);

		return userDetailsService;
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
