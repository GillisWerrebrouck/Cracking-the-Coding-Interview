/**
 * Algorithm to check if a string is one edit (insert, remove, replace) away from another string.
 * @author Gillis Werrebrouck
 */

public class One_Away {
    public static void main(String args[]) {
        if (args.length != 2) {
            System.out.println("Two parameters expected");
            return;
        }

        System.out.println("The strings \"" + args[0] + "\" is" + (isOneAway(args[0], args[1]) ? "" : "n't") + " one edit (insert, remove, replace) away from \"" + args[1] + "\".");
    }

    private static boolean isOneAway(String str1, String str2) {
        if(Math.abs(str1.length()-str2.length()) > 1) {
            return false;
        }

        boolean hasEdit = false;

        // get the longest and shortest string (or equal length)
        String s1 = str1.length() > str2.length() ? str1 : str2;
        String s2 = str1.length() > str2.length() ? str2 : str1;

        Integer s1Index = 0;
        Integer s2Index = 0;

        while(s1Index < s1.length() && s2Index < s2.length()) {
            if(s1.charAt(s1Index) != s2.charAt(s2Index)) {
                if(hasEdit) {
                    return false;
                }
                hasEdit = true;

                // if same length, then move the shortest string pointer
                if(s1.length() == s2.length()) {
                    s2Index++;
                }
            } else {
                // if same length, then move the shortest string pointer
                s2Index++;
            }
            // always move the longest string pointer
            s1Index++;
        }

        return true;
    }
}
