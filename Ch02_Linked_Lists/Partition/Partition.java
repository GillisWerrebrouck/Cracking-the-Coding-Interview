import CtCILibrary.LinkedListNode;

/**
 * Algorithm to partition a linked list such that all nodes with a value lower than the partition value come before all nodes with a value higher or equal to the partition value.
 * @author Gillis Werrebrouck
 */

public class Partition {
    public static void main(String args[]) {
        LinkedListNode node = new LinkedListNode(3);
        node.appendToTail(5);
        node.appendToTail(8);
        node.appendToTail(5);
        node.appendToTail(10);
        node.appendToTail(2);
        node.appendToTail(1);

        printLinkedList(node);

        node = partition_2(node, 5);
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

    // stable method
    private static LinkedListNode partition_1(LinkedListNode node, int partition) {
        LinkedListNode startLow = null;
        LinkedListNode endLow = null;
        LinkedListNode startHigh = null;
        LinkedListNode endHigh = null;

        while(node != null) {
            LinkedListNode next = node.next;
            node.next = null;

            if(node.data < partition) {
                if(startLow == null) {
                    startLow = node;
                    endLow = startLow;
                } else {
                    endLow.next = node;
                    endLow = node;
                }
            } else {
                if(startHigh == null) {
                    startHigh = node;
                    endHigh = startHigh;
                } else {
                    endHigh.next = node;
                    endHigh = node;
                }
            }

            node = next;
        }

        if(startLow == null) {
            return startHigh;
        }

        endLow.next = startHigh;
        return startLow;
    }

    // unstable method without the use of 4 variables to keep track of the linked lists
    private static LinkedListNode partition_2(LinkedListNode node, int partition) {
        LinkedListNode low = node;
        LinkedListNode high = node;

        while(node != null) {
            LinkedListNode next = node.next;
            
            if(node.data < partition) {
                node.next = low;
                low = node;
            } else {
                high.next = node;
                high = node;
            }

            node = next;
        }
        
        high.next = null;
        return low;
    }
}
