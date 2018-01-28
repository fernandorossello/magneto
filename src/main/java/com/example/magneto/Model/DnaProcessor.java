package com.example.magneto.Model;

public abstract class DnaProcessor {


    public int countSequences(String toAnalyze, int consecutiveChars){
        int size = toAnalyze.length();
        int stop = size -1;
        int count = 1;
        int found = 0;

        for(int i = 0; i < stop; i++){

            if(toAnalyze.charAt(i) == toAnalyze.charAt(i+1) ){
                count++;
            } else {
                count = 1;
            }

            if(count == consecutiveChars){
                found++;
                count=0;
            }
        }

        if(count == consecutiveChars){
            found++;
        }

        return found;
    }

}
