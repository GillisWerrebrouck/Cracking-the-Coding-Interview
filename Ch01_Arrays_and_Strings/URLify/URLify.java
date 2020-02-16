/**
 * Algorithm to URLify a string.
 * Spaces become "%20".
 * @author Gillis Werrebrouck
 */

public class URLify {
    /**
     * @param args: 0: string to URLify, 1: true length
     */
    public static void main(String args[]) {
        if (args.length != 2) {
            System.out.println("Two parameters expected");
            return;
        }

        if (args[0].length() < Integer.parseInt(args[1])) {
            System.out.println("True length can't be longer than length of string");
            return;
        }
        
        String URLified = getUrl(args[0].toCharArray(), Integer.parseInt(args[1]));
        System.out.println("\"" + args[0] + "\" (true length: " + args[1] + ") --- URLified ---> \"" + URLified + "\"");
    }

    private static String getUrl(char[] url, Integer trueLength) {
        Integer spaces = 0;
        for(Integer index = 0; index < trueLength; index++) {
            if(url[index] == ' ') {
                spaces++;
            }
        }

        Integer newLength = spaces*2 + trueLength;
        char[] newUrl = new char[newLength];

        Integer newUrlPointer = newLength - 1;
        for(Integer index = trueLength-1; index >= 0; index--) {
            if(url[index] == ' ') {
                newUrl[newUrlPointer--] = '0';
                newUrl[newUrlPointer--] = '2';
                newUrl[newUrlPointer--] = '%';
            } else {
                newUrl[newUrlPointer--] = url[index];
            }
        }

        return new String(newUrl);
    }
}
