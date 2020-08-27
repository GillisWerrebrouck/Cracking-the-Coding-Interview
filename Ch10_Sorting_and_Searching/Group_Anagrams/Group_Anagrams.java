import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collection;

/**
 * Algorithm to sort an array of strings so that all anagrams are next to each other.
 * 
 * @author Gillis Werrebrouck
 */

public class Group_Anagrams {
    public static void main(final String args[]) {
        String[] words = new String[]{ "listen", "car", "stressed", "test", "desserts", "silent", "arc" };
        group_anagrams(words);

        System.out.print(words[0]);
        for (int i = 1; i < words.length; i++) {
            System.out.print(", " + words[i]);
        }
    }

    public static void group_anagrams(String[] words) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);

            ArrayList<String> arr = map.get(sorted);
            if (arr != null) {
                arr.add(word);
            } else {
                arr = new ArrayList<>();
                arr.add(word);
            }
            map.put(sorted, arr);
        }

        int index = 0;
        Collection<ArrayList<String>> mapValues = map.values();
        for (ArrayList<String> values : mapValues) {
            for (String word : values) {
                words[index++] = word;
            }
        }
    }
}
