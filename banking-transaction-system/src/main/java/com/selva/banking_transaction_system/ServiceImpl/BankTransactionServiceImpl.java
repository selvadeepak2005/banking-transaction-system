package com.selva.banking_transaction_system.ServiceImpl;
import com.selva.banking_transaction_system.Dto.TransactionResponse;
import com.selva.banking_transaction_system.Entity.Account;
import com.selva.banking_transaction_system.Entity.BankTransaction;
import com.selva.banking_transaction_system.Enum.TransactionStatus;
import com.selva.banking_transaction_system.Enum.TransactionType;
import com.selva.banking_transaction_system.Exception.ResourceNotFoundException;
import com.selva.banking_transaction_system.Repository.AccountRepository;
import com.selva.banking_transaction_system.Repository.BankTransactionRepository;
import com.selva.banking_transaction_system.Service.BankTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankTransactionServiceImpl implements BankTransactionService {

    private final AccountRepository accountRepository;
    private final BankTransactionRepository bankTransactionRepository;

    @Override
    public void saveDepositTransaction(Account account,
                                       BigDecimal amount) {

        BankTransaction transaction = BankTransaction.builder()
                .transactionType(TransactionType.DEPOSIT)
                .amount(amount)
                .transactionDate(LocalDateTime.now())
                .transactionStatus(TransactionStatus.SUCCESS)
                .senderAccount(account)
                .receiverAccount(null)
                .remarks("Amount Deposited Successfully")
                .build();

        bankTransactionRepository.save(transaction);
    }
    @Override
    public void saveWithdrawTransaction(Account account,
                                        BigDecimal amount) {

        BankTransaction transaction = BankTransaction.builder()
                .transactionType(TransactionType.WITHDRAW)
                .amount(amount)
                .transactionDate(LocalDateTime.now())
                .transactionStatus(TransactionStatus.SUCCESS)
                .senderAccount(account)
                .receiverAccount(null)
                .remarks("Amount Withdraw Successfully")
                .build();

        bankTransactionRepository.save(transaction);
    }

    @Override
    public void saveTransferTransaction(Account sender,
                                        Account receiver,
                                        BigDecimal amount) {

        BankTransaction transaction = BankTransaction.builder()
                .transactionType(TransactionType.TRANSFER)
                .amount(amount)
                .transactionDate(LocalDateTime.now())
                .transactionStatus(TransactionStatus.SUCCESS)
                .senderAccount(sender)
                .receiverAccount(receiver)
                .remarks("Amount transferred successfully")
                .build();

        bankTransactionRepository.save(transaction);
    }

    @Override
    public List<TransactionResponse> getTransactionHistory(Long accountNumber) {

        Account account = accountRepository.findById(accountNumber)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Account not found with account number : "
                                        + accountNumber));

        List<BankTransaction> transactions =
                bankTransactionRepository
                        .findBySenderAccountOrReceiverAccount(account, account);

        return transactions.stream()
                .map(transaction -> TransactionResponse.builder()
                        .transactionId(transaction.getTransactionId())
                        .transactionType(transaction.getTransactionType())
                        .amount(transaction.getAmount())
                        .transactionDate(transaction.getTransactionDate())
                        .transactionStatus(transaction.getTransactionStatus())
                        .senderAccount(
                                transaction.getSenderAccount() != null
                                        ? transaction.getSenderAccount().getAccountNumber()
                                        : null)
                        .receiverAccount(
                                transaction.getReceiverAccount() != null
                                        ? transaction.getReceiverAccount().getAccountNumber()
                                        : null)
                        .remarks(transaction.getRemarks())
                        .build())
                .toList();
    }
}