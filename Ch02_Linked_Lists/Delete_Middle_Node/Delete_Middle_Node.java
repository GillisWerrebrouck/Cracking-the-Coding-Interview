import java.util.Random;

import CtCILibrary.LinkedListNode;

/**
 * Algorithm to delete a node that is not the first or last node in a singly linked list, given only the node to be deleted.
 * @author Gillis Werrebrouck
 */

public class Delete_Middle_Node {
    public static void main(String args[]) {
        LinkedListNode node = generateLinkedList(10);
        printLinkedList(node);

        deleteNode(node.next.next);
        printLinkedList(node);
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

    private static boolean deleteNode(LinkedListNode node) {
        if(node == null || node.next == null) {
            return false;
        }

        node.data = node.next.data;
        node.next = node.next.next;
        return true;
    }
}
