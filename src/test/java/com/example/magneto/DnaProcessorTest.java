package com.example.magneto;

import com.example.magneto.Model.DnaProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DnaProcessorTest {

    private DnaProcessor mockProcessor;
    private String[] dna;

    @Before
    public void SetUp(){
        mockProcessor = new DnaProcessor(){
            @Override
            public String[] transformDnaRows(String[] rows, int consecutiveChars) {
                return rows;
            }
        };

        dna = new String[] {"AAATAAA","GHGGGG","GTGGHHH"};
    }

    @Test
    public void findsOneSequence(){
        int count = mockProcessor.countSequences("AAATNRA",2,2);

        Assert.assertEquals(1, count, 0);
    }

    @Test
    public void findsTwoSequencesIfTheyAreTogether(){
        int count = mockProcessor.countSequences("AAAAAA",3,2);

        Assert.assertEquals(2, count, 0);
    }

    @Test
    public void findsSequencesIfTheyAreSeparated(){
        int count = mockProcessor.countSequences("AAATAAA",3,2);

        Assert.assertEquals(2, count, 0);
    }

    @Test
    public void findsNoSequences(){
        int count = mockProcessor.countSequences("AAATNRA",4,2);

        Assert.assertEquals(0, count, 0);
    }

    @Test
    public void findsSequenceAtTheEndOfTheString(){
        int count = mockProcessor.countSequences("ATNRAAA",3,2);

        Assert.assertEquals(1, count, 0);
    }

    @Test
    public void stopsIfFindsSearchedSequences(){
        int count = mockProcessor.countSequences("AAATAAA",3,1);

        Assert.assertEquals(1, count, 0);
    }

    @Test
    public void findsLessSequencesThanSearched(){

        int count = mockProcessor.analyseDna(dna,3,5);

        Assert.assertEquals(4,count,0);
    }

    @Test
    public void findsJustSearchedSequences(){

        int count = mockProcessor.analyseDna(dna,3,3);

        Assert.assertEquals(3,count,0);
    }

}
