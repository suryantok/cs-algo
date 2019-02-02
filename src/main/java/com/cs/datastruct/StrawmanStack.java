package com.cs.datastruct;

import java.io.Console;
import java.io.IOException;
import java.util.EmptyStackException;

public class StrawmanStack<T> {
    Object[] _arr;
    int pos = 0;
    int _maxSize;

    public static String[] readAllString(){
        return new String[2];
    }

    public StrawmanStack(int size){
        _arr = new Object[size];
        _maxSize = size;
    }

    public boolean isEmpty(){
        return _arr.length == 0;
    }

    public void push(T item) throws Exception {
        if (pos == _maxSize)
            throw new Exception();
        _arr[pos++] = item;        
    }

    public T pop(){
        if (isEmpty())
            throw new EmptyStackException();
        return element(--pos);

    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        for (int i=0; i < pos; i++) {
            sb.append(_arr[i].toString() + " ");            
        }        
        return sb.toString().trim();
    }

    @SuppressWarnings("unchecked")
    private T element(int idx){
        return (T)_arr[idx];
    }


    public static void main(String[] args) throws Exception {

        StrawmanStack<String> stack = new StrawmanStack<String>(10);

        Console console = System.console();
        if (console == null) {
            System.out.println("No console: non-interactive mode!");
            System.exit(0);
        }
        
        String inputLine;
        while(!(inputLine = console.readLine()).trim().equalsIgnoreCase("")){

            if (inputLine.equalsIgnoreCase("-"))
                System.out.println("poping " +  stack.pop()) ;
            else
                stack.push(inputLine);
        }
                
        System.out.println(stack.toString());
        
        
        

        
        

    }
}

