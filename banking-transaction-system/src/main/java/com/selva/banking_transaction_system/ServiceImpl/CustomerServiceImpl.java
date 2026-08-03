package com.selva.banking_transaction_system.ServiceImpl;
import com.selva.banking_transaction_system.Dto.CreateCustomerRequest;
import com.selva.banking_transaction_system.Dto.CustomerResponse;
import com.selva.banking_transaction_system.Entity.Customer;
import com.selva.banking_transaction_system.Exception.DuplicateEmailException;
import com.selva.banking_transaction_system.Repository.CustomerRepository;
import com.selva.banking_transaction_system.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponse createCustomer(CreateCustomerRequest request) {

        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmailException("Email already exists");
        }


        Customer customer = Customer.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .build();


        Customer savedCustomer = customerRepository.save(customer);

        return CustomerResponse.builder()
                .customerId(savedCustomer.getCustomerId())
                .fullName(savedCustomer.getFullName())
                .email(savedCustomer.getEmail())
                .phoneNumber(savedCustomer.getPhoneNumber())
                .address(savedCustomer.getAddress())
                .build();
    }
}