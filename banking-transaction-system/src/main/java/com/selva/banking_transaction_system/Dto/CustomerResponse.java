package com.selva.banking_transaction_system.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {

    private Long customerId;

    private String fullName;

    private String email;

    private String phoneNumber;

    private String address;

}