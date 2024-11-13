package com.practice.atm.ATMBank.services.impl;

import com.practice.atm.ATMBank.entities.Customer;
import com.practice.atm.ATMBank.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
        Customer customer = customerRepo.findByEmail(Email);

        if(customer == null) {
            throw new UsernameNotFoundException("User Not Found");
        }

        return User.builder().username(customer.getEmail()).password(customer.getPassword()).build();
    }
}
