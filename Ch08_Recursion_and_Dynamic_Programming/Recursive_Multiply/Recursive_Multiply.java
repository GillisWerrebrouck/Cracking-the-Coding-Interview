/**
 * Algorithm to multiply two numbers with as few operations as possible and without using the multiplication operation.
 * 
 * @author Gillis Werrebrouck
 */

public class Recursive_Multiply {
    public static void main(final String args[]) {
        System.out.println(multiply(4, 10));
        System.out.println(multiply(7, 6));
        System.out.println(multiply(2, 33));
        System.out.println(multiply(5, 1));
        System.out.println(multiply(1, 4));
        System.out.println(multiply(2, 0));
    }

    public static int multiply(int a, int b) {
        if (a > b) {
            int temp = b;
            b = a;
            a = temp;
        }

        if (a == 0) {
            return 0;
        } else if (a == 1) {
            return b;
        }

        int result = multiply(a >> 1, b);

        if (a % 2 == 0) {
            return result << 1;
        }
        return (result << 1) + b;
    }
}
