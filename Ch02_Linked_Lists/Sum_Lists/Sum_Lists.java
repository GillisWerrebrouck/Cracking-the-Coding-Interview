import CtCILibrary.LinkedListNode;
import CtCILibrary.LinkedList;

/**
 * Algorithm to add two numbers represented by a linked list and return the result as a linked list.
 * @author Gillis Werrebrouck
 */

public class Sum_Lists {
    public static void main(String args[]) {
        LinkedListNode number1 = new LinkedListNode(7);
        number1.appendToTail(1);
        number1.appendToTail(6);
        LinkedList linkedList1 = new LinkedList(number1);

        LinkedListNode number2 = new LinkedListNode(5);
        number2.appendToTail(9);
        number2.appendToTail(2);
        number2.appendToTail(1);
        LinkedList linkedList2 = new LinkedList(number2);

        linkedList1.print();
        linkedList2.print();

        LinkedList sum = add_2(linkedList1, linkedList2);
        sum.print();
    }

    // numbers are represented from back to front
    private static LinkedListNode add_1(LinkedListNode number1, LinkedListNode number2) {
        int overflow = 0;
        LinkedListNode sum = null;

        if(number1 == null && number2 == null) {
            return null;
        }

        while(number1 != null || number2 != null) {
            int s = (number1 != null ? number1.data : 0) + (number2 != null ? number2.data : 0) + overflow;

            overflow = s > 10 ? 1 : 0;
            s = s-(overflow*10);

            if(sum == null) {
                sum = new LinkedListNode(s);
            } else {
                sum.appendToTail(s);
            }

            number1 = number1 != null ? number1.next : null;
            number2 = number2 != null ? number2.next : null;
        }

        return sum;
    }

    // numbers are represented from front to back
    private static LinkedList add_2(LinkedList number1, LinkedList number2) {
        int length1 = number1.length;
        int length2 = number2.length;

        if(length1 > length2) {
            addTrailingZeros(number2, length1-length2);
        } else if (length1 < length2) {
            addTrailingZeros(number1, length2-length1);
        }
        
        PartialSum sum = addListHelper(number1.node, number2.node);

        if(sum.overflow == 0) {
            return new LinkedList(sum.sum);
        } else {
            LinkedList result = new LinkedList(sum.sum);
            result.appendToFront(sum.overflow);
            return result;
        }
    }

    private static void addTrailingZeros(LinkedList list, int x) {
        for(int i = 0; i<x; i++) {
            list.appendToFront(0);
        }
    }

    // recursively add nodes
    private static PartialSum addListHelper(LinkedListNode node1, LinkedListNode node2) {
        if(node1 == null && node2 == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }

        PartialSum sum = addListHelper(node1.next, node2.next);

        int value = sum.overflow + node1.data + node2.data;

        LinkedList resultList = new LinkedList(sum.sum);
        resultList.appendToFront(value%10);

        sum.sum = resultList.node;
        sum.overflow = value/10;
        return sum;
    }
}

class PartialSum {
    public LinkedListNode sum = null;
    public int overflow = 0;
}
