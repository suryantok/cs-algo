package com.cs.datastruct;

import java.io.IOException;

public class QEx {
    public static String[] readAllString(){
        return new String[2];
    }
    public static void main(String[] args) {
        String[] words =  readAllString();
        for (int i=0; i < words.length; i++)
            System.out.print(words[i]);


        StringBuffer sb = new StringBuffer();    
        int ch;
        try {
            while ((ch = System.in.read ()) != -1){
                char chr = (char) ch;
                if (chr == 'q')
                    break;
                sb.append(chr);                
            }
            System.out.println(sb.toString());
        }
        catch (IOException e){
            System.out.println("Error reading from user");
        }

    }
}

