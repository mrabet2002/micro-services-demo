package ma.enset.billingservice.repos;

import ma.enset.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
    List<ProductItemRepository> findByBillId(Long billId);
}
