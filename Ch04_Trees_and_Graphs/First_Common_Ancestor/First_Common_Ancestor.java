import CtCILibrary.TreeNode;

/**
 * Algorithm to find the first common ancestor of two nodes in a binary tree.
 * 
 * @author Gillis Werrebrouck
 */

public class First_Common_Ancestor {
    public static void main(final String args[]) {
        TreeNode tree = getBinaryTree();
        tree.print();

        TreeNode node1 = tree.left.left.right;
        TreeNode node2 = tree.left.right;
        TreeNode firstCommonAncestor = getFirstCommonAncestor(tree, node1, node2);

        if(firstCommonAncestor != null) {
            System.out.println("The first common ancestor of the node with value " + Integer.toString(node1.value) + " and " + Integer.toString(node2.value) + " has the value " + Integer.toString(firstCommonAncestor.value));
        } else {
            System.out.println("No common ancestor");
        }
    }

    private static int getDepth(TreeNode node) {
        int depth = 0;
        TreeNode copy = node;

        while(copy.parent != null) {
            copy = copy.parent;
            depth++;
        }

        return depth;
    }

    private static TreeNode getFirstCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        int depth1 = getDepth(node1);
        int depth2 = getDepth(node2);
        int depthDiff = Math.abs(depth1 - depth2);
        TreeNode deeperNode = depth1 >= depth2 ? node1 : node2;
        TreeNode higherNode = depth1 >= depth2 ? node2 : node1;

        for(int i = 0; i < depthDiff; i++) {
            deeperNode = deeperNode.parent;
        }

        if(deeperNode.parent == null) {
            return null;
        }

        while(deeperNode != null && higherNode != null && deeperNode != higherNode) {
            deeperNode = deeperNode.parent;
            higherNode = higherNode.parent;
        }

        return deeperNode == null || higherNode == null ? null : deeperNode;
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
