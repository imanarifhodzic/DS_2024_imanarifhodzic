package homework1;


import java.io.*;
import java.util.List;

public class FileUtils {

    public static Entry[] readFile(String filePath) throws FileNotFoundException {
        //Entry[] readFile(String filePath): The method returns an array of Entry objects and takes a file path as a parameter.
        // implement the actual logic (remove next line)

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            //Creates a BufferedReader wrapped around a FileReader to read the file at filePath.
            List<String> lines = reader.lines().toList();
            Entry[] returnThisArray = new Entry[lines.size() - 1];
            for (int i = 1; i < lines.size(); i++) {
                //I put (index 1) to skip the header.
                String[] split = lines.get(i).split(";");
                Entry newEntry = new Entry(split[0], split[1], split[2], split[3], split[4], split[5]);
                //this will create me a new Entry object using the split array elements.
                returnThisArray[i - 1] = newEntry;
            }

            reader.close();
            return returnThisArray;
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }

    //here I start the writeToFile method:
    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        // implement the actual logic

        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        for(Entry entry: entries) {
            //Iterates over each Entry object in the entries array.
            writer.write(String.format("%s;%s;%s;%s;%s;%s\n", entry.name, entry.streetAddress, entry.city, entry.postcode, entry.country, entry.phoneNumber));
            //Writes each Entry object to the file in CSV format using String.format.
        }
        writer.close();
    }
}

//Further explanation of what I did:
//The FileUtils class provides the utility methods for reading from and writing to the CSV files.
//The readFile method reads a CSV file, skips the header, and returns an array of Entry objects.
//The writeToFile method writes an array of Entry objects to a CSV file.
//Exception handling is implemented to ensure proper operation and error reporting.
