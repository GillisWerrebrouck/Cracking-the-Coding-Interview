/**
 * Algorithm to swap odd and even bits in an integer.
 * 
 * @author Gillis Werrebrouck
 */

public class Pairwise_Swap {
    public static void main(final String args[]) {
        System.out.println("swapped: " + swapBitPairs(29));
    }

    private static int swapBitPairs(int number) {
        int even = 0xAAAAAAAA & (number << 1);
        int odd = 0x55555555 & (number >>> 1);
        
        return even | odd;
    }
}
