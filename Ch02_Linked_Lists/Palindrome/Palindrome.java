import CtCILibrary.LinkedListNode;
import CtCILibrary.LinkedList;

/**
 * Algorithm to add two numbers represented by a linked list and return the result as a linked list.
 * @author Gillis Werrebrouck
 */

public class Palindrome {
    public static void main(String args[]) {
        LinkedListNode node = new LinkedListNode(3);
        LinkedList list = new LinkedList(node);
        list.appendToTail(5);
        list.appendToTail(7);
        list.appendToTail(11);
        list.appendToTail(13);
        list.appendToTail(11);
        list.appendToTail(7);
        list.appendToTail(5);
        list.appendToTail(3);

        list.print();
        System.out.println("[iterative method]\tThis linked list is" + (isPalindrome(list) ? "" : "n't") + " a palindrome");
        System.out.println("[recursive method]\tThis linked list is" + (isPalindromeRec(list.node, list.length).result ? "" : "n't") + " a palindrome");
    }

    /**
     * Check if a linked list is a palindrome by reversing the first half of the list and by comparing that to the second half of the list
     * O(n) time and O(n) space
     * @param list
     * @return boolean
     */
    // O(n) time and O(n) space
    public static boolean isPalindrome(LinkedList list) {
        LinkedList backwards = new LinkedList(null);
        LinkedListNode pointer = list.node;

        for(int i = 0; i < list.length/2; i++) {
            backwards.appendToFront(pointer.data);
            pointer = pointer.next;
        }

        if(list.length % 2 == 1) {
            pointer = pointer.next;
        }

        LinkedListNode backwardsPointer = backwards.node;

        for(int i = 0; i < list.length/2; i++) {
            if(pointer.data != backwardsPointer.data) {
                return false;
            }

            pointer = pointer.next;
            backwardsPointer = backwardsPointer.next;
        }

        return true;
    }

    /**
     * Check if a linked list is a palindrome by recursively compare front and back nodes of a list
     * O(n) time and O(n) space (due to the recursive function calls)
     * @param node, length
     * @return Result
     */
    public static Result isPalindromeRec(LinkedListNode node, int length) {
        if(node == null || length <= 0) {
            return new Result(node, true);
        } else if (length == 1) {
            return new Result(node.next, true);
        }

        Result result = isPalindromeRec(node.next, length - 2);

        if(!result.result || result.node == null) {
            return result;
        }

        result.result = (node.data == result.node.data);

        result.node = result.node.next;

        return result;
    }
}

class Result {
    LinkedListNode node;
    boolean result;

    public Result(LinkedListNode node, boolean result) {
        this.node = node;
        this.result = result;
    }
}
