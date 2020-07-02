import CtCILibrary.TreeNode;

/**
 * Algorithm to check if a larger binary tree (T1) has a node n which is a subtree equal to another smaller binary tree (T2).
 * 
 * @author Gillis Werrebrouck
 */

public class Check_Subtree {
    public static void main(final String args[]) {
        TreeNode T1 = getBinaryTree();
        System.out.println("T1:");
        T1.print();
        
        TreeNode T2 = T1.left.left;
        System.out.println("T2:");
        T2.print();

        System.out.println("T2 is" + (checkSubtree(T1, T2) ? "" : "n't") + " a subtree of T1");
    }

    private static void getPreOrder(TreeNode node, StringBuilder preOrder) {
        if(node != null) {
            preOrder.append(Integer.toString(node.value));

            getPreOrder(node.left, preOrder);
            getPreOrder(node.right, preOrder);
        } else {
            preOrder.append('x');
        }
    }

    private static boolean checkSubtree(TreeNode T1, TreeNode T2) {
        StringBuilder preOrderT1 = new StringBuilder();
        StringBuilder preOrderT2 = new StringBuilder();

        getPreOrder(T1, preOrderT1);
        getPreOrder(T2, preOrderT2);

        return (preOrderT1.indexOf(preOrderT2.toString()) != -1);
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
