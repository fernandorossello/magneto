package com.example.magneto.Service;

import com.example.magneto.Model.DNA.DNA;
import com.example.magneto.Model.Stats;
import com.example.magneto.Repository.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class StatsService {

    @Autowired
    private StatsRepository statsRepository;

    public void updateStats(DNA dna){
        Stats stats = getStats();

        if(dna.isMutant()){
            stats.addMutant();
        } else  {
            stats.addHuman();
        }

        statsRepository.save(stats);
    }

    public Stats getStats(){
        Iterator<Stats> iterator = statsRepository.findAll().iterator();

        if(iterator.hasNext()){
            return iterator.next();
        } else {
            return new Stats();
        }

    }
}
