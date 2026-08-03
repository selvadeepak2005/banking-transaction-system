package com.selva.banking_transaction_system.Controller;

import com.selva.banking_transaction_system.Dto.*;
import com.selva.banking_transaction_system.Service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(
            @Valid @RequestBody CreateAccountRequest request) {

        AccountResponse response = accountService.createAccount(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/deposit")
    public ResponseEntity<AccountResponse> deposit(
            @Valid @RequestBody DepositRequest request){

        AccountResponse response = accountService.deposit(request);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/withdraw")
    public ResponseEntity<AccountResponse> withdraw(
            @Valid @RequestBody WithdrawRequest request){

        AccountResponse response = accountService.withdraw(request);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/transfer")
    public ResponseEntity<TransferResponse> transfer(
            @Valid @RequestBody TransferRequest request){

        TransferResponse response = accountService.transfer(request);

        return ResponseEntity.ok(response);
    }
}