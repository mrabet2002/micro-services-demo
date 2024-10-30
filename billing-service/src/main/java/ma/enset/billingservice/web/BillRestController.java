package ma.enset.billingservice.web;

import lombok.RequiredArgsConstructor;
import ma.enset.billingservice.entities.Bill;
import ma.enset.billingservice.services.BillingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillRestController {
    private final BillingService billingService;

    @PostMapping("/customer/{customerId}")
    public ResponseEntity<Bill> save(
            @PathVariable Long customerId,
            @RequestBody Bill bill
    ){
        return ResponseEntity.ok(billingService.makeOrder(customerId, bill));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getBillsByCustomerId(@PathVariable Long customerId){
        return ResponseEntity.ok(billingService.findBillsByCustomerId(customerId));
    }

    @GetMapping("/{billId}")
    public ResponseEntity<?> getBillProductItems(@PathVariable Long billId){
        return ResponseEntity.ok(billingService.getBillProductItems(billId));
    }
}
