package com.example.magneto.Model;

import com.example.magneto.Model.DNA.DNA;
import com.example.magneto.Model.DnaProcessor.DiagonalDnaProcessor;
import com.example.magneto.Model.DnaProcessor.DnaProcessor;
import com.example.magneto.Model.DnaProcessor.HorizontalDnaProcessor;
import com.example.magneto.Model.DnaProcessor.VerticalDnaProcessor;
import com.example.magneto.Utils.Exceptions.InvalidDNAException;

import java.util.ArrayList;
import java.util.List;

public class MutantAnalyser {

    public static int CONSECUTIVE_CHARS = 4;
    public static int TOTAL_SEQUENCES = 2;

    private List<DnaProcessor> processors;

    public MutantAnalyser(){
        this.initializeProcessors();
    }

    private void initializeProcessors() {
        processors =  new ArrayList<>();
        processors.add(new HorizontalDnaProcessor());
        processors.add(new VerticalDnaProcessor());
        processors.add(new DiagonalDnaProcessor());
    }

    public DNA analyseDna(String[] dnaStrings) throws InvalidDNAException {
        DNA dna = new DNA(dnaStrings);
        dna.validate();

        int found = countSequences(dnaStrings);

        if(found == TOTAL_SEQUENCES) {
            dna.setMutant(true);
        }

        return dna;
    }

    private int countSequences(String[] dnaString){
        int found = 0;
        for (DnaProcessor processor: processors) {
            found += processor.analyseDna(dnaString,CONSECUTIVE_CHARS,TOTAL_SEQUENCES-found);
            if(found == TOTAL_SEQUENCES){
                break;
            }
        }
        return found;
    }

}
