package com.cs;

import java.util.Random;

public class Generator{
    public static void main(String[] args) {    
        int num = 100;
        int length = 10;
        if (args.length >= 2){
            num = Integer.parseInt(args[0]);    
            length = Integer.parseInt(args[1]);    
        }
        String data = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rd = new Random();
        for (int i =0; i < num; i++){
            StringBuilder sb = new StringBuilder(length);
            for (int j=0; j< length; j++){
                int randVal = rd.nextInt(data.length());
                sb.append(data.charAt(randVal));
            }
            System.out.println(sb.toString());
        }
    }
}
