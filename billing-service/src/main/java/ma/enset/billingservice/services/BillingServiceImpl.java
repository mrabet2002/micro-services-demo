package ma.enset.billingservice.services;

import lombok.RequiredArgsConstructor;
import ma.enset.billingservice.dtos.BillResponseDto;
import ma.enset.billingservice.entities.Bill;
import ma.enset.billingservice.entities.ProductItem;
import ma.enset.billingservice.feign.CustomerRestClient;
import ma.enset.billingservice.feign.ProductRestClient;
import ma.enset.billingservice.mappers.BillMapper;
import ma.enset.billingservice.models.Customer;
import ma.enset.billingservice.models.Product;
import ma.enset.billingservice.repos.BillRepository;
import ma.enset.billingservice.repos.ProductItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillingServiceImpl implements BillingService{
    private final BillRepository billRepository;
    private final ProductItemRepository productItemRepository;
    private final CustomerRestClient customerRestClient;
    private final ProductRestClient productRestClient;


    @Override
    public Bill makeOrder(Long customerId, Bill bill) {
        Customer customer = customerRestClient.getCustomerById(customerId);
        bill.setCustomerId(customerId);
        bill.getProductItems().forEach(productItem -> {
            Product product = productRestClient.getProductById(productItem.getProductId());
            productItem.setProductId(product.getId());
            productItem.setPrice(product.getPrice() * productItem.getQuantity());
            productItem.setBill(null);

            productItemRepository.save(productItem);
        });

        return billRepository.save(bill);
    }

    @Override
    public List<BillResponseDto> findBillsByCustomerId(Long customerId) {
        List<Bill> bills = billRepository.findByCustomerId(customerId);
        return BillMapper.toDto(bills);
    }

    @Override
    public List<ProductItem> getBillProductItems(Long billId) {
        List<ProductItem> productItems = productItemRepository.findByBillId(billId);
        productItems.forEach(productItem -> {
            Product product = productRestClient.getProductById(productItem.getProductId());
            productItem.setProduct(product);
            productItem.setBill(null);
        });

        return productItems;
    }


}
