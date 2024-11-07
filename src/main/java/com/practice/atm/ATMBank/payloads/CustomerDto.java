package com.practice.atm.ATMBank.payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {
    private Integer Id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private Integer pin;
    private Date created_at;
    private Date updated_at;
}
