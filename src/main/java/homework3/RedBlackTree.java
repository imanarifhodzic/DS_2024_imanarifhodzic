package homework3;

import java.util.ArrayList;

public class RedBlackTree<Entry> {
    private Node<Entry> root; //This represents the root node of the tree
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public ArrayList<Entry> get(String searchableName) {
        Node<Entry> x = root;
        int redEdges = 0;
        int blackEdges = 0;

        while (x != null) {
            int cmp = searchableName.compareTo(x.key);
            if (cmp < 0) {
                if (x.color == RED) redEdges++;
                else blackEdges++;
                x = x.left;
            } else if (cmp > 0) {
                if (x.color == RED) redEdges++;
                else blackEdges++;
                x = x.right;
            } else {
                System.out.println("\033[31m"+"Red edges " + "\033[0m" + "on the path: " + redEdges);
                System.out.println("Black edges on the path: " + blackEdges);
                return x.values;
            }
        }
        return null;

        //Everything above searches for entries by name in the tree, printing the number of red and black edges on the search path.
    }

    public void put(String searchableName, Entry entry) {
        root = put(root, searchableName, entry);
        root.color = BLACK;
        //// Method to insert an entry into the tree, and then color root black.
    }

    private Node<Entry> put(Node<Entry> h, String searchableName, Entry entry) {
        if (h == null) return new Node<>(searchableName, entry);

        int cmp = searchableName.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, searchableName, entry);
        else if (cmp > 0) h.right = put(h.right, searchableName, entry);
        else h.values.add(entry);
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        return h;

        //Above we recursively insert an entry and maintain Red-Black Tree properties through the rotations and color flipping.
    }

    public int[] countRedAndBlackEdges() {
        int[] counts = new int[2];
        countEdges(root, counts);
        return counts;
    }
    private void countEdges(Node<Entry> x, int[] counts) {
        if (x == null) return;
        if (x.color == RED) counts[1]++;
        else counts[0]++;
        countEdges(x.left, counts);
        countEdges(x.right, counts);
    }
    //Everything above counts the number of red and black edges in the tree (countRedAndBlackEdges, countEdges).

    private boolean isRed(Node<Entry> x) {
        if (x == null) return false;
        return x.color == RED;
    }
    private Node<Entry> rotateLeft(Node<Entry> h) {
        Node<Entry> x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    private Node<Entry> rotateRight(Node<Entry> h) {
        Node<Entry> x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    private void flipColors(Node<Entry> h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }
}
//And all these above, contain helper methods to check node color, perform left and right rotations, and flip colors.
//This RedBlackTree class provides us wil the ability to insert and retrieve entries while maintaining balanced tree properties

