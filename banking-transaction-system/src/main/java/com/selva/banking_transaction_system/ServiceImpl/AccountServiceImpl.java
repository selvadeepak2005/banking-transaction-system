package com.selva.banking_transaction_system.ServiceImpl;
import com.selva.banking_transaction_system.Dto.*;
import com.selva.banking_transaction_system.Entity.Account;
import com.selva.banking_transaction_system.Entity.Customer;
import com.selva.banking_transaction_system.Enum.AccountStatus;
import com.selva.banking_transaction_system.Exception.InsufficientBalanceException;
import com.selva.banking_transaction_system.Exception.ResourceNotFoundException;
import com.selva.banking_transaction_system.Exception.SameAccountTransferException;
import com.selva.banking_transaction_system.Repository.AccountRepository;
import com.selva.banking_transaction_system.Repository.CustomerRepository;
import com.selva.banking_transaction_system.Service.AccountService;
import com.selva.banking_transaction_system.Service.BankTransactionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final BankTransactionService bankTransactionService;

    @Override
    public AccountResponse createAccount(CreateAccountRequest request) {

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Customer not found with id : " + request.getCustomerId()));

        Account account = Account.builder()
                .accountType(request.getAccountType())
                .balance(BigDecimal.ZERO)
                .accountStatus(AccountStatus.ACTIVE)
                .customer(customer)
                .build();

        Account savedAccount = accountRepository.save(account);

        return AccountResponse.builder()
                .accountNumber(savedAccount.getAccountNumber())
                .accountType(savedAccount.getAccountType())
                .balance(savedAccount.getBalance())
                .accountStatus(savedAccount.getAccountStatus())
                .customerId(savedAccount.getCustomer().getCustomerId())
                .build();
    }

    @Override
    @Transactional
    public AccountResponse deposit(DepositRequest request) {

        Account account = accountRepository.findById(request.getAccountNumber())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Account not found with account number : "
                                + request.getAccountNumber()));

        account.setBalance(account.getBalance().add(request.getAmount()));

        Account updatedAccount = accountRepository.save(account);

        bankTransactionService.saveDepositTransaction(
                updatedAccount,
                request.getAmount()
        );

        return AccountResponse.builder()
                .accountNumber(updatedAccount.getAccountNumber())
                .accountType(updatedAccount.getAccountType())
                .balance(updatedAccount.getBalance())
                .accountStatus(updatedAccount.getAccountStatus())
                .customerId(updatedAccount.getCustomer().getCustomerId())
                .build();
    }

    @Override
    @Transactional
    public AccountResponse withdraw(WithdrawRequest request) {

        Account account = accountRepository.findById(request.getAccountNumber())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Account not found with account number : "
                                + request.getAccountNumber()));

        if (account.getBalance().compareTo(request.getAmount()) < 0) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        account.setBalance(account.getBalance().subtract(request.getAmount()));

        Account updatedAccount = accountRepository.save(account);

        bankTransactionService.saveWithdrawTransaction(
                updatedAccount,
                request.getAmount()
        );

        return AccountResponse.builder()
                .accountNumber(updatedAccount.getAccountNumber())
                .accountType(updatedAccount.getAccountType())
                .balance(updatedAccount.getBalance())
                .accountStatus(updatedAccount.getAccountStatus())
                .customerId(updatedAccount.getCustomer().getCustomerId())
                .build();
    }

    @Override
    @Transactional
    public TransferResponse transfer(TransferRequest request) {

        // Find Sender Account
        Account sender = accountRepository.findById(request.getSenderAccount())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Sender account not found : " + request.getSenderAccount()));

        // Find Receiver Account
        Account receiver = accountRepository.findById(request.getReceiverAccount())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Receiver account not found : " + request.getReceiverAccount()));

        // Same Account Validation
        if (sender.getAccountNumber().equals(receiver.getAccountNumber())) {
            throw new SameAccountTransferException(
                    "Cannot transfer to the same account");
        }

        // Balance Validation
        if (sender.getBalance().compareTo(request.getAmount()) < 0) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        // Debit Sender
        sender.setBalance(sender.getBalance().subtract(request.getAmount()));


        receiver.setBalance(receiver.getBalance().add(request.getAmount()));


        accountRepository.save(sender);
        accountRepository.save(receiver);


        bankTransactionService.saveTransferTransaction(
                sender,
                receiver,
                request.getAmount());

        return TransferResponse.builder()
                .message("Amount transferred successfully")
                .senderAccount(sender.getAccountNumber())
                .receiverAccount(receiver.getAccountNumber())
                .amount(request.getAmount())
                .transactionTime(java.time.LocalDateTime.now())
                .build();
    }
}