import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Algorithm to find a missing integer in a big file.
 * Solution from the book Cracking the Coding Interview.
 * 
 * @author Gillis Werrebrouck
 */

public class Missing_Int {
    public static void main(final String args[]) {
        try {
            findOpenNumber("numbers.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void findOpenNumber(String filename) throws FileNotFoundException {
        long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
        byte[] bitfield = new byte[(int) (numberOfInts / 8)];

        Scanner in = new Scanner(new FileReader(filename));
        while (in.hasNextInt()) {
            int n = in.nextInt();
            bitfield[n / 8] |= 1 << (n % 8);
        }

        for (int i = 0; i < bitfield.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((bitfield[i] & (1 << j)) == 0) {
                    System.out.println(i * 8 + j);
                    return;
                }
            }
        }
    }
}
