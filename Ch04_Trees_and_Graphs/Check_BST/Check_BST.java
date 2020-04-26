import CtCILibrary.TreeNode;

/**
 * Algorithm to check if a binary tree is a valid binary search tree using a variation of pre-order tree traversal.
 * 
 * @author Gillis Werrebrouck
 */

public class Check_BST {
    public static void main(final String args[]) {
        TreeNode tree = getBinaryTree();
        tree.print();

        System.out.println("Tree is" + (isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE) ? "" : "n't")  + " a valid binary search tree");
    }

    private static boolean isBST(TreeNode node, int rangeStart, int rangeEnd) {
        if(node != null) {
            if(rangeStart >= node.value || node.value > rangeEnd) {
                return false;
            }

            boolean isLeftBST = isBST(node.left, rangeStart, node.value);
            boolean isRightBST = isBST(node.right, node.value, rangeEnd);

            return isLeftBST && isRightBST;
        }

        return true;
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
