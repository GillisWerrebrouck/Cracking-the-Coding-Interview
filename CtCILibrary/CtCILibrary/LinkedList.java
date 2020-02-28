package CtCILibrary;

public class LinkedList {
    public LinkedListNode node = null;
    public int length = 0;

    public LinkedList(LinkedListNode n) {
        this.node = n;
        this.setLength();
    }
    
    public void print() {
        LinkedListNode node = this.node;
        while(node != null) {
            System.out.print(node.data + (node.next != null ? " -> " : "\n"));
            node = node.next;
        }
    }

    public void appendToFront(int d) {
        LinkedListNode front = new LinkedListNode(d);
        front.next = this.node;
        this.node = front;
        length++;
    }

    public void appendToTail(LinkedListNode node) {
        if(this.node != null) {
            this.node.appendToTail(node);
            this.setLength();
        } else {
            this.node = node;
            this.length = 1;
        }
    }

    public void appendToTail(int d) {
        LinkedListNode node = new LinkedListNode(d);
        this.appendToTail(node);
    }
    
    public void setLength() {
        this.length = 0;
        LinkedListNode node = this.node;

        while(node != null) {
            this.length++;
            node = node.next;
        }
    }
}
