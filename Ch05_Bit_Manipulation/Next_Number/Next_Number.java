/**
 * Algorithm to get the next smallest and next largest number with the same number of 1-bit's. (credits: solution from the book "Cracking the Coding Interview")
 * 
 * @author Gillis Werrebrouck
 */

public class Next_Number {
    public static void main(final String args[]) {
        System.out.println("Next largest number with equal number of 1-bit's: " + getNext(13948));
        System.out.println("Next smallest number with equal number of 1-bit's: " + getPrevious(13948));
    }

    private static int getNext(int number) {
        int c = number;
        int c0 = 0;
        int c1 = 0;

        while(((c & 1) == 0) && c != 0) {
            c0++;
            c >>= 1;
        }

        while((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        if(c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }
        
        // position of right most non-trailing zero
        int p = c0 + c1;

        // flip rightmost non-trailing zero
        number |= (1 << p);
        // clear all bits to the right of p
        number &= ~((1 << p) - 1);
        // insert c1-1 1's to the right
        number |= (1 << (c1 - 1)) - 1;

        return number;
    }

    private static int getPrevious(int number) {
        int c = number;
        int c0 = 0;
        int c1 = 0;

        while((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        if(c == 0) {
            return -1;
        }

        while(((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }
        
        // position of right most non-trailing zero
        int p = c0 + c1;

        // clear from bit p onwards
        number &= ((~0) << (p + 1));
        // sequence of (c1+1) 1's
        int mask = (1 << (c1 + 1)) - 1;
        number |= mask << (c0 - 1);

        return number;
    }
}
