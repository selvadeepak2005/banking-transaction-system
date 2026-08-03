package com.selva.banking_transaction_system.Service;

import com.selva.banking_transaction_system.Dto.CreateCustomerRequest;
import com.selva.banking_transaction_system.Dto.CustomerResponse;


public interface CustomerService {

    CustomerResponse createCustomer(CreateCustomerRequest request);

}