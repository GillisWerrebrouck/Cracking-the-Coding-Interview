import CtCILibrary.LinkedListNode;
import CtCILibrary.LinkedList;

/**
 * Algorithm to detect if a linked list has a loop and at what node the loop starts.
 * @author Gillis Werrebrouck
 */

public class Loop_Detection {
    public static void main(String args[]) {
        LinkedList list = new LinkedList(null);

        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node5 = new LinkedListNode(5);

        list.appendToTail(node1);
        list.appendToTail(node2);
        list.appendToTail(node3);
        list.appendToTail(node4);
        list.appendToTail(node5);
        list.appendToTail(node2);

        LinkedListNode startOfLoop = list.detectLoop();
        if(startOfLoop != null) {
            System.out.println("Loop detected with start of loop at; " + startOfLoop.data);
        } else {
            System.out.print("No loop detected in list; ");
        }
        list.print();
    }
}
