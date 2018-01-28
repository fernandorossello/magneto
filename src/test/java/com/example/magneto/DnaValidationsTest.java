package com.example.magneto;

import com.example.magneto.Model.DNA.CharValidation;
import com.example.magneto.Model.DNA.SizeValidation;
import com.example.magneto.Utils.Exceptions.InvalidDNAException;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DnaValidationsTest {

    private SizeValidation sizeValidation;
    private CharValidation charValidation;

    @Before
    public void SetUp(){
        sizeValidation = new SizeValidation();
        charValidation = new CharValidation();
    }

    @Test
    public void validatesSizeOk() throws InvalidDNAException {
        String[] array = new String[]{"AB","CD"};
        sizeValidation.validate(array);
    }

    @Test(expected = InvalidDNAException.class)
    public void validatesSizeThrowsException() throws InvalidDNAException {
        String[] array = new String[]{"ABC","CD"};

        sizeValidation.validate(array);
    }

    @Test
    public void validatesCharactersOk() throws InvalidDNAException{
        String[] array = new String[]{"AT","CG"};
        charValidation.validate(array);
    }

    @Test(expected = InvalidDNAException.class)
    public void validatesCharactersThrowsException() throws InvalidDNAException{
        String[] array = new String[]{"AT","CD"};
        charValidation.validate(array);
    }

}
