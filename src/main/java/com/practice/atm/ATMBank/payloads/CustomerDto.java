package com.practice.atm.ATMBank.payloads;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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

    @NotEmpty(message = "Name is mandatory")
    private String name;

    @NotEmpty(message = "Email is mandatory")
    @Email(message = "Invalid email")
    private String email;

    @NotEmpty(message = "Phone Number is mandatory")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number")
    private String phone;

    @NotEmpty(message = "Password is mandatory")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one number, and one special character."
    )
    private String password;

    @NotNull(message = "PIN is required")
    @Min(value = 1000, message = "PIN must be at least 4 digits")
    @Max(value = 9999, message = "PIN must be at most 4 digits")
    private Integer pin;
    private Date created_at;
    private Date updated_at;
}
