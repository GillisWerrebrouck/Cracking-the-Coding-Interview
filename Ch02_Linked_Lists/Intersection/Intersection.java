import CtCILibrary.LinkedListNode;
import CtCILibrary.LinkedList;

/**
 * Algorithm to determine the intersection of two singly linked lists if the two lists intersect.
 * @author Gillis Werrebrouck
 */

public class Intersection {
    public static void main(String args[]) {
        LinkedList list1 = new LinkedList(null);
        LinkedList list2 = new LinkedList(null);

        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2a = new LinkedListNode(2);
        LinkedListNode node2b = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);

        list1.appendToTail(node1);
        list1.appendToTail(node2a);
        list1.appendToTail(node3);
        list1.appendToTail(node4);

        list2.appendToTail(node2b);
        list2.appendToTail(node3);

        list1.print();
        list2.print();

        LinkedList intersection = getIntersection(list1, list2);
        System.out.print("Intersection: ");
        if(intersection != null) {
            intersection.print();
        } else {
            System.out.println("none");
        }
    }

    private static LinkedList getIntersection(LinkedList list1, LinkedList list2) {
        if(list1.length == 0 || list2.length == 0) {
            return null;
        }

        LinkedListNode node1 = getLastNode(list1);
        LinkedListNode node2 = getLastNode(list2);

        // if two lists intersect, then the last node of both lists will always be the same
        if(node1 != node2) {
            return null;
        }

        // get the longest and shortest list (or equal in length)
        node1 = (list1.length > list2.length) ? list1.node : list2.node;
        node2 = (list1.length < list2.length) ? list1.node : list2.node;

        // jump ahead n nodes in the longest list where n is the difference in length between the longest and shortest list
        for(int i = 0; i < Math.abs(list1.length-list2.length); i++) {
            node1 = node1.next;
        }

        // find the node at which the intersection starts
        while(node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return new LinkedList(node1);
    }

    private static LinkedListNode getLastNode(LinkedList list) {
        LinkedListNode node = list.node;
        while(node.next != null) {
            node = node.next;
        }
        return node;
    }
}
