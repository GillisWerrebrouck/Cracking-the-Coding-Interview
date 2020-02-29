import java.util.Random;

import CtCILibrary.LinkedListNode;

/**
 * Algorithm to find the Kth to last element of a singly linked list.
 * @author Gillis Werrebrouck
 */

public class Return_Kth_to_Last {
    public static void main(String args[]) {
        LinkedListNode node = generateLinkedList(10);
        printLinkedList(node);

        printKthToLast_1(node, 3);
        printKthToLast_2(node, 3);
    }

    private static LinkedListNode generateLinkedList(Integer length) {
        Random random = new Random();
        LinkedListNode node = new LinkedListNode(random.nextInt(10)+1);

        for(Integer index = 0; index < length-1; index++) {
            node.appendToTail(random.nextInt(10)+1);
        }

        return node;
    }

    private static void printLinkedList(LinkedListNode node) {
        while(node != null) {
            System.out.print(node.data + (node.next != null ? " -> " : "\n"));
            node = node.next;
        }
    }

    /**
     * Non-recursive/iterative method
     * O(n) time and O(1) space
     * @param node
     * @param k
     * @return kth from last node
     */
    private static void printKthToLast_1(LinkedListNode node, int k) {
        // a pointer k nodes ahead of node
        LinkedListNode kthPointer = node;

        for(int i = 0; k>i; i++) {
            if(kthPointer == null) {
                System.err.println("Index (k) out of bounds exception");
                return;
            }
            kthPointer = kthPointer.next;
        }

        while(kthPointer.next != null) {
            node = node.next;
            kthPointer = kthPointer.next;
        }

        System.out.println(node.data);
    }

    /**
     * Recursive method
     * O(n) time and O(n) space due to its recursive calls
     * @param node
     * @param k
     * @return kth from last node
     */
    private static int printKthToLast_2(LinkedListNode node, int k) {
        if(node.next == null) {
            return 0;
        }

        int index = printKthToLast_2(node.next, k)+1;

        if(index == k) {
            System.out.println(node.data);
        }

        return index;
    }
}
