/**
 * Algorithm to convert a double to a binary string representation.
 * 
 * @author Gillis Werrebrouck
 */

public class Binary_to_String {
    public static void main(final String args[]) {
        String binaryString = convertToBinaryString(0.152587890625);

        System.out.println("Binary string: " + binaryString);
    }

    private static String convertToBinaryString(double number) {
        if(number <= 0 || 1 <= number) {
            return "ERROR";
        }

        StringBuilder binaryString = new StringBuilder();
        binaryString.append(".");

        while(0 < number) {
            if(32 <= binaryString.length()) {
                return "ERROR";
            }

            double shiftedNumber = number * 2;
            if(1 <= shiftedNumber) {
                binaryString.append(1);
                number = shiftedNumber - 1;
            } else {
                binaryString.append(0);
                number = shiftedNumber;
            }
        }

        return binaryString.toString();
    }
}
