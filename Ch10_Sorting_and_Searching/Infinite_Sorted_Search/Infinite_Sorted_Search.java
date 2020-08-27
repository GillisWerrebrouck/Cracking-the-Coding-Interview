import java.util.ArrayList;

/**
 * Algorithm to search for a value in a sorted array without knowing the length of the array.
 * 
 * @author Gillis Werrebrouck
 */

public class Infinite_Sorted_Search {
    public static void main(final String args[]) {
        ArrayList<Integer> infinite_arr = new ArrayList<>();
        for (int i = 0; i <= 10000000; i++) {
            infinite_arr.add(i);
        }

        int value = 3456789;
        int index = infinite_search(infinite_arr, value);
        
        if (0 <= index) {
            System.out.println("index " + index + " holds the value " + value);
        } else {
            System.out.println("value " + value + " not found");
        }
    }

    public static int elementAt(ArrayList<Integer> arr, int index) {
        if (arr.size() <= index) {
            return -1;
        }
        return arr.get(index);
    }

    public static int infinite_search(ArrayList<Integer> arr, int value) {
        int index = 1;

        while (elementAt(arr, index) != -1 && elementAt(arr, index) < value) {
            index *= 2;
        }
        return binary_search(arr, value, index / 2, index);
    }

    public static int binary_search(ArrayList<Integer> arr, int value, int l, int r) {
        if(l > r) {
            return -1;
        }

        int m = l + ((r-l) / 2);

        if (elementAt(arr, m) == -1) {
            return binary_search(arr, value, l, m-1);
        }

        if (elementAt(arr, m) == value) {
            return m;
        } else if (value < elementAt(arr, m)) {
            return binary_search(arr, value, l, m-1);
        }
        return binary_search(arr, value, m+1, r);
    }
}
