package ma.enset.billingservice;

import ma.enset.billingservice.feign.CustomerRestClient;
import ma.enset.billingservice.feign.ProductRestClient;
import ma.enset.billingservice.models.Customer;
import ma.enset.billingservice.repos.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            BillingServiceApplication billingServiceApplication,
            ProductItemRepository productItemRepository,
            CustomerRestClient customerRestClient,
            ProductRestClient productRestClient
    ) {
        return args -> {
           Customer customer = customerRestClient.getCustomerById(1L);
            System.out.println("*******************");
            System.out.println("Customer info: ");
            System.out.println("ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("*******************");
        };
    }
}
