import CtCILibrary.TreeNode;

/**
 * Algorithm to check if a binary tree is balanced using a version post-order tree traversal.
 * Balanced means that the heights of the two dubstrees of any node never differ by more than one.
 * 
 * @author Gillis Werrebrouck
 */

public class Check_Balanced {
    public static void main(final String args[]) {
        TreeNode tree = getBinaryTree();
        tree.print();

        Node_Info info = isBalanced(tree);

        System.out.println("Tree is" + (info.isBalanced ? "" : "n't")  + " balanced and has a height of " +  info.height + " node(s)");
    }

    private static Node_Info isBalanced(TreeNode node) {
        if(node != null) {
            Node_Info leftInfo = isBalanced(node.left);
            Node_Info rightInfo = isBalanced(node.right);

            int height = Math.max(leftInfo.height, rightInfo.height) + 1;
            boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced && Math.abs(leftInfo.height - rightInfo.height) <= 1;
            Node_Info info = new Node_Info(height, isBalanced);

            return info;
        }

        return new Node_Info(0, true);
    }

    private static TreeNode getBinaryTree() {
        TreeNode tree = new TreeNode(8);

        tree.left = new TreeNode(4);
        tree.left.left = new TreeNode(2);
        tree.left.left.left = new TreeNode(1);
        tree.left.left.left.left = new TreeNode(0);
        tree.left.left.right = new TreeNode(3);
        tree.left.right = new TreeNode(6);
        tree.left.right.left = new TreeNode(5);
        tree.left.right.right = new TreeNode(7);

        tree.right = new TreeNode(12);
        tree.right.left = new TreeNode(10);
        tree.right.left.left = new TreeNode(9);
        tree.right.left.right = new TreeNode(11);
        tree.right.right = new TreeNode(14);
        tree.right.right.left = new TreeNode(13);
        tree.right.right.right = new TreeNode(15);

        return tree;
    }
}

class Node_Info {
    int height;
    boolean isBalanced;

    public Node_Info(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}
