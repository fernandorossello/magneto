package com.example.magneto.Model.DnaProcessor;

import java.util.ArrayList;
import java.util.List;

public class DiagonalDnaProcessor extends DnaProcessor {

    @Override
    public String[] transformDnaRows(String[] rows, int consecutiveChars) {

        List<String> strings = new ArrayList();
        int size = rows.length;

        for (int i = 0; consecutiveChars <= size - i; i++ ){
            StringBuilder stringBuilder = new StringBuilder();
            for(int j = 0; j < (size-i) ; j++ ){
                stringBuilder.append(rows[i+j].charAt(j));
            }

            strings.add(stringBuilder.toString());
        }

        for (int i = 1; consecutiveChars <= size - i; i++ ){
            StringBuilder stringBuilder = new StringBuilder();
            for(int j = 0; j < (size-i) ; j++ ){
                stringBuilder.append(rows[j].charAt(i+j));
            }

            strings.add(stringBuilder.toString());
        }

        String[] ret = new String[strings.size()];
        ret = strings.toArray(ret);

        return ret;
    }
}
