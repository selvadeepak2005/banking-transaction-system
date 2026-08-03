package com.selva.banking_transaction_system.Dto;

import com.selva.banking_transaction_system.Enum.AccountType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAccountRequest {

    private Long customerId;

    private AccountType accountType;

}