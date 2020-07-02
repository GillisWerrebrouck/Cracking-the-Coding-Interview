import java.util.ArrayList;
import java.util.LinkedList;

import CtCILibrary.TreeNode;

/**
 * Algorithm to compute all possible arrays from which a BST was created.
 * 
 * @author Gillis Werrebrouck
 */

public class BST_Sequences {
    public static void main(final String args[]) {
        TreeNode tree = getBinaryTree();
        tree.print();

        ArrayList<LinkedList<Integer>> sequences = findAllBSTSequences(tree);
        System.out.println(sequences);
    }

    private static void weaveLists(LinkedList<Integer> left, LinkedList<Integer> right, ArrayList<LinkedList<Integer>> weaved, LinkedList<Integer> prefix) {
        if(left.size() == 0 || right.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>)prefix.clone();
            result.addAll(left);
            result.addAll(right);
            weaved.add(result);
            return;
        }

        int headLeft = left.removeFirst();
        prefix.addLast(headLeft);
        weaveLists(left, right, weaved, prefix);
        prefix.removeLast();
        left.addFirst(headLeft);

        int headRight = right.removeFirst();
        prefix.addLast(headRight);
        weaveLists(left, right, weaved, prefix);
        prefix.removeLast();
        right.addFirst(headRight);
    }

    private static ArrayList<LinkedList<Integer>> findAllBSTSequences(TreeNode root) {
        ArrayList<LinkedList<Integer>> sequences = new ArrayList<>();
        
        if(root == null) {
            sequences.add(new LinkedList<Integer>());
            return sequences;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.value);

        ArrayList<LinkedList<Integer>> leftSequence = findAllBSTSequences(root.left);
        ArrayList<LinkedList<Integer>> rightSequence = findAllBSTSequences(root.right);

        for(LinkedList<Integer> left : leftSequence) {
            for(LinkedList<Integer> right : rightSequence) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
                weaveLists(left, right, weaved, prefix);
                sequences.addAll(weaved);
            }
        }

        return sequences;
    }

    private static TreeNode getBinaryTree() {
        TreeNode tree = new TreeNode(8);

        tree.left = new TreeNode(4, tree);
        tree.left.left = new TreeNode(2, tree.left);
        tree.left.right = new TreeNode(6, tree.left);

        tree.right = new TreeNode(12, tree);
        tree.right.left = new TreeNode(10, tree.right);
        tree.right.right = new TreeNode(14, tree.right);

        return tree;
    }
}
