package CtCILibrary;

import java.util.Queue;
import java.util.LinkedList;

public class TreeNode {
    int value;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int value) {
        this.value = value;
    }

    public void print() {
        print(0);
    }

    private void print(int index) {
        int level = (int)Math.floor(log2(index+1));
        int rootLevel = level == 0 ? 0 : level-1;
        
        System.out.print("     ".repeat(rootLevel));
        if(level > 0)
            System.out.print("|");
        System.out.print("____".repeat(level-rootLevel));

        System.out.println(this.value);
        
        if(this.left != null)
            this.left.print(2*index+1);
        if(this.right != null)
            this.right.print(2*index+2);
    }

    private static double log2(int n) {
        return (Math.log(n) / Math.log(2));
    }
}