package homework1;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
        //The method returns an array of integers and takes an array of Entry objects (entries) and a String (searchableName) as parameters.
        int left = 0;
        int right = entries.length - 1;
        int firstOccurrence = -1;
        //Initializes the index of the first occurrence of searchableName to -1 (not found).
        int lastOccurrence = -1;
        //Initializes the index of the last occurrence of searchableName to -1 (not found).

        while (left <= right) {
            int mid = left + (right - left) / 2;
            //Here I calculated the middle index to avoid overflow.

            if (entries[mid].name.compareTo(searchableName) == 0) {
                // When a match is found, check for both first and last occurrences
                firstOccurrence = mid;
                lastOccurrence = mid;

                // Extend left to find the first occurrence
                int tempLeft = mid;
                while (tempLeft > left && entries[tempLeft - 1].name.compareTo(searchableName) == 0) {
                    //Continues the loop as long as the temporary left index is greater than the left boundary and the previous entry's name is equal to searchableName.
                    firstOccurrence = --tempLeft;
                }

                // Extend right to find the last occurrence
                int tempRight = mid;
                while (tempRight < right && entries[tempRight + 1].name.compareTo(searchableName) == 0) {
                    //Continues the loop as long as the temporary right index is less than the right boundary and the next entry's name is equal to searchableName.
                    lastOccurrence = ++tempRight;
                }

                break;
            } else if (entries[mid].name.compareTo(searchableName) < 0) {
                //If the middle entry's name is less than searchableName, it means searchableName is in the right half of the array.
                left = mid + 1;
            } else {
                //If the middle entry's name is greater than searchableName, it means searchableName is in the left half of the array.
                right = mid - 1;
            }
        }

        if (firstOccurrence == -1) {
            return new int[]{};
        }

        return new int[]{firstOccurrence, lastOccurrence};
    }
}

//The BinarySearch class contains a static method search that performs a binary search on an array of Entry objects.
//The method finds the first and last occurrences of searchableName in the sorted array.
//It returns an array with two integers: the index of the first occurrence and the index of the last occurrence.
// If searchableName is not found, it returns an empty array.
