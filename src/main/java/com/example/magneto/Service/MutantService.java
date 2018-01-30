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

    @Autowired
    private StatsService statsService;

    public MutantService(){
        mutantAnalyser = new MutantAnalyser();
    }

    public boolean isMutant(String[] dnaStrings) throws InvalidDNAException {
        DNA dna = dnaRepository.findOne(DNA.concatDNA(dnaStrings));
        if(dna == null) {
            dna = mutantAnalyser.analyseDna(dnaStrings);
            dnaRepository.save(dna);
            statsService.updateStats(dna);
        }
        return dna.isMutant();
    }
}
