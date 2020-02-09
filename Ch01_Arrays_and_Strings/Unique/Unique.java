import java.util.Arrays;
import java.util.Hashtable;

/**
 * Algorithm to check if a string (assuming it's an ASCI string) has all unique characters.
 * @author Gillis Werrebrouck
 */

public class Unique {
    public static void main(String args[]) {
        System.out.println("[METHOD 1]\tThe string \"" + args[0] + "\" " + (IsUnique_1(args[0]) == false ? "doesn't have" : "has") + " all unique characters.");
        System.out.println("[METHOD 2]\tThe string \"" + args[0] + "\" " + (IsUnique_2(args[0]) == false ? "doesn't have" : "has") + " all unique characters.");
    }

    // method using a hashtable
    private static boolean IsUnique_1(String str) {
        // cannot be longer then extended ASCI range to have all unique characters
        if (str.length() > 256) return false;

        // can also be accomplished by using a boolean array
        Hashtable<Integer, String> letters = new Hashtable<Integer, String>();

        for(Integer index = 0; index < str.length(); index++) {
            char letter = str.charAt(index);
            if(letters.contains(String.valueOf(letter))) {
                return false;
            } else {
                letters.put((int)letter, String.valueOf(letter));
            }
        }

        return true;
    }

    // method without additional data structures
    private static boolean IsUnique_2(String str) {
        // cannot be longer then extended ASCI range to have all unique characters
        if (str.length() > 256) return false;

        char sorted[] = str.toCharArray();
        Arrays.sort(sorted);

        for(Integer index = 0; index < sorted.length-1; index++) {
            char letter = sorted[index];
            if (letter == sorted[index+1]) {
                return false;
            }
        }

        return true;
    }
}
