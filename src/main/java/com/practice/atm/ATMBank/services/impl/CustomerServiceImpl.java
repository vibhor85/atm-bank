package com.practice.atm.ATMBank.services.impl;

import com.practice.atm.ATMBank.entities.Customer;
import com.practice.atm.ATMBank.exceptions.ResourceNotFoundException;
import com.practice.atm.ATMBank.payloads.CustomerDto;
import com.practice.atm.ATMBank.repositories.CustomerRepo;
import com.practice.atm.ATMBank.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customer.setCreated_at(new Date());
        customer.setUpdated_at(new Date());
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        Customer savedCustomer = customerRepo.save(customer);
        return modelMapper.map(savedCustomer, CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, Integer Id) {
        Customer customer = customerRepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Customer", " Id ", Id.toString()));
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(customerDto.getPassword());
        customer.setUpdated_at(new Date());

        Customer savedCustomer = customerRepo.save(customer);
        return modelMapper.map(savedCustomer, CustomerDto.class);
    }

    @Override
    public void deleteCustomer(Integer Id) {
        Customer customer = customerRepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Customer", " Id ", Id.toString()));
        customerRepo.delete(customer);
    }

    @Override
    public CustomerDto getCustomerById(Integer Id) {
        Customer customer = customerRepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Customer", " Id ", Id.toString()));
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        return customers.stream().map(customer -> modelMapper.map(customer, CustomerDto.class)).collect(Collectors.toList());
    }
}
