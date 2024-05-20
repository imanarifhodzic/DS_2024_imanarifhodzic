package homework1;

public class MergeSort {

    public static void sort(Entry[] entries) {
        Entry[] aux = new Entry[entries.length]; //This array is used during the merge process to avoid repeatedly creating new arrays.
        sort(entries, aux, 0, entries.length - 1); //Calls the private sort method to start the recursive sorting process with the entire array
    }

    private static void sort(Entry[] entries, Entry[] aux, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2; //Calculates the middle index of the current array segment.
        sort(entries, aux, low, mid);
        sort(entries, aux, mid + 1, high);
        merge(entries, aux, low, mid, high);
    }

    private static void merge(Entry[] entries, Entry[] aux, int low, int mid, int high) { //A method that merges two sorted halves of the array segment into a single sorted segment.
        for (int k = low; k <= high; k++) { //Copies the current segment of entries into aux.
            aux[k] = entries[k];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                entries[k] = aux[j++]; //If all elements in the left half have been processed, copy the remaining elements from the right half.
            } else if (j > high) {
                entries[k] = aux[i++]; //If all elements in the right half have been processed, copy the remaining elements from the left half.
            } else if (less(aux[j], aux[i])) {
                entries[k] = aux[j++]; //If the current element in the right half is less than the current element in the left half, copy the element from the right half.
            } else {
                entries[k] = aux[i++]; //Otherwise, copy the element from the left half.
            }
        }
    }

    public static boolean less(Entry v, Entry w) {

        return v.compareTo(w) < 0; //Uses the compareTo method of the Entry class to compare the two entries.
    }
}
