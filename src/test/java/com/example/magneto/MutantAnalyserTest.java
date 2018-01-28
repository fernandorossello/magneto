package com.example.magneto;

import com.example.magneto.Model.DNA.DNA;
import com.example.magneto.Model.MutantAnalyser;
import com.example.magneto.Utils.Exceptions.InvalidDNAException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MutantAnalyserTest {

    MutantAnalyser mutantAnalyser;

    @Before
    public void SetUp(){
        mutantAnalyser = new MutantAnalyser();
    }

    @Test
    public void DetectsMutant() throws InvalidDNAException {
        String[] dnaStrings = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        DNA dna = mutantAnalyser.analyseDna(dnaStrings);

        Assert.assertTrue(dna.isMutant());
    }

    @Test
    public void DetectsHuman() throws InvalidDNAException {
        String[] dnaStrings = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
        DNA dna = mutantAnalyser.analyseDna(dnaStrings);

        Assert.assertFalse(dna.isMutant());
    }

    @Test(expected = InvalidDNAException.class)
    public void FailsOnSizeValidation() throws InvalidDNAException {
        String[] dnaStrings = {"ATGCGA","CAGTC","TTATTT","AGACGG","GCGTCA","TCACTG"};
        DNA dna = mutantAnalyser.analyseDna(dnaStrings);

        Assert.assertFalse(dna.isMutant());
    }

    @Test(expected = InvalidDNAException.class)
    public void FailsOnCharValidation() throws InvalidDNAException {
        String[] dnaStrings = {"ATGCGA","CAGTGC","TTDTTT","AGACGG","GCGTCA","TCACTG"};
        DNA dna = mutantAnalyser.analyseDna(dnaStrings);

        Assert.assertFalse(dna.isMutant());
    }

}
