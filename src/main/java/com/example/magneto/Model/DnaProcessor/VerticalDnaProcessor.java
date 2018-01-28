package com.example.magneto.Model.DnaProcessor;

import com.example.magneto.Model.DNA;

public class VerticalDnaProcessor extends DnaProcessor {

    @Override
    public String[] transformDnaRows(String[] rows, int consecutiveChars) {

        int size = rows.length;
        String[] ret = new String[size];

        for (int i = 0; i < size; i++ ){
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 0; j < size; j++ ){
                stringBuilder.append(rows[j].charAt(i));
            }

            ret[i] = stringBuilder.toString();
        }

        return ret;
    }

}
