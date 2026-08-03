package com.selva.banking_transaction_system.Dto;


import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferResponse {

    private String message;

    private Long senderAccount;

    private Long receiverAccount;

    private BigDecimal amount;

    private LocalDateTime transactionTime;

}