package com.example.magneto.Model;

public class DNA {

    public DNA(String[] dna){
        dnaSecuence = dna;
    }

    private String[] dnaSecuence;

    public Character[][] getDnaMatrix(){
        int size = dnaSecuence.length;
        Character[][] matrix = new Character[size][size];

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                matrix[i][j] = dnaSecuence[i].charAt(j);
            }
        }

        return matrix;
    }


}
