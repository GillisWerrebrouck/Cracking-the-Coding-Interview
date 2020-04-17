import java.util.ArrayList;
import java.util.Queue;

import CtCILibrary.LinkedList;
import CtCILibrary.LinkedListNode;
import CtCILibrary.TreeNode;

/**
 * Algorithm to create create a linkedlist for all nodes at each depth of a binary tree.
 * 
 * @author Gillis Werrebrouck
 */

public class List_of_Depths {
    public static void main(final String args[]) {
        TreeNode tree = getBinaryTree();
        ArrayList<LinkedList> lists = getListsOfDepths(tree);

        System.out.println("Tree:");
        tree.print();

        System.out.println("Lists:");
        for(int i = 0; i < lists.size(); i++) {
            lists.get(i).print();
        }
    }

    // depth-first approach
    private static ArrayList<LinkedList> getListsOfDepths(TreeNode tree) {
        Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        queue.add(tree);
        int index = 0;

        ArrayList<LinkedList> lists = new ArrayList<LinkedList>();

        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
            
            int depth = (int)Math.floor(log2(index+1));

            LinkedListNode linkedListNode = new LinkedListNode(node.value);

            if(lists.size() == depth) {
                lists.add(new LinkedList(linkedListNode));
            } else {
                lists.get(depth).appendToTail(linkedListNode);
            }

            index++;
        }

        return lists;
    }

    private static double log2(int n) {
        return (Math.log(n) / Math.log(2));
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
