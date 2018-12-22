package com.cs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

public class BinarySearch {
    public static int Search(String key, String[] whitelistedWords){
        return Search(key, whitelistedWords, 0, whitelistedWords.length);
    }

    public static int Search(String key, String[] whitelisted, int lo, int hi) {
        
        if (hi <= lo) return -1;
        int mid = lo + (hi-lo)/2;

        int cmp = whitelisted[mid].compareTo(key);
        
        if (cmp > 0) return Search(key, whitelisted, lo, mid);
        else if (cmp < 0) Search(key, whitelisted, mid, hi);
        
        return mid;

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
            //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            //Stream<String> stream = in.lines();
            //String[] words = stream.toArray(String[]::new);                        
            StringBuffer sb = new StringBuffer();
            int ch;
            while ((ch = System.in.read ()) != -1){
                char chr = (char) ch;
                sb.append(chr);
            }
            System.out.println(sb.toString());
            String[] words = sb.toString().split("\n");

            if (words.length <  2) words = loadData(path);

            int N = words.length;
            Random rd = new Random(N);
            double start = System.currentTimeMillis()/1000;
            for (int i=0; i < 10*N; i++){
                int idx = rd.nextInt(N);
                String key = words[idx];
                if (Search(key, words)> -1){
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

