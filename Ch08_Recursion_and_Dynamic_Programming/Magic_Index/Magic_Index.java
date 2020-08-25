/**
 * Algorithm to find a magic index in a list of integers using a binary search variant.
 * 
 * @author Gillis Werrebrouck
 */

public class Magic_Index {
    public static void main(final String args[]) {
        int[] numbers = new int[]{
            -3, -2, -1 , 0, 4, 6, 7, 8,
        };
        System.out.println(findMagicIndex(numbers));
    }

    public static Integer findMagicIndex(int[] list) {
        return findMagicIndex(list, 0, list.length);
    }

    public static Integer findMagicIndex(int[] list, int l, int r) {
        int m = l + (r - l)/2;

        if (l == r) {
            return null;
        }

        if (list[m] == m) {
            return m;
        } else if (list[m] > m) {
            return findMagicIndex(list, l, m);
        }
        return findMagicIndex(list, m+1, r);
    }
}
