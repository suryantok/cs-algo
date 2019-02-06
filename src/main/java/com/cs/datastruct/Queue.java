package com.cs.datastruct;
import java.io.Console;
import java.util.Iterator;

public class Queue<T> implements Iterable<T>{

    private Node _first = null;
    private Node _last = null;
    int N =0;

    private class Node{
        T item;
        Node next;
    }

    private class QueueIterator implements Iterator<T> {

        private Node current = _first;
        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public T next() {
            if (!hasNext()) return null;
            T retVal = current.item;
            current = current.next;
            return retVal;
        }

    }

    public boolean isEmpty(){return _first==null;}

    public void enqueue(T item){
        Node newNode = new Node();
        newNode.item = item;

        if (_last == null) _last = newNode;
        else {
            _last.next = newNode;
            _last = newNode;
        }
        if (_first == null) _first = newNode;
        N++;
    }

    public T dequeue() throws Exception {
        if (isEmpty()) 
            throw new Exception("queue is empty");

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

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
	}

    public static void main(String[] args) throws Exception {

        Queue<String> queue = new Queue<String>();

        Console console = System.console();
        if (console == null) {
            System.out.println("No console: non-interactive mode!");
            System.exit(0);
        }
        
        String inputLine;
        while(!(inputLine = console.readLine()).trim().equalsIgnoreCase("")){

            if (inputLine.equalsIgnoreCase("-"))
                System.out.println("dequque " +  queue.dequeue()) ;
            else
                queue.enqueue(inputLine);
        }
                
        for(String el : queue){
            System.out.println(el);
        }
    }

    


}