package ma.enset.billingservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ma.enset.billingservice.entities.ProductItem;
import ma.enset.billingservice.models.Customer;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BillResponseDto {
    private Long id;
    private LocalDateTime createdAt;
    private Customer customer;
}
