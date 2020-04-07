package CtCILibrary;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Node {
    public int id;
    public boolean visited = false;
    public ArrayList<Node> adjacentNodes = new ArrayList<Node>(0);

    public Node(int id) {
        this.id = id;
    }

    public void addAdjacentNode(Node node) {
        this.adjacentNodes.add(node);
    }

    public boolean hasRouteTo(Node destination) {
        Queue queue = new LinkedList<Node>();
        this.visited = true;
        queue.add(this);

        while(queue.size() != 0) {
            Node node = (Node) queue.remove();
            if(node == destination) {
                return true;
            }

            for(Node n : node.adjacentNodes) {
                if(n != null && n.visited == false) {
                    n.visited = true;
                    queue.add(n);
                }
            }
        }

        return false;
    }
}
