package homework3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookV2 {
    public static void main(String[] args) {
        System.out.println("Loading the entries...");
        System.out.println("=======================================");
        //After printing the loading message above ->
        //Declare a RedBlackTree which will hold Entry objects:
        RedBlackTree<Entry> tree;
        try {
            tree = FileUtils.readFile("raw_phonebook_data.csv");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
        // In the above try-catch block, we first read entries from the file and store them in the tree
        //And then handle file not found exception

        System.out.println("System is ready.");

        int[] counts = tree.countRedAndBlackEdges(); //We count the edges in the tree
        System.out.println("Total " + "\033[31m" + "red edges " +"\033[0m" + "in the tree: " + counts[1]); //Print red tree edges
        System.out.println("Total black edges in the tree: " + counts[0] + "\n"); //Print black tree edges

        Scanner scanner = new Scanner(System.in); //This scanner will read user input and the loop below...
        while (true) {   //...will keep running until user enters -1
            System.out.println("Enter a name that you wish to search for, or -1 to exit:");
            String input = scanner.nextLine();
            if (input.equals("-1")) {
                System.out.println("Thank you for using the phonebook.");
                break;
            }

            ArrayList<Entry> entries = tree.get(input); //Now we get the entries with the given name using get of course
            if (entries == null) { //in the above line, if no entries are found (null), we print a message
                System.out.println("No entries with the given name exist in the phonebook.\n");
            } else {
                System.out.println("Entries found: " + entries.size() + "\n"); //Otherwise, we print the number of entries found
                for (Entry entry : entries) { //In this for loop we print each entry found
                    System.out.println(entry);
                }
            }
        }
        scanner.close();
    }
}