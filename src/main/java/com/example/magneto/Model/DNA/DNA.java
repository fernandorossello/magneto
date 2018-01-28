package com.example.magneto.Model.DNA;

import com.example.magneto.Utils.Exceptions.InvalidDNAException;

import java.util.List;

public class DNA {


    private List<IDNAValidation> validations;

    public DNA(String[] dna){

        dnaSecuence = dna;
    }

    private String[] dnaSecuence;

    public String[] getDnaSecuence() {
        return dnaSecuence;
    }

    public void setDnaSecuence(String[] dnaSecuence) {
        this.dnaSecuence = dnaSecuence;
    }

    public void validate() throws InvalidDNAException {
        for (IDNAValidation validation:validations) {
            validation.validate(dnaSecuence);
        }
    }


}
