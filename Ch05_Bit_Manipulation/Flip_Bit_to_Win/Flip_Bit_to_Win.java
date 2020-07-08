/**
 * Algorithm to count the longest sequence of 1's if one zero can be flipped so that two sub sequences of 1's are merged.
 * 
 * @author Gillis Werrebrouck
 */

public class Flip_Bit_to_Win {
    public static void main(final String args[]) {
        System.out.println(findLongestSequence(1775));
    }

    private static int findLongestSequence(int number) {
        if(~0 == number) return Integer.BYTES * 8;

        int prevSequenceLength = 0;
        int currentSequenceLength = 0;
        int longestMergedSequence = 0;

        for(int i = 0; i < Integer.BYTES * 8; i++) {
            if((number & 1) == 1) {
                currentSequenceLength++;
            } else if ((number & 1) == 0) {
                if ((number & 2) == 0) {
                    prevSequenceLength = 0;
                } else {
                    prevSequenceLength = currentSequenceLength;
                }
                currentSequenceLength = 0;
            }
            
            int mergedLength = prevSequenceLength + 1 + currentSequenceLength;
            if(longestMergedSequence < mergedLength) {
                longestMergedSequence = mergedLength;
            }
            number >>>= 1;
        }

        return longestMergedSequence < 3 ? 0 : longestMergedSequence;
    }
}
