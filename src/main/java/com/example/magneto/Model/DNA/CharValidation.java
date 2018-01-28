package com.example.magneto.Model.DNA;

import com.example.magneto.Utils.Exceptions.InvalidDNAException;

public class CharValidation implements IDNAValidation{

    public static char[] VALID_CHARS = {'A','T','C','G'};

    @Override
    public void validate(String[] dnaStrings) throws InvalidDNAException {
        for (String dnaString : dnaStrings) {
            validate(dnaString);
        }
    }

    private void validate(String dnaString) throws InvalidDNAException {
        if(!dnaString.matches("^["+ new String(VALID_CHARS) +"]+$")){
            throw new InvalidDNAException(dnaString + " contains illegal characters");
        }
    }

}
