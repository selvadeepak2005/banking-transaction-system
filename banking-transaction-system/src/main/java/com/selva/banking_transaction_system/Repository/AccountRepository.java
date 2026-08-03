package com.selva.banking_transaction_system.Repository;

import com.selva.banking_transaction_system.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}