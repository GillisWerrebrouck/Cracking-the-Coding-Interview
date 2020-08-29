/**
 * Algorithm to print all duplicates in an (unsorted) array of integers by only using 4KB of extra memory.
 * 
 * @author Gillis Werrebrouck
 */

public class Finding_Duplicates {
    public static void main(final String args[]) {
        int[] array = new int[]{ 1, 2, 3, 4, 5, 3, 2, 2, 4, 6, 7, 7, 5, 8 };
        BitVector bitVector = new BitVector(32000); // 32000 bits = 4000 bytes = 4KB
        
        for (int i = 0; i < array.length; i++) {
            if (bitVector.getBit(array[i])) {
                System.out.println(array[i]);
            } else {
                bitVector.setBit(array[i]);
            }
        }
    }
}

class BitVector {
    byte[] bitVector;

    public BitVector(int size) {
        this.bitVector = new byte[size / 8];
    }

    public void setBit(int n) {
        int i = n / 8;
        int j = n % 8;
        this.bitVector[i] |= 1 << j;
    }

    public boolean getBit(int n) {
        int i = n / 8;
        int j = n % 8;
        return (this.bitVector[i] & (1 << j)) == (1 << j);
    }
}
