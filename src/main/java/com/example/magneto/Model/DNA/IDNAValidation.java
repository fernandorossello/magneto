package com.example.magneto.Model.DNA;

import com.example.magneto.Utils.Exceptions.InvalidDNAException;

public interface IDNAValidation {

    void validate(String[] dnaStrings) throws InvalidDNAException;
}
