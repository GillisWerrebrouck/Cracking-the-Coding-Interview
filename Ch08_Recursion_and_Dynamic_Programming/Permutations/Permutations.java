import java.util.ArrayList;

/**
 * Algorithm to 
 * 
 * @author Gillis Werrebrouck
 */

public class Permutations {
    public static void main(final String args[]) {
        ArrayList<String> permutations = computePermutationsWithDups("aabc", new ArrayList<String>());
        System.out.println(permutations);

        permutations = computePermutationsWithoutDups("aabc", new ArrayList<String>());
        System.out.println(permutations);
    }

    public static ArrayList<String> computePermutationsWithDups(String str, ArrayList<String> permutations) {
        ArrayList<String> subStrPermutations = new ArrayList<>();
        if (str.length() == 1) {
            subStrPermutations.add(str);
        } else {
            String subStr = str.substring(0, str.length()-1);
            String extra = str.substring(str.length()-1);
    
            permutations = computePermutationsWithDups(subStr, permutations);
    
            for (String permutation : permutations) {
                for (int i = 0; i < permutation.length() + 1; i++) {
                    subStrPermutations.add(permutation.substring(0, i) + extra + permutation.substring(i));
                }
            }
        }
        
        return subStrPermutations;
    }

    public static ArrayList<String> computePermutationsWithoutDups(String str, ArrayList<String> permutations) {
        ArrayList<String> subStrPermutations = new ArrayList<>();
        if (str.length() == 1) {
            subStrPermutations.add(str);
        } else {
            String subStr = str.substring(0, str.length()-1);
            String extra = str.substring(str.length()-1);
    
            permutations = computePermutationsWithoutDups(subStr, permutations);
    
            for (String permutation : permutations) {
                for (int i = 0; i < permutation.length() + 1; i++) {
                    String newPerm = permutation.substring(0, i) + extra + permutation.substring(i);
                    if (!subStrPermutations.contains(newPerm)) {
                        subStrPermutations.add(newPerm);
                    }
                }
            }
        }
        
        return subStrPermutations;
    }
}
