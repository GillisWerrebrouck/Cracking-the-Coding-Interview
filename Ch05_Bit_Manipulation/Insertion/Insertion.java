/**
 * Algorithm to insert a 32-bit number into another 32-bit number, starting at bit j and ending at bit i.
 * 
 * @author Gillis Werrebrouck
 */

public class Insertion {
    public static void main(final String args[]) {
        int result = insert(1024, 19, 2, 6);

        System.out.println("Insert result: " + Integer.toString(result));
    }

    private static int insert(int n, int m, int i, int j) {
        int firstPart = (~0) << (j+1);
        int secondPart = (1 << i) - 1;

        int mask = firstPart | secondPart;

        int maskedN = n & mask;
        int shiftedM = m << i;

        return maskedN | shiftedM;
    }
}
