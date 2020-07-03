package CtCILibrary;

import java.util.Queue;
import java.util.Random;
import java.util.LinkedList;

public class TreeNode {
    public int value;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode parent = null;
    public int size = 0;

    public TreeNode(int value) {
        this.value = value;
        this.size = 1;
    }

    public TreeNode(int value, TreeNode parent) {
        this.value = value;
        this.parent = parent;
        this.size = 1;
    }

    public void print() {
        print(0);
    }

    private TreeNode getNthNode(int N) {
        int leftSize = (left == null ? 0 : left.size);

        if(N == leftSize) {
            return this;
        } else if(N < leftSize) {
            return left.getRandomNode();
        } else {
            return right.getRandomNode();
        }
    }

    public TreeNode getRandomNode() {
        Random rnd = new Random();
        int rndValue = rnd.nextInt(size);

        return getNthNode(rndValue);
    }

    public void insert(int value) {
        if(value <= this .value) {
            if(left == null)
                left = new TreeNode(value, this);
            else
                left.insert(value);
        } else {
            if(right == null)
                right = new TreeNode(value, this);
            else
                right.insert(value);
        }

        size++;
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
