/**
 * Algorithm to count the number of bits to flip to convert int A to int B.
 * 
 * @author Gillis Werrebrouck
 */

public class Conversion {
    public static void main(final String args[]) {
        System.out.println("# of flips: " + getBitFlips(29, 15));
    }

    private static int getBitFlips(int A, int B) {
        int c = 0;
        for(int AB = A ^ B; AB != 0; AB = AB & (AB-1)) {
            c++;
        }
    
        return c;
    }
}
