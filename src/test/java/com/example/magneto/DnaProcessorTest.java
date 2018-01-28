package com.example.magneto;

import com.example.magneto.Model.DnaProcessor.DiagonalDnaProcessor;
import com.example.magneto.Model.DnaProcessor.DnaProcessor;
import com.example.magneto.Model.DnaProcessor.HorizontalDnaProcessor;
import com.example.magneto.Model.DnaProcessor.VerticalDnaProcessor;
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
    private String[] dnaTransform;
    private VerticalDnaProcessor verticalProcessor;
    private HorizontalDnaProcessor horizontalProcessor;
    private DiagonalDnaProcessor diagonalProcessor;

    @Before
    public void SetUp(){
        mockProcessor = new DnaProcessor(){
            @Override
            public String[] transformDnaRows(String[] rows, int consecutiveChars) {
                return rows;
            }
        };
        dna = new String[] {"AAATAAA","GHGGGG","GTGGHHH"};
        verticalProcessor = new VerticalDnaProcessor();
        horizontalProcessor = new HorizontalDnaProcessor();
        diagonalProcessor = new DiagonalDnaProcessor();
        dnaTransform = new String[]{"ABC","DEF","GHI"};
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

    @Test
    public void verticalProcessorTransformation(){
        String[] output = verticalProcessor.transformDnaRows(dnaTransform,0);

        Assert.assertEquals(3, output.length,0);
        Assert.assertEquals("ADG",output[0]);
        Assert.assertEquals("BEH",output[1]);
        Assert.assertEquals("CFI",output[2]);
    }

    @Test
    public void HorizontalProcessorTransformation(){
        String[] output = horizontalProcessor.transformDnaRows(dnaTransform,0);

        Assert.assertEquals(3, output.length,0);
        Assert.assertEquals("ABC",output[0]);
        Assert.assertEquals("DEF",output[1]);
        Assert.assertEquals("GHI",output[2]);
    }

    @Test
    public void DiagonalProcessorTransformation(){
        String[] output = diagonalProcessor.transformDnaRows(dnaTransform,2);

        Assert.assertEquals(3, output.length,0);
        Assert.assertEquals("AEI",output[0]);
        Assert.assertEquals("DH",output[1]);
        Assert.assertEquals("BF",output[2]);
    }

}
