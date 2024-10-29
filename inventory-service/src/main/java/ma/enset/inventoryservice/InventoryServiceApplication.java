package ma.enset.inventoryservice;

import ma.enset.inventoryservice.entities.Product;
import ma.enset.inventoryservice.repos.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(
			ProductRepository productRepository
	) {
		return args -> {
			List<String> ITProducts = List.of("Laptop", "Desktop", "Printer", "Scanner", "Router", "Switch", "Firewall", "Access Point", "Server", "Storage");

			ITProducts.forEach(product -> {
				productRepository
						.save(Product.builder()
						.name(product)
						.price(Math.random() * 10000)
						.quantity(
								Math.random() * 100
						)
						.build());
			});
		};
	}

}
