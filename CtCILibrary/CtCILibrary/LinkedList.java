package CtCILibrary;

public class LinkedList {
    public LinkedListNode node = null;
    public int length = 0;

    public LinkedList(LinkedListNode n) {
        this.node = n;
        this.setLength();
    }

    public LinkedListNode detectLoop() {
        if(this.node == null) {
            return null;
        }

        LinkedListNode pointer = this.node;
        LinkedListNode runner = this.node;

        // determine where the pointer and runner collide if the pointer moves one node and the runner moves two nodes each iteration
        do {
            if(runner.next == null || runner.next.next == null) {
                return null;
            }
            pointer = pointer.next;
            runner = runner.next.next;
        } while(pointer != runner);

        // the colliding node and the start node of the list are now the same amount of nodes away from the start of the loop
        LinkedListNode collision = pointer;
        pointer = this.node;

        while(pointer != collision) {
            pointer = pointer.next;
            collision = collision.next;
        }
        
        return pointer;
    }
    
    public void print() {
        LinkedListNode node = this.node;
        LinkedListNode endNode = this.detectLoop();
        boolean hasEncounteredIntersection = endNode == null;

        while(node != endNode || (node == endNode && !hasEncounteredIntersection)) {
            if(node == endNode) {
                hasEncounteredIntersection = true;
            }
            System.out.print(node.data + (node.next != endNode || (node.next == endNode && !hasEncounteredIntersection) ? " -> " : "\n"));
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
        // this method does nothing if there is a loop in the linked list
        if(this.detectLoop() != null) {
            return;
        }
        
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
        LinkedListNode endNode = this.detectLoop();
        boolean hasEncounteredIntersection = endNode == null;

        while(node != endNode || (node == endNode && !hasEncounteredIntersection)) {
            if(node == endNode) {
                hasEncounteredIntersection = true;
            }
            this.length++;
            node = node.next;
        }
    }
}
