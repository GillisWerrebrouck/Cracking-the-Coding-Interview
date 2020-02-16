import java.util.HashSet;
import java.util.Random;

import CtCILibrary.LinkedListNode;

/**
 * Algorithm to remove duplicates in a linked list.
 * 
 * @author Gillis Werrebrouck
 */


public class Remove_Dups {
    public static void main(String args[]) {
        LinkedListNode node = generateLinkedList(10);
        printLinkedList(node);
        removeDuplicates_1(node);
        printLinkedList(node);

        node = generateLinkedList(10);
        printLinkedList(node);
        removeDuplicates_1(node);
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

    private static void removeDuplicates_1(LinkedListNode node) {
        HashSet<Integer> hashset = new HashSet<Integer>();

        hashset.add(node.data);

        while(node.next != null) {
            if(hashset.contains(node.next.data)) {
                node.next = node.next.next;
            } else {
                hashset.add(node.next.data);
                node = node.next;
            }
        }
    }

    private static void removeDuplicates_2(LinkedListNode node) {
        LinkedListNode runner = node.next;

        while(node != null) {
            runner = node;

            while(runner.next != null) {
                if(runner.next.data == node.data) {
                    runner.next = runner.next.next;
                }
                runner = runner.next;
            }

            node = node.next;
        }
    }
}
