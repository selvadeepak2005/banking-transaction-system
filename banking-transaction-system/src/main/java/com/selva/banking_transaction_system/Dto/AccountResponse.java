package com.selva.banking_transaction_system.Dto;
import com.selva.banking_transaction_system.Enum.AccountStatus;
import com.selva.banking_transaction_system.Enum.AccountType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountResponse {

    private Long accountNumber;

    private AccountType accountType;

    private BigDecimal balance;

    private AccountStatus accountStatus;

    private Long customerId;

}