package ma.enset.billingservice.services;

import ma.enset.billingservice.dtos.BillResponseDto;
import ma.enset.billingservice.entities.Bill;
import ma.enset.billingservice.entities.ProductItem;

import java.util.List;

public interface BillingService {
    Bill makeOrder(Long customerId, Bill bill);

    List<BillResponseDto> findBillsByCustomerId(Long customerId);

    List<ProductItem> getBillProductItems(Long billId);


}
