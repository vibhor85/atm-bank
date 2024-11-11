package com.practice.atm.ATMBank.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    String resourceName;
    String fieldName;
    String field;

    public ResourceNotFoundException(String resourceName, String field, String fieldName){
        super(String.format("%s not found with %s: %s",resourceName,field,fieldName));
        this.field = field;
        this.resourceName = resourceName;
        this.fieldName = fieldName;
    }
}
