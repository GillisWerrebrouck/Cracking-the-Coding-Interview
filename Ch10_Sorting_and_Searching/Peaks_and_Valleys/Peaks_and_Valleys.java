/**
 * Algorithm to sort an array into an alternating sequence of peaks (max) and valleys (min).
 * 
 * @author Gillis Werrebrouck
 */

public class Peaks_and_Valleys {
    public static void main(final String args[]) {
        int[] array = new int[]{ 5, 3, 1, 2, 3 };

        sortPeaksAndValleys(array);

        System.out.print(array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.print(", " + array[i]);
        }
    }

    public static void sortPeaksAndValleys(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            int peakIndex = getMaxIndex(array, i-1, i, i+1);
            if (i != peakIndex) {
                int temp = array[i];
                array[i] = array[peakIndex];
                array[peakIndex] = temp;
            }
        }
    }

    public static int getMaxIndex(int[] array, int a, int b, int c) {
        int a_value = array[a];
        int b_value = array[b];
        int c_value = array[c];
        int max_value = Math.max(Math.max(a_value, b_value), c_value);

        if (a_value == max_value) {
            return a;
        } else if (b_value == max_value) {
            return b;
        }
        return c;
    }
}
