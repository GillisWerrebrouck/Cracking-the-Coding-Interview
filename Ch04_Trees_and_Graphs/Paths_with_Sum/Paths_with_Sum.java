import java.util.HashMap;

import CtCILibrary.TreeNode;

/**
 * Algorithm to count the number of paths in a binary tree that add up to a given sum. (credits: solution from the book "Cracking the Coding Interview")
 * 
 * @author Gillis Werrebrouck
 */

public class Paths_with_Sum {
    public static void main(final String args[]) {
        TreeNode tree = getBinaryTree();
        tree.print();
        
        int sum = 8;
        System.out.println("This binary tree has " + Integer.toString(countPathsWithSum(tree, 8)) + " paths with a sum of " + Integer.toString(sum));
    }

    public static int countPathsWithSum(TreeNode root, int targetSum) {
        return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
    }

    private static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if(newCount == 0) {
            hashTable.remove(key); // to reduce space usage
        } else {
            hashTable.put(key,newCount);
        }
    }

    private static int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if(node == null) {
            return 0;
        }

        runningSum += node.value;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        if(runningSum == targetSum) {
            totalPaths++;
        }

        incrementHashTable(pathCount, runningSum, 1); // increment
        totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1); // decrement

        return totalPaths;
    }

    private static TreeNode getBinaryTree() {
        TreeNode tree = new TreeNode(10);
        
        tree.left = new TreeNode(5);
        tree.left.left = new TreeNode(3);
        tree.left.left.left = new TreeNode(3);
        tree.left.left.right = new TreeNode(-2);
        tree.left.right = new TreeNode(2);
        tree.left.right.right = new TreeNode(1);
        tree.right = new TreeNode(-3);
        tree.right.right = new TreeNode(11);

        return tree;
    }
}
