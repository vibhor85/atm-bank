package com.practice.atm.ATMBank.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    String resourceName;
    String fieldName;
    String field;

    public ResourceNotFoundException(String resourceName, String field, String fieldName){
        this.field = field;
        this.resourceName = resourceName;
        this.fieldName = fieldName;
    }
}
