/**
 * Algorithm to search in a rotated array.
 * 
 * @author Gillis Werrebrouck
 */

public class Search_in_Rotated_Array {
    public static void main(final String args[]) {
        int[] rotatedArray = new int[]{ 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
        int value = 5;
        int index = search_rotated_array(rotatedArray, value);

        if (0 <= index) {
            System.out.println("index " + index + " holds the value " + value);
        } else {
            System.out.println("value " + value + " not found");
        }
    }

    public static int search_rotated_array(int[] array, int value) {
        return search_rotated_array(array, value, 0, array.length-1);
    }

    public static int search_rotated_array(int[] array, int value, int l, int r) {
        int m = l + ((r-l) / 2);

        if (array[m] == value) {
            return m;
        } else if (array[l] <= array[m]) {
            if (array[l] <= value && value <= array[m]) {
                return search_rotated_array(array, value, l, m-1);
            }
            return search_rotated_array(array, value, m+1, r);
        }

        if (array[m] <= value && value <= array[r]) {
            return search_rotated_array(array, value, m+1, r);
        }
        return search_rotated_array(array, value, l, m-1);
    }
}
