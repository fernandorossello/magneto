package com.example.magneto.Model.DNA;

import com.example.magneto.Utils.Exceptions.InvalidDNAException;

import java.util.ArrayList;
import java.util.List;

public class DNA {


    private List<IDNAValidation> validations;
    private boolean isMutant = false;

    public DNA(String[] dna){
        dnaSecuence = dna;
        validations = new ArrayList<>();
        validations.add(new SizeValidation());
        validations.add(new CharValidation());
    }

    private String[] dnaSecuence;

    public boolean isMutant() {
        return isMutant;
    }

    public void setMutant(boolean mutant) {
        isMutant = mutant;
    }

    public void validate() throws InvalidDNAException {
        for (IDNAValidation validation:validations) {
            validation.validate(dnaSecuence);
        }
    }


}
