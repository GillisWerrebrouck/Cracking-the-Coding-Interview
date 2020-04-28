import CtCILibrary.TreeNode;

/**
 * Algorithm to create a binary tree of minimal height from an array of increasing sorted values.
 * 
 * @author Gillis Werrebrouck
 */

public class Minimal_Tree {
    public static void main(final String args[]) {
        int length = 16;
        int[] values = new int[length];
        for(int i = 0; i < length; i++) {
            values[i] = i;
        }

        TreeNode tree = createMinimalTree(values);
        tree.print();
    }

    public static TreeNode createMinimalTree(int[] values) {
        return createMinimalTree(values, 0, values.length-1);
    }

    public static TreeNode createMinimalTree(int[] values, int left, int right) {
        if(left>right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(values[mid]);
        node.left = createMinimalTree(values, left, mid-1);
        node.right = createMinimalTree(values, mid+1, right);

        return node;
    }
}
