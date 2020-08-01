import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Object-oriented design for a basic hash table.
 * 
 * @author Gillis Werrebrouck
 */

public class Hash_Table {
    public static void main(final String args[]) {
        HashTable hashTable = new HashTable(10);
        Node item1 = new Node(1, 101);
        hashTable.put(item1);
        Node item2 = new Node(2, 102);
        hashTable.put(item2);
        Node item3 = new Node(3, 103);
        hashTable.put(item3);

        Node item = hashTable.get(2);
        System.out.println(item.value);
    }
}

class Node {
    int key;
    int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class HashTable {
    private int size;
    private ArrayList<LinkedList<Node>> list;

    public HashTable(int size) {
        this.size = size;
        this.list = new ArrayList<LinkedList<Node>>();
        for (int i = 0; i < size; i++) {
            this.list.add(new LinkedList<Node>());
        }
    }

    private int computeHash(int key) {
        int a = 54059;
        int b = 76963;
        int hash = 37;
        hash = (hash * a) ^ (b * key);
        return hash % this.size;
    }

    public int put(Node item) {
        int hash = computeHash(item.key);
        list.get(hash).add(item);
        return hash;
    }

    public Node get(int key) {
        int hash = computeHash(key);

        for (Node item : list.get(hash)) {
            if (item.key == key) {
                return item;
            }
        }

        return null;
    }

    public Node remove(int key) {
        int hash = computeHash(key);
        Node item = this.get(key);

        if (item != null) {
            list.get(hash).remove(item);
            return item;
        }
        return null;
    }
}
