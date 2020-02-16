package CtCILibrary;

public class LinkedListNode {
    public LinkedListNode next = null;
    public int data;

    public LinkedListNode(int d) {
        data = d;
    }

    public void appendToTail(int d) {
        LinkedListNode end = new LinkedListNode(d);
        LinkedListNode n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
}
