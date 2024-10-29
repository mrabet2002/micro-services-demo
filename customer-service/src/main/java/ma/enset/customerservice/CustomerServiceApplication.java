package ma.enset.customerservice;

import ma.enset.customerservice.entities.Customer;
import ma.enset.customerservice.repos.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            CustomerRepository customerRepository
    ) {
        return args -> {
            List<String> names = List.of("Amine", "Mohamed", "Hassan", "Yassine");

            names.forEach(name -> {
                customerRepository.save(Customer.builder().name(name).email(name + "@gmail.com").build());
            });

        };
    }
}
