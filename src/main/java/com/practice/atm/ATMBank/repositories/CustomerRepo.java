package com.practice.atm.ATMBank.repositories;

import com.practice.atm.ATMBank.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Customer findByEmail(String email);
}
