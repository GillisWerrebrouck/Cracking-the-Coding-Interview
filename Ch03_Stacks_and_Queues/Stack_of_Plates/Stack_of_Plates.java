import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Test for an implementation of a stack which holds multiple stacks that all have the same max size.
 * @author Gillis Werrebrouck
 */

public class Stack_of_Plates {
    public static void main(String args[]) {
        Balancing_Stack stack = new Balancing_Stack(5);

        for(int i = 0; i <= 30; i++) {
            stack.push(i);
        }
        System.out.println("Number of stacks: " + stack.getStackCount());

        for(int i = 0; i < 5; i++) {
            System.out.println(stack.pop());
        }
        System.out.println("Number of stacks: " + stack.getStackCount());

        for(int i = 0; i < 5; i++) {
            System.out.println(stack.popAt(2));
        }
        System.out.println("Number of stacks: " + stack.getStackCount());

        while(stack.getStackSize() > 0) {
            System.out.println(stack.pop());
        }
        System.out.println("Number of stacks: " + stack.getStackCount());
    }
}

class Balancing_Stack {
    ArrayList<Stack<Integer>> stack = new ArrayList<Stack<Integer>>();
    int maxSize;

    public Balancing_Stack(int maxSize) {
        this.maxSize = maxSize;
        stack.add(new Stack<Integer>());
    }

    public void push(int value) {
        int lastStackNumber = stack.size()-1;
        
        if(stack.get(lastStackNumber).size() >= this.maxSize) {
            stack.add(new Stack<Integer>());
            lastStackNumber++;
        }

        stack.get(lastStackNumber).push(value);
    }

    public int pop() {
        int lastStackNumber = stack.size()-1;

        if(stack.size() == 0) {
            throw new EmptyStackException();
        }

        int value = stack.get(lastStackNumber).pop();

        if(stack.get(lastStackNumber).size() == 0) {
            stack.remove(lastStackNumber);
        }

        return value;
    }

    public int getStackCount() {
        return stack.size();
    }

    public int getStackSize() {
        int lastStackNumber = stack.size()-1;

        if(lastStackNumber >= 0) {
            return (getStackCount()-1)*maxSize + stack.get(lastStackNumber).size();
        } else {
            return 0;
        }
    }

    public int popAt(int index) {
        if(stack.size() <= index) {
            throw new IndexOutOfBoundsException();
        } else if (stack.size()-1 == index) {
            return this.pop();
        }

        int value = stack.get(index).pop();
        
        shiftLeft(index);

        return value;
    }

    private void shiftLeft(int index) {
        stack.add(new Stack<Integer>());
        int lastStackNumber = stack.size()-1;

        for(int i = lastStackNumber-1; i > index; i--) {
            while(0 < stack.get(i).size()) {
                int tempValue = stack.get(i).pop();
                stack.get(i+1).push(tempValue);
            }
        }

        for(int i = index+1; i < lastStackNumber; i++) {
            int tempValue = stack.get(i+1).pop();
            stack.get(i-1).push(tempValue);

            while(0 < stack.get(i+1).size()) {
                tempValue = stack.get(i+1).pop();
                stack.get(i).push(tempValue);
            }
        }

        stack.remove(lastStackNumber);
        lastStackNumber--;
        if(stack.get(lastStackNumber).size() == 0) {
            stack.remove(lastStackNumber);
        }
    }

    public int peek() {
        int lastStackNumber = stack.size()-1;
        return stack.get(lastStackNumber).peek();
    }
}