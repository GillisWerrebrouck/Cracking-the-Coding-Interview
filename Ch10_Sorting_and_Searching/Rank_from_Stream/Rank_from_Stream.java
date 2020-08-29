/**
 * Algorithm to 
 * 
 * @author Gillis Werrebrouck
 */

public class Rank_from_Stream {
    public static void main(final String args[]) {
        int[] stream = new int[]{ 5, 1, 4, 4, 5, 9, 7, 13, 3 };
        Tree tree = new Tree();

        for (int x : stream) {
            tree.add(new TreeNode(x));
        }

        System.out.println("the rank of 1 is " + tree.getRank(1));
        System.out.println("the rank of 3 is " + tree.getRank(3));
        System.out.println("the rank of 4 is " + tree.getRank(4));
    }
}

class Tree {
    TreeNode root = null;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public Tree() {}

    public void add(TreeNode node) { // the "track method" for the stream
        if (this.root == null) {
            this.root = node;
        } else {
            this.root.add(node);
        }
    }

    public int getRank(int x) {
        return this.root.getRank(x);
    }
}

class TreeNode {
    int value;
    int rank = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int value) {
        this.value = value;
    }

    public void add(TreeNode node) {
        if (node.value <= this.value) {
            this.rank++;
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    public int getRank(int x) {
        if (x == this.value) {
            return this.rank;
        } else if (x < this.value) {
            if (this.left == null) {
                return -1;
            }
            return this.left.getRank(x);
        }

        if (this.right == null) {
            return -1;
        }
        return this.rank + 1 + this.right.getRank(x);
    }
}
