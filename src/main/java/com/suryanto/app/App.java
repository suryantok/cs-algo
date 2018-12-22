package com.suryanto.app;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void readLine(){
      StringBuilder sb = new StringBuilder();
      try{
        BufferedInputStream bin = new BufferedInputStream(System.in);
        int in = 0;
        char inChar;
        do {
          in = bin.read();
          inChar = (char) in;
          if (in !=-1) sb.append(inChar);
        } while ((in !=-1) & (inChar != '\n'));
        
        System.out.println(sb.toString());
        bin.close();

      } 
      catch(IOException e){
        System.out.println(e.getMessage());    
      }

    }
    public static void main( String[] args )
    {
                
        
        
        System.out.println( "Hello World!" );
    }
}
