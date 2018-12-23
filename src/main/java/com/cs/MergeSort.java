package com.cs;

public class MergeSort {
    private static String[] aux;
    public static void sort(String[] data){
        aux = new String[data.length];        
        sort(data, 0 , data.length);
    }

    private static void sort(String[] data, int lo, int hi){
        int N = hi - lo;
        if (N <= 1) return;
        int mid = lo + N/2;
        sort(data, lo, mid);
        sort(data, mid, hi);
        merge(data, lo, mid, hi);        
    }

    private static void merge(String[] data, int lo, int mid, int hi){
        int i=lo, j = mid, N = hi - lo;
        for ( int k=0; k < N; k++) {
            if (i==mid) aux[k] = data[j++];
            else if (j == hi) aux[k] = data[i++];
            else if (data[i].compareTo(data[j]) < 0) aux[k] = data[i++];
            else aux[k] = data[j++];
        }
        for (int k=0 ; k < N; k++) data[lo+k] = aux[k];        
    }



    

    public static void main(String[] args) {
        
        try {            
            String[] data = Utils.LoadData();
            System.out.printf("data size %d ", data.length);    
            double start = System.currentTimeMillis()/1000;
            sort(data);

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

