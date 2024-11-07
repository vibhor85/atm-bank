package com.practice.atm.ATMBank.services;


import com.practice.atm.ATMBank.payloads.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto updateCustomer(CustomerDto customerDto, Integer Id);

    void deleteCustomer(Integer Id);

    CustomerDto getCustomerById(Integer Id);

    List<CustomerDto> getAllCustomers();

}
