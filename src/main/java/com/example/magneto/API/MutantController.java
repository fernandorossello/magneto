package com.example.magneto.API;

import com.example.magneto.API.Models.DnaModel;
import com.example.magneto.MagnetoApplication;
import com.example.magneto.Model.DNA.DNA;
import com.example.magneto.Service.MutantService;
import com.example.magneto.Utils.Exceptions.InvalidDNAException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MutantController {


    private static final Logger logger = LoggerFactory.getLogger(MagnetoApplication.class);
    @Autowired
    private MutantService mutantService;

    @RequestMapping(value="/mutant", method = RequestMethod.POST)
    public ResponseEntity isMutant(@RequestBody DnaModel dnaModel){
        try {
            logger.debug("Analysing DNA: " + DNA.concatDNA(dnaModel.dna));

            if(mutantService.isMutant(dnaModel.dna)){
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.FORBIDDEN);
            }
        } catch (InvalidDNAException e) {
            logger.error(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
