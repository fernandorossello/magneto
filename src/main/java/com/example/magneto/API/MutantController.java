package com.example.magneto.API;

import com.example.magneto.API.Models.DnaModel;
import com.example.magneto.Service.MutantService;
import com.example.magneto.Utils.Exceptions.InvalidDNAException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MutantController {

    @Autowired
    private MutantService mutantService;

    @RequestMapping(value="/mutant", method = RequestMethod.POST)
    public ResponseEntity isMutant(@RequestBody DnaModel dnaModel){
        try {
            if(mutantService.isMutant(dnaModel.dna)){
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.FORBIDDEN);
            }
        } catch (InvalidDNAException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
