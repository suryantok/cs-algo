package com.cs;

public class LongestRepeatedSubstring {

    // longest common prefix
    private static String lcp (String s, String t){
        int N = Math.min(s.length(), t.length());
        for (int i=0; i < N; i++){
            if (s.charAt(i) != t.charAt(i)) 
                return s.substring(0, i);            
        }
        return s.substring(0, N);
    }

    public static String lrs(String s) {        
        int N = s.length();
        String[] subStrings = new String[N];
        for (int i=0; i < N; i++){
            subStrings[i] = s.substring(i);            
        }

        MergeSort.sort(subStrings);
        String lrs = "";
        for (int i=0; i < N-1; i++) {
            String x = lcp(subStrings[i], subStrings[i+1]);
            if (x.length() > lrs.length()) lrs =x;

        }        
        return lrs;        
    }
    
    
    public static void main(String[] args) {
        
        try {            
            String[] data = Utils.LoadData();
            System.out.printf("data size %d ", data.length);    
            double start = System.currentTimeMillis()/1000;
            String str = data[0];
            String s = lrs(str);

            System.out.println();
            System.out.println("data " + str);
            System.out.println("Lrs : " + s);
            // for(String s : data) System.out.println(s);

            double end  = System.currentTimeMillis()/1000;
            System.out.println();
            System.out.println(Math.round(end-start) + " second" );
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}

