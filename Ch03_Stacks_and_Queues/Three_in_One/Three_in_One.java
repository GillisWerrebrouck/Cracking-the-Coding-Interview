import CtCILibrary.MultiStack;

/**
 * Test for an implementation of a three stacks in one array class.
 * @author Gillis Werrebrouck
 */

public class Three_in_One {
    public static void main(String args[]) {
        MultiStack multiStack = new MultiStack(3, 5);
        multiStack.push(0, 11);
        multiStack.push(0, 12);
        System.out.println(multiStack.pop(0));

        multiStack.push(1, 21);
        multiStack.push(1, 22);

        multiStack.push(2, 31);
        multiStack.push(2, 32);
        multiStack.push(2, 33);
        multiStack.push(2, 34);
        System.out.println(multiStack.pop(2));

        System.out.println(multiStack.peek(0));
        System.out.println(multiStack.peek(1));
        System.out.println(multiStack.peek(2));
    }
}
