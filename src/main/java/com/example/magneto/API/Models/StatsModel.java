package com.example.magneto.API.Models;

import com.example.magneto.Model.Stats;

public class StatsModel {

    private long count_mutant_dna;

    private long count_human_dna;

    private double ratio;

    public long getCount_human_dna() {
        return count_human_dna;
    }

    public void setCount_human_dna(long count_human_dna) {
        this.count_human_dna = count_human_dna;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public long getCount_mutant_dna() {

        return count_mutant_dna;
    }

    public void setCount_mutant_dna(long count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
    }

    public StatsModel(Stats stats){
        count_human_dna = stats.getHumansCount();
        count_mutant_dna = stats.getMutantsCount();
        if(count_human_dna == 0){
            ratio = 0;
        } else {
            ratio = ((double) count_mutant_dna) / count_human_dna;
        }
    }
}
