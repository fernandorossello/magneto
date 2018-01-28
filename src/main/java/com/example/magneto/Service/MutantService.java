package com.example.magneto.Service;

import com.example.magneto.Model.DNA.DNA;
import com.example.magneto.Model.MutantAnalyser;
import com.example.magneto.Utils.Exceptions.InvalidDNAException;
import org.springframework.stereotype.Service;

@Service
public class MutantService {

    private MutantAnalyser mutantAnalyser;

    public MutantService(){
        mutantAnalyser = new MutantAnalyser();
    }

    public boolean isMutant(String[] dnaStrings) throws InvalidDNAException {
        DNA dna = mutantAnalyser.analyseDna(dnaStrings);

        return dna.isMutant();
    }
}
