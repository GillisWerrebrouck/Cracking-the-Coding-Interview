import java.util.Stack;

/**
 * Algorithm to sort a stack using no other datastructure except for 1 extra stack.
 * @author Gillis Werrebrouck
 */

public class Sort_Stack {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(4);
        stack.push(9);
        stack.push(1);
        stack.push(6);
        stack.push(2);
        stack.push(8);

        printStack(stack);
        
        sortStack(stack);
        printStack(stack);
    }

    public static void printStack(Stack<Integer> initStack) {
        Stack<Integer> stack = (Stack<Integer>) initStack.clone();

        System.out.print(stack.pop());
        while(stack.size() > 0) {
            System.out.print(" - " + stack.pop());
        }
        System.out.print("\n");
    }

    // O(N^2) time complexity and O(N) space complexity
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<Integer>();
        int temp;

        tempStack.push(stack.pop());
        while(stack.size() > 0) {
            temp = stack.pop();
            if(temp >= tempStack.peek()) {
                tempStack.push(temp);
            } else {
                while(tempStack.size() > 0 && tempStack.peek() > temp) {
                    stack.push(tempStack.pop());
                }
                tempStack.push(temp);
            }
        }

        while(tempStack.size() > 0) {
            stack.push(tempStack.pop());
        }
    }
}
