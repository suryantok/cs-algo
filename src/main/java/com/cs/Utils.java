package com.cs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Utils {
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

    public static String[] LoadData(){
        
        String basePath = new File("").getAbsolutePath();
        Path path = Paths.get(basePath, "data/whitelist.txt");
        System.out.print(basePath);
        try {            
            StringBuffer sb = new StringBuffer();
            int ch;
            while ((ch = System.in.read ()) != -1){
                char chr = (char) ch;
                sb.append(chr);
            }
            System.out.println(sb.toString());
            String[] data = sb.toString().split("\n");
            if (data.length <  2) data = loadData(path);            
            return data;
        } catch(Exception e){
            System.out.println(e.getMessage());    
            return null;
        }
    }


}