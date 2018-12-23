package com.cs;

public class InsertionSort {
    public static void Sort(String[] data){
        int N = data.length;
        for (int i=0; i < N; i++){
            for(int j=i; j > 0; j--){
                if (data[j-1].compareTo(data[j])> 0)
                    exch(data, j-1, j);
                else break;
            }
        }
    }

    private static void exch(String[] data, int i, int j){
        String t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    

    public static void main(String[] args) {
        
        try {            
            String[] data = Utils.LoadData();
            System.out.printf("data size %d ", data.length);    
            double start = System.currentTimeMillis()/1000;
            Sort(data);

            System.out.println("sorted data:");
            for(String s : data) System.out.println(s);

            double end  = System.currentTimeMillis()/1000;
            System.out.println();
            System.out.println(Math.round(end-start) + " second" );
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}

