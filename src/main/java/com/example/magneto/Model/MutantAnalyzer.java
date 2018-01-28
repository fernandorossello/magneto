package com.example.magneto.Model;

import java.util.ArrayList;
import java.util.List;

public class MutantAnalyzer {

    public static int CONSECUTIVE_CHARS = 4;

    public MutantAnalyzer(){
        this.initializeProcessors();
    }

    private void initializeProcessors() {
        this.processors =  new ArrayList<>();
    }

    private List<DnaProcessor> processors;

}
