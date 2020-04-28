import java.util.ArrayList;

import CtCILibrary.Graph;
import CtCILibrary.Node;

/**
 * Algorithm to check if there is a route between 2 nodes in a directed
 * graph.
 * 
 * @author Gillis Werrebrouck
 */

public class Route_Between_Nodes {
    public static void main(final String args[]) {
        Graph graph = new Graph();

        Node node0 = graph.addNode(0);
        Node node1 = graph.addNode(1);
        Node node2 = graph.addNode(2);
        Node node3 = graph.addNode(3);
        Node node4 = graph.addNode(4);
        Node node5 = graph.addNode(5);

        node0.addAdjacentNode(node1);
        node0.addAdjacentNode(node4);
        node0.addAdjacentNode(node5);

        node1.addAdjacentNode(node3);
        node1.addAdjacentNode(node4);

        node3.addAdjacentNode(node2);
        node3.addAdjacentNode(node4);

        node2.addAdjacentNode(node1);

        printRouteCheck(graph, node0, node2);
        printRouteCheck(graph, node0, node3);
        printRouteCheck(graph, node0, node4);
        printRouteCheck(graph, node4, node0);
        printRouteCheck(graph, node4, node3);
        printRouteCheck(graph, node4, node5);
    }

    static public void printRouteCheck(Graph graph, Node node1, Node node2) {
        System.out.println("There is" + (node1.hasRouteTo(node2) ? "" : "n't") + " a route between node with id " + node1.id + " and node with id " + node2.id);
        graph.devisitAllNodes();
    }
}
