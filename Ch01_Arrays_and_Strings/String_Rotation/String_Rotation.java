import java.util.Random;

/**
 * Algorithm to check if a string is a rotation of another string by using only one call to the method isSubstring.
 * @author Gillis Werrebrouck
 */

public class String_Rotation {
    public static void main(String args[]) {
        if (args.length != 2) {
            System.out.println("Two parameter expected");
            return;
        }

        System.out.println("The string \"" + args[1] + "\" is" + (isRotation(args[0], args[1]) ? "" : " not") + " a rotation of \"" + args[0] + "\"");
    }

    private static boolean isSubstring(String str1, String str2) {
        return str1.contains(str2);
    }

    private static boolean isRotation(String str1, String str2) {
        if(str1.length() == str2.length() && str1.length() > 0) {
            String concatenatedString = str1 + str1;
            return isSubstring(concatenatedString, str2);
        }
        return false;
    }
}
