package com.example.magneto.Model.DNA;

import com.example.magneto.Utils.Exceptions.InvalidDNAException;

public class SizeValidation implements IDNAValidation{

    @Override
    public void validate(String[] dnaStrings) throws InvalidDNAException {
        int size = dnaStrings.length;

        for (String dnaString:dnaStrings) {
            if(dnaString.length() != size){
                throw new InvalidDNAException(dnaString + " size does not match the array size");
            }
        }
    }

}
