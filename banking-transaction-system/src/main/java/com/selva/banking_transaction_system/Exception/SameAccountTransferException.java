package com.selva.banking_transaction_system.Exception;

public class SameAccountTransferException extends RuntimeException {

    public SameAccountTransferException(String message) {
        super(message);
    }
}