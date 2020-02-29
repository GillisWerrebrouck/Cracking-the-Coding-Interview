package CtCILibrary;

public class LinkedListNode {
    public LinkedListNode next = null;
    public int data;

    public LinkedListNode(int d) {
        data = d;
    }

    public void appendToTail(LinkedListNode node) {
        LinkedListNode n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
    }

    public void appendToTail(int d) {
        LinkedListNode end = new LinkedListNode(d);
        this.appendToTail(end);
    }

    public int length() {
        int length = 0;
        LinkedListNode node = this;

        while(node != null) {
            length++;
            node = node.next;
        }

        return length;
    }
}
