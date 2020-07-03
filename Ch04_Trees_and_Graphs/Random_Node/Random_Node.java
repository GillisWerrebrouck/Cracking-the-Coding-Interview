import CtCILibrary.TreeNode;

/**
 * Custom binary tree implementation that supports getRandomNode() as opperation so that every node has equal chance of being chosen.
 * 
 * @author Gillis Werrebrouck
 */

public class Random_Node {
    public static void main(final String args[]) {
        TreeNode tree = getBinaryTree();
        tree.print();

        System.out.println("Random node value: " + Integer.toString(tree.getRandomNode().value));
    }

    private static TreeNode getBinaryTree() {
        TreeNode tree = new TreeNode(8);
        tree.insert(4);
        tree.insert(12);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(0);
        tree.insert(5);
        tree.insert(7);
        tree.insert(10);
        tree.insert(14);
        tree.insert(9);
        tree.insert(11);
        tree.insert(13);
        tree.insert(15);

        return tree;
    }
}
