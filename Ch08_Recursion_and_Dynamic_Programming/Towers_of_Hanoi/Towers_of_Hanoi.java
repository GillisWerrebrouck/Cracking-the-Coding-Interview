import java.util.ArrayList;
import java.util.Stack;

/**
 * Algorithm to solve the Towers of Hanoi problem.
 * 
 * @author Gillis Werrebrouck
 */

public class Towers_of_Hanoi {
    public static void main(final String args[]) {
        int numberOfDisks = 3;
        ArrayList<Integer> disks = new ArrayList<Integer>();
        for (int i = 1; i <= numberOfDisks; i++) {
            disks.add(i);
        }
        Towers towers = new Towers(disks);
        towers.print();
        towers.solve();
        towers.print();
    }
}

class Towers {
    public ArrayList<Tower> towers = new ArrayList<Tower>();
    private int numberOfDisks;
    private int numberOfTowers = 3;

    public Towers(ArrayList<Integer> disks) {
        this.numberOfDisks = disks.size();

        Tower firstTower = new Tower(1);
        for (Integer disk : disks) {
            firstTower.add(disk);
        }
        towers.add(firstTower);
        
        for (int i = 0; i < this.numberOfTowers - 1; i++) {
            towers.add(new Tower(i+2));
        }
    }

    public void solve() {
        solve(this.numberOfDisks, this.towers.get(0), this.towers.get(2), this.towers.get(1));
    }

    public void solve(int numberOfDisks, Tower from, Tower to, Tower temp) {
        if (numberOfDisks == 0) return;
        solve(numberOfDisks - 1, from, temp, to);
        from.moveTopTo(to);
        solve(numberOfDisks - 1, temp, to, from);
    }

    public void print() {
        for (Tower tower : this.towers) {
            tower.print();
        }
    }
}

class Tower {
    private int towerNumber;
    private Stack<Integer> stack = new Stack<Integer>();

    public Tower(int towerNumber) {
        this.towerNumber = towerNumber;
    }

    public void add (Integer i) {
        this.stack.add(i);
    }

    public void moveTopTo(Tower tower) {
        if (this.stack.empty()) {
            return;
        }
        tower.add(this.stack.pop());
        System.out.println(this.towerNumber + " --> " + tower.towerNumber);
    }

    public void print() {
        Stack<Integer> copy = (Stack<Integer>)stack.clone();
        ArrayList<Integer> arr = new ArrayList<Integer>();

        while (!copy.empty()) {
            arr.add(copy.pop());
        }
        System.out.println(arr);
    }
}
