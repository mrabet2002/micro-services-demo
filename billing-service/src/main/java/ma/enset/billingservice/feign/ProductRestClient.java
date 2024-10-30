package ma.enset.billingservice.feign;

import ma.enset.billingservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {
    @GetMapping("/products")
    Page<Product> getProducts(
            @RequestParam(name = "page") int page,
            @RequestParam(name = "size") int size
    );

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable Long id);
}
