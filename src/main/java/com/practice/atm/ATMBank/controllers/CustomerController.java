package com.practice.atm.ATMBank.controllers;

import com.practice.atm.ATMBank.payloads.CustomerDto;
import com.practice.atm.ATMBank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable Integer Id) {
        CustomerDto updatedCustomer = customerService.updateCustomer(customerDto, Id);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    @DeleteMapping("/{Id}")
    public void deleteCustomer(@PathVariable Integer Id) {
        customerService.deleteCustomer(Id);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Integer Id) {
        CustomerDto customerDto = customerService.getCustomerById(Id);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }
}
