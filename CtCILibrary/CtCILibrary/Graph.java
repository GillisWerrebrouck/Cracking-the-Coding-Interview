package CtCILibrary;

import java.util.ArrayList;

public class Graph {
    public ArrayList<Node> nodes = new ArrayList<Node>();

    public Graph() {}

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public Node addNode(int id) {
        Node node = new Node(id);
        this.nodes.add(node);
        return node;
    }

    public void devisitAllNodes() {
        for(Node n : this.nodes) {
            n.visited = false;
        }
    }
}
