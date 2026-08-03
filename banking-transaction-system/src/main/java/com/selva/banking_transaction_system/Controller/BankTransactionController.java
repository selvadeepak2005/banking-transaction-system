package com.selva.banking_transaction_system.Controller;
import com.selva.banking_transaction_system.Dto.TransactionResponse;
import com.selva.banking_transaction_system.Service.BankTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class BankTransactionController {

    private final BankTransactionService bankTransactionService;

    @GetMapping("/{accountNumber}")
    public List<TransactionResponse> getTransactionHistory(
            @PathVariable Long accountNumber){

        return bankTransactionService
                .getTransactionHistory(accountNumber);
    }

}