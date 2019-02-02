package com.cs.datastruct;
import java.io.Console;

public class Stack<T> {

    private Node _first = null;
    int N =0;

    private class Node{
        T item;
        Node next;
    }

    public boolean isEmpty(){return _first==null;}

    public void push(T item){
        Node second = _first;
        _first = new Node();
        _first.next = second;
        _first.item = item;
        N++;
    }

    public T pop() throws Exception {
        if (isEmpty()) 
            throw new Exception("stack is empty");
        T item = _first.item;
        _first = _first.next;
        N--;
        return item;
    }

    public int size(){return N;}

    @Override
    public String toString() {
        Node node= _first;

        StringBuffer sb = new StringBuffer();
        while(node != null){
            sb.append(node.item + " ");
            node = node.next;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) throws Exception {

        Stack<String> stack = new Stack<String>();

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