package homework3;

import java.util.ArrayList;
 //The Node class is designed to store a key, an ArrayList of values,
 //and pointers to right and left child nodes, with a color attribute.
public class Node<Entry> {
    public String key; //This key represents the node's key
    public ArrayList<Entry> values;
    public Node<Entry> left, right; //These are pointers to the left and right child nodes
    public boolean color; //True and False represent red and black colors

    public Node(String key, Entry value) {
        this.key = key; //We will initialize the key attribute with the provided key.
        this.values = new ArrayList<>(); //And of course initialize the values attribute as a new ArrayList
        this.values.add(value);
        this.left = null;   //We put or initialize the left and right child pointers to null
        this.right = null;
        this.color = true; //By initializing the color attribute to true, set the color to red by default.
    }
}