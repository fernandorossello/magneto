package com.example.magneto.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Stats {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private long mutantsCount;

    @Column
    private long humansCount;

    public Stats(){
        mutantsCount = 0;
        humansCount = 0;
    }

    public void addMutant(){
        mutantsCount++;
    }

    public void addHuman(){
        humansCount++;
    }

    public long getMutantsCount() {
        return mutantsCount;
    }

    public long getHumansCount() {
        return humansCount;
    }
}
