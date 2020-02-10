import java.util.Arrays;

/**
 * Algorithm to check if 2 strings are permutations.
 * @author Gillis Werrebrouck
 */

public class Permutation {
    public static void main(String args[]) {
        System.out.println("The strings \"" + args[0] + "\" and \"" + args[1] + "\" are" + (!IsPermutation(args[0], args[1]) ? "n't" : "") + " permutations.");
    }

    private static String sort(String str) {
        char sorted[] = str.toCharArray();
        Arrays.sort(sorted);
        return new String(sorted);
    }

    private static boolean IsPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        
        String sorted1 = sort(str1);
        String sorted2 = sort(str2);

        return sorted1.equals(sorted2);
    }
}
