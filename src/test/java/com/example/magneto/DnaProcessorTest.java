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

    private DnaProcessor processor;

    @Before
    public void SetUp(){
        processor = new DnaProcessor(){};
    }

    @Test
    public void findsOneSequence(){
        int count = processor.countSequences("AAATNRA",2);

        Assert.assertEquals(1, count, 0);
    }

    @Test
    public void findsTwoSequencesIfTheyAreTogether(){
        int count = processor.countSequences("AAAAAA",3);

        Assert.assertEquals(2, count, 0);
    }

    @Test
    public void findsNoSequences(){
        int count = processor.countSequences("AAATNRA",4);

        Assert.assertEquals(0, count, 0);
    }

    @Test
    public void findsSequenceAtTheEndOfTheString(){
        int count = processor.countSequences("ATNRAAA",3);

        Assert.assertEquals(1, count, 0);
    }


}
