package com.selva.banking_transaction_system.Service;
import com.selva.banking_transaction_system.Dto.TransactionResponse;
import com.selva.banking_transaction_system.Entity.Account;
import com.selva.banking_transaction_system.Entity.BankTransaction;

import java.math.BigDecimal;
import java.util.List;

public interface BankTransactionService {
    void saveDepositTransaction(Account account, BigDecimal amount);

    void saveWithdrawTransaction(Account account, BigDecimal amount);

    void saveTransferTransaction(Account sender,
                                 Account receiver,
                                 BigDecimal amount);

    List<TransactionResponse> getTransactionHistory(Long accountNumber);

}