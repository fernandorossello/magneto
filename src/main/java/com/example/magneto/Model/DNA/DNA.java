package com.example.magneto.Model.DNA;

import com.example.magneto.Utils.Exceptions.InvalidDNAException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DNA {

    @Id
    @Column(name = "dna")
    private String dnaString;

    @Column
    private boolean isMutant = false;

    @Transient
    private List<IDNAValidation> validations;

    @Transient
    private String[] dnaSecuence;

    public static String concatDNA(String[] dna){
        return String.join("-",dna);
    }

    public DNA(){}

    public DNA(String[] dna){
        dnaSecuence = dna;
        dnaString = DNA.concatDNA(dna);
        validations = new ArrayList<>();
        validations.add(new SizeValidation());
        validations.add(new CharValidation());
    }

    public String getDnaString() {
        return dnaString;
    }

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
