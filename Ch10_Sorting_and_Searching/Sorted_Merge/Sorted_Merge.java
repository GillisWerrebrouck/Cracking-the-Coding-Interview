/**
 * Algorithm to merge 2 sorted arrays A and B into A.
 * 
 * @author Gillis Werrebrouck
 */

public class Sorted_Merge {
    public static void main(final String args[]) {
        Integer[] A = new Integer[]{ 1, 2, 3, 6, 8, 10, null, null, null, null };
        Integer[] B = new Integer[]{ 4, 5, 7, 9 };

        merge(A, B, 6, B.length);

        System.out.print(A[0]);
        for (int i = 1; i < A.length; i++) {
            System.out.print(", " + A[i]);
        }
    }

    public static void merge(Integer[] A, Integer[] B, int sizeA, int sizeB) {
        int aIndex = sizeA - 1;
        int bIndex = sizeB - 1;
        int aPointer = sizeA + sizeB - 1;

        for (; 0 <= aIndex && 0 <= bIndex; bIndex--) {
            if (A[aIndex] <= B[bIndex]) {
                A[aPointer] = B[bIndex];
            } else {
                A[aPointer] = A[aIndex];
                aIndex--;
                bIndex++;
            }
            aPointer--;
        }

        while (0 <= bIndex) {
            A[aPointer--] = B[bIndex--];
        }
    }
}
