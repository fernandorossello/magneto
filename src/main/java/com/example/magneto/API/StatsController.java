package com.example.magneto.API;

import com.example.magneto.API.Models.StatsModel;
import com.example.magneto.MagnetoApplication;
import com.example.magneto.Service.StatsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatsController {

    private static final Logger logger = LoggerFactory.getLogger(MagnetoApplication.class);

    @Autowired
    private StatsService statsService;

    @RequestMapping(value="/stats", method = RequestMethod.GET)
    public ResponseEntity getMutantStats(){
       try {
            return ResponseEntity.ok(new StatsModel(statsService.getStats()));
       } catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
