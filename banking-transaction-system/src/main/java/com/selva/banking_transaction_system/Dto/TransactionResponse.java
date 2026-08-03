package com.selva.banking_transaction_system.Dto;

import com.selva.banking_transaction_system.Enum.TransactionStatus;
import com.selva.banking_transaction_system.Enum.TransactionType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponse {

    private Long transactionId;

    private TransactionType transactionType;

    private BigDecimal amount;

    private LocalDateTime transactionDate;

    private TransactionStatus transactionStatus;

    private Long senderAccount;

    private Long receiverAccount;

    private String remarks;
}