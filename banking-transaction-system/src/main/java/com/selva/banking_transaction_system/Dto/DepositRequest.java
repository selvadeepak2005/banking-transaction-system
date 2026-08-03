package com.selva.banking_transaction_system.Dto;


import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepositRequest {

    private Long accountNumber;

    @Positive(message = "Amount must be greater than zero")
    private BigDecimal amount;

}