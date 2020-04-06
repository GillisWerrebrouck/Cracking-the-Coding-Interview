import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Test for an implementation of a Queue by using 2 stacks.
 * @author Gillis Werrebrouck
 */

public class Queue_via_Stacks {
    public static void main(String args[]) {
        MyQueue queue = new MyQueue();

        for(int i = 0; i < 10; i++) {
            queue.add(i);
        }

        System.out.println(queue.remove());
        System.out.println(queue.remove());

        queue.add(25);
        queue.add(26);
        queue.add(27);
        
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        queue.add(41);

        System.out.println(queue.peek());
    }
}

class MyQueue {
    Stack<Integer> addStack = new Stack<Integer>();
    Stack<Integer> removeStack = new Stack<Integer>();

    public MyQueue() {}

    public void add(int value) {
        if(addStack.size() == 0 && removeStack.size() != 0) {
            switchStack();
        }

        addStack.push(value);
    }

    public int remove() {
        if(removeStack.size() == 0 && addStack.size() == 0) {
            throw new EmptyStackException();
        } else if(removeStack.size() == 0 && addStack.size() != 0) {
            switchStack();
        }

        return removeStack.pop();
    }

    public int peek() {
        if(removeStack.size() == 0 && addStack.size() == 0) {
            throw new EmptyStackException();
        } else if(removeStack.size() == 0 && addStack.size() != 0) {
            switchStack();
        }

        return removeStack.peek();
    }

    private void switchStack() {
        if(addStack.size() != 0) {
            while(addStack.size() != 0) {
                removeStack.push(addStack.pop());
            }
        } else {
            while(removeStack.size() != 0) {
                addStack.push(removeStack.pop());
            }
        }
    }
}