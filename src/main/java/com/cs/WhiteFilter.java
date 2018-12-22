package com.cs;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class WhiteFilter {
    public static int Search(String key, String[] whitelistedWords){
        for (int i=0; i < whitelistedWords.length; i++)
            if (whitelistedWords[i].equals(key)) return i;            
        return -1;
    }

    private static String[] loadData(Path path){
        String[] words = {};
        try (Stream<String> stream = Files.lines(path);){
            words = stream.toArray(String[]::new);                        
        }
        catch(IOException e){
            System.out.println(e.getMessage());            
        }
        return words;

    }

    public static void main(String [] args){
        String basePath = new File("").getAbsolutePath();
        Path path = Paths.get(basePath, "data/whitelist.txt");
        System.out.print(basePath);

        try {
            
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            Stream<String> stream = in.lines();
            String[] words = stream.toArray(String[]::new);                        
            if (words.length == 0) words = loadData(path);

            // StringBuffer sb = new StringBuffer();
            // int ch = System.in.read ();
            // while (((ch = System.in.read ()) != -1)) {
            //     char chr = (char) ch;
            //     sb.append(chr);
            // }
            
            String[] keys = loadData(Paths.get(basePath, "data/data.txt"));
            System.out.println("");
            for (String k : keys) {                 
                if (Search(k, words) != -1) 
                    System.out.println(k);
            }

            
                
    
        } catch(Exception e){
            System.out.println(e.getMessage());    
        }
    }


}

