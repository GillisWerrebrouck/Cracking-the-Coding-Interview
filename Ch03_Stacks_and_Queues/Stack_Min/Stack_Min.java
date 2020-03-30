import java.util.Stack;

/**
 * Test for an implementation of a stack which keeps track of its minimum.
 * @author Gillis Werrebrouck
 */

public class Stack_Min {
    public static void main(String args[]) {
        Min_Stack minStack = new Min_Stack();
        minStack.push(3);
        minStack.push(4);
        minStack.push(5);
        minStack.push(4);
        minStack.push(2);
        minStack.push(1);

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

class Min_Stack extends Stack<Integer> {
    Stack<Integer> min;

    public Min_Stack() {
        super();
        min = new Stack<Integer>();
    }

    public int getMin() {
        if (min.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return min.peek();
        }
    }

    public void push(int value) {
        if (value <= getMin())
            min.push(value);
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if(value == getMin())
            min.pop();
        return value;
    }
}