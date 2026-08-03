package com.selva.banking_transaction_system.Service;

import com.selva.banking_transaction_system.Dto.*;
import com.selva.banking_transaction_system.Entity.Account;

public interface AccountService {

    AccountResponse createAccount(CreateAccountRequest request);

    AccountResponse deposit(DepositRequest request);

    AccountResponse withdraw(WithdrawRequest request);

    TransferResponse transfer(TransferRequest request);

}