package com.cs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

public class SequentialSearch {
    public static int Search(String key, String[] whitelistedWords){
        for (int i=0; i < whitelistedWords.length; i++)
            if (whitelistedWords[i].equals(key)) return i;            
        return -1;
    }

    public static void main(String[] args) {
        try {
            String[] words = Utils.LoadData();
            int N = words.length;
            Random rd = new Random(N);
            double start = System.currentTimeMillis()/1000;
            for (int i=0; i < 10*N; i++){
                int idx = rd.nextInt(N);
                String key = words[idx];
                if (Search(key, words) > -1) {
                    System.out.println();
                    System.out.printf("%d found %s", idx, key);        
                }                    
            }
            double end  = System.currentTimeMillis()/1000;
            System.out.println();
            System.out.println(Math.round(end-start) + " second" );
        } catch(Exception e){
            System.out.println(e.getMessage());    
        }
    }


}

