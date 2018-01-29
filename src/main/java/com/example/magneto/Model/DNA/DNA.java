package com.example.magneto.Model.DNA;

import com.example.magneto.Utils.Exceptions.InvalidDNAException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DNA {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "dna")
    private String dnaString;

    @Column
    private boolean isMutant = false;

    @Transient
    private List<IDNAValidation> validations;

    @Transient
    private String[] dnaSecuence;

    public DNA(String[] dna){
        dnaSecuence = dna;
        dnaString = String.join("-",dna);
        validations = new ArrayList<>();
        validations.add(new SizeValidation());
        validations.add(new CharValidation());
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
