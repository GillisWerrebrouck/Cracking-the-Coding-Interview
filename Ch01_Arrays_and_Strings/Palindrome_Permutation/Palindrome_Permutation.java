import java.util.Arrays;

/**
 * Algorithm to check if a string is a permutation of a palindrome.
 * @author Gillis Werrebrouck
 */

public class Palindrome_Permutation {
    public static void main(String args[]) {
        System.out.println("The strings \"" + args[0] + "\" is" + (isPalindromeOfPermutation(args[0]) ? "" : "n't") + " a permutation of a palindrome.");
    }

    private static String sort(String str) {
        char sorted[] = str.toCharArray();
        Arrays.sort(sorted);
        return new String(sorted);
    }

    private static boolean isPalindromeOfPermutation(String str) {
        String sorted = sort(str.toLowerCase());
        
        // boolean to know if an odd count of a char has occured or not, this can at most happen once in a palindrome
        boolean canHaveOddCharCount = true;

        for(Integer index = 0; index < sorted.length(); index++) {
            if(sorted.charAt(index) == ' ') continue;

            Integer countChar = 1;
            Integer innerIndex = index+1;

            while(sorted.length() > innerIndex && sorted.charAt(index) == sorted.charAt(innerIndex)) {
                countChar++;
                innerIndex++;
            }

            if(countChar % 2 != 0) {
                if(!canHaveOddCharCount) {
                    return false;
                }
                canHaveOddCharCount = false;
            }

            index = innerIndex-1;
        }

        return true;
    }
}
