package com.selva.banking_transaction_system.Repository;
import com.selva.banking_transaction_system.Entity.Account;
import com.selva.banking_transaction_system.Entity.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankTransactionRepository
        extends JpaRepository<BankTransaction, Long> {

    List<BankTransaction> findBySenderAccountOrReceiverAccount(
            Account senderAccount,
            Account receiverAccount
    );

}