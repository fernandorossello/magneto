package com.example.magneto.API.Models;

import com.example.magneto.Model.Stats;

public class StatsModel {

    private int count_mutant_dna;

    private int count_human_dna;

    private float ratio;

    public int getCount_human_dna() {
        return count_human_dna;
    }

    public void setCount_human_dna(int count_human_dna) {
        this.count_human_dna = count_human_dna;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    public int getCount_mutant_dna() {

        return count_mutant_dna;
    }

    public void setCount_mutant_dna(int count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
    }

    public StatsModel(Stats stats){
        count_human_dna = stats.getHumansCount();
        count_mutant_dna = stats.getMutantsCount();
        if(count_human_dna == 0){
            ratio = 0;
        } else {
            ratio = count_mutant_dna / count_human_dna;
        }
    }
}
