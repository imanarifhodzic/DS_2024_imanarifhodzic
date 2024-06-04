package homework3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtils {
    // Below method is to read a file and return a RedBlackTree containing Entry objects
    public static RedBlackTree<Entry> readFile(String filePath) throws FileNotFoundException {
        // Now we need to create a new RedBlackTree to store the Entry objects
        RedBlackTree<Entry> tree = new RedBlackTree<>();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        //The above two lines of code represent creating a File and Scanner object for the given file path and to read the file.

        //Now we go line by line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();  // Read the next line from the file
            String[] fields = line.split(";"); // Split the line into fields using ";" as the delimiter

            String name = fields[0];
            String streetAddress = fields[1];
            String city = fields[2];            //Extracting the individual fields
            String postcode = fields[3];
            String country = fields[4];
            String phoneNumber = fields[5];

            Entry entry = new Entry(name, streetAddress, city, postcode, country, phoneNumber); //Now we create a new Entry object, with the extracted fields
            tree.put(name, entry); //And of course add the entry object to the tree
        }

        scanner.close();
        return tree; //Return the populated tree
    }
}