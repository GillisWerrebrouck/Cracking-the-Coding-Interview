import java.util.ArrayList;

/**
 * Algorithm to find all subsets of a set.
 * 
 * @author Gillis Werrebrouck
 */

public class Power_Set {
    public static void main(final String args[]) {
        ArrayList<Character> set = new ArrayList<>();
        for (Character c : "abc".toCharArray()) {
            set.add(c);
        }

        ArrayList<ArrayList<Character>> subSets = computeSubSets(set);
        for (ArrayList<Character> subSet : subSets) {
            System.out.println(subSet);
        }
    }

    public static ArrayList<ArrayList<Character>> computeSubSets(ArrayList<Character> set) {
        return computeSubSets(set, 0);
    }

    public static ArrayList<ArrayList<Character>> computeSubSets(ArrayList<Character> set, int index) {
        ArrayList<ArrayList<Character>> subSets;
        if (index == set.size()) {
            subSets = new ArrayList<ArrayList<Character>>();
            subSets.add(new ArrayList<>());
        } else {
            subSets = computeSubSets(set, index + 1);
            ArrayList<ArrayList<Character>> expandedSubSets = new ArrayList<ArrayList<Character>>();

            for (ArrayList<Character> subSet : subSets) {
                ArrayList<Character> expandedSubSet = new ArrayList<Character>();
                expandedSubSet = (ArrayList<Character>)subSet.clone();
                expandedSubSet.add(set.get(index));
                expandedSubSets.add(expandedSubSet);
            }
            subSets.addAll(expandedSubSets);
        }

        return subSets;
    }
}
