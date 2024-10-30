package ma.enset.billingservice.mappers;

import ma.enset.billingservice.dtos.BillResponseDto;
import ma.enset.billingservice.entities.Bill;

import java.util.List;
import java.util.stream.Collectors;

public class BillMapper {
    public static BillResponseDto toDto(Bill bill) {
        return BillResponseDto.builder()
                .id(bill.getId())
                .createdAt(bill.getCreatedAt())
                .customer(bill.getCustomer())
                .build();
    }

    public static List<BillResponseDto> toDto(List<Bill> bills) {
        return bills.stream().map(BillMapper::toDto).collect(Collectors.toList());
    }
}
