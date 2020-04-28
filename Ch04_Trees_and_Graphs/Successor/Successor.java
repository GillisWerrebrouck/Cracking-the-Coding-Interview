import CtCILibrary.TreeNode;

/**
 * Algorithm to get the next node (in-order successor) in a binary search tree.
 * 
 * @author Gillis Werrebrouck
 */

public class Successor {
    public static void main(final String args[]) {
        TreeNode tree = getBinaryTree();
        tree.print();

        printSuccessor(tree.left);
        printSuccessor(tree.left.left.right);
        printSuccessor(tree.left.left.left);
        printSuccessor(tree.left.right.right);
        printSuccessor(tree.right.right.right);
        printSuccessor(tree.right.left.right);
        printSuccessor(tree.right.right.left);
    }

    // O(1) time in best case and O(log(n)) time in worst and average case with n being the number of nodes in the tree
    private static TreeNode getSuccessor(TreeNode node) {
        // if there is a right node, then the most left node of the right subtree is the successor
        if(node.right != null) {
            TreeNode successor = node.right;
            while(successor.left != null)
                successor = successor.left;
            return successor;
        }
        
        // if the current node is not the right node, then the parent node is the succesor
        // value comparison is posible because the root and left can have the same value but the root and right can't
        if(node.value != node.parent.right.value)
            return node.parent;
        
        // if the current node is a right node, then find the parent from which the previous node is the left node
        TreeNode previous = node;
        while(previous.parent != null && previous.value != previous.parent.left.value) {
            previous = previous.parent;
        }

        // if the element is the last in-order node, then it doesn't have a successor
        if(previous.parent == null)
            return null;
        // otherwise return the previous parent as successor
        return previous.parent;
    }

    private static void printSuccessor(TreeNode node) {
        TreeNode successor = getSuccessor(node);

        if(successor != null) {
            System.out.println("The in-order succesor of the node with value " + node.value + " has value " + successor.value);
        } else {
            System.out.println("The node with value " + node.value + " has no in-order successor");
        }
    }

    private static TreeNode getBinaryTree() {
        TreeNode tree = new TreeNode(8);

        tree.left = new TreeNode(4, tree);
        tree.left.left = new TreeNode(2, tree.left);
        tree.left.left.left = new TreeNode(1, tree.left.left);
        tree.left.left.left.left = new TreeNode(0, tree.left.left.left);
        tree.left.left.right = new TreeNode(3, tree.left.left);
        tree.left.right = new TreeNode(6, tree.left);
        tree.left.right.left = new TreeNode(5, tree.left.right);
        tree.left.right.right = new TreeNode(7, tree.left.right);

        tree.right = new TreeNode(12, tree);
        tree.right.left = new TreeNode(10, tree.right);
        tree.right.left.left = new TreeNode(9, tree.right.left);
        tree.right.left.right = new TreeNode(11, tree.right.left);
        tree.right.right = new TreeNode(14, tree.right);
        tree.right.right.left = new TreeNode(13, tree.right.right);
        tree.right.right.right = new TreeNode(15, tree.right.right);

        return tree;
    }
}
