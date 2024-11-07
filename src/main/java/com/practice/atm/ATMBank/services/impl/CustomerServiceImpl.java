package com.practice.atm.ATMBank.services.impl;

import com.practice.atm.ATMBank.entities.Customer;
import com.practice.atm.ATMBank.payloads.CustomerDto;
import com.practice.atm.ATMBank.repositories.CustomerRepo;
import com.practice.atm.ATMBank.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Customer savedCustomer = customerRepo.save(customer);
        return modelMapper.map(savedCustomer, CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, Integer Id) {
        return null;
    }

    @Override
    public void deleteCustomer(Integer Id) {

    }

    @Override
    public CustomerDto getCustomerById(Integer Id) {
        return null;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return List.of();
    }
}
