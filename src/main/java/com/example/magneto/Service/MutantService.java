package com.example.magneto.Service;

import com.example.magneto.Model.DNA.DNA;
import com.example.magneto.Model.MutantAnalyser;
import com.example.magneto.Repository.DNARepository;
import com.example.magneto.Utils.Exceptions.InvalidDNAException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantService {

    private MutantAnalyser mutantAnalyser;

    @Autowired
    private DNARepository dnaRepository;

    public MutantService(){

        mutantAnalyser = new MutantAnalyser();
        dnaRepository = new DNARepository();
    }

    public boolean isMutant(String[] dnaStrings) throws InvalidDNAException {
        DNA dna = mutantAnalyser.analyseDna(dnaStrings);
        dnaRepository.add(dna);
        return dna.isMutant();
    }
}
