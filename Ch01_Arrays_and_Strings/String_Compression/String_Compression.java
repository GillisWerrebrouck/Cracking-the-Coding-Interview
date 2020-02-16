/**
 * Algorithm to compress a string using the counts of repeated characters.
 * @author Gillis Werrebrouck
 */

public class String_Compression {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("One parameter expected");
            return;
        }

        System.out.println(compress(args[0]));
    }

    private static Integer countCompressionLength(String original) {
        Integer compressionCount = 0;

        for(Integer index = 0; index < original.length(); index++) {
            Integer innerIndex = index+1;
            while(original.length() > innerIndex && original.charAt(index) == original.charAt(innerIndex)) {
                innerIndex++;
            }
            compressionCount += 2;
            index=innerIndex-1;
        }

        return compressionCount;
    }

    private static String compress(String original) {
        Integer compressionLength = countCompressionLength(original);
        if(compressionLength >= original.length()) {
            return original;
        }

        StringBuilder compressed = new StringBuilder(compressionLength);

        for(Integer index = 0; index < original.length(); index++) {
            Integer innerIndex = index+1;
            while(original.length() > innerIndex && original.charAt(index) == original.charAt(innerIndex)) {
                innerIndex++;
            }
            compressed.append(original.charAt(index));
            compressed.append(innerIndex - index);
            index=innerIndex-1;
        }

        return compressed.toString();
    }
}
