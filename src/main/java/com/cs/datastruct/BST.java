package com.cs.datastruct;
import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root = null;

    private class Node{
        private Key key;
        private Value val;
        private Node left;
        private Node right;

        public Node(Key key, Value val){
            this.key = key;
            this.val = val;            
        }
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void put(Key key, Value val){
        root = put(root, key, val);
    }

    public Value get(Key key){
        return get(root, key);
    }
    private Value get(Node x, Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    private Node put(Node x, Key key, Value val){
        if (x == null) return new Node(key, val);
        int cmp =  key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        return x;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    // public Iterable<Key> keys(){
    //     Queue<Key> keys = new Queue<Key>();
    //     return keys;
    // }

    public static void main(String[] args) throws IOException {
        BST<String, Integer> st = new BST<String, Integer>();
        int ch;
        StringBuffer sb = new StringBuffer();
        while ((ch = System.in.read ()) != -1){
            char chr = (char) ch;
            sb.append(chr);
        }        

        //split whitespace or line break
        String[] words = sb.toString().split("[\\n\\s]");
        for(String s : words){
            if (!s.isEmpty()){
                if (st.contains(s)){
                    Integer v = st.get(s) + 1;
                    st.put(s,v); 
                }
                else
                st.put(s, 1);       
            }                                        
        }
        



    }
}