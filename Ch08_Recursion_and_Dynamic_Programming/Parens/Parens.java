import java.util.ArrayList;

/**
 * Algorithm to compute all combinations of n parentheses without duplicates.
 * 
 * @author Gillis Werrebrouck
 */

public class Parens {
    public static void main(final String args[]) {
        ArrayList<String> parens = computeParens(2);
        System.out.printf(parens.toString());
    }

    public static ArrayList<String> computeParens(int n) {
        return computeParens(n, new ArrayList<String>());
    }

    public static ArrayList<String> computeParens(int n, ArrayList<String> list) {
        ArrayList<String> parens = new ArrayList<>();

        if (n == 1) {
            parens.add("()");
        } else {
            list.addAll(computeParens(--n, list));

            for (String p : list) {
                for (int s = 0; s < p.length() + 1; s++) {
                    String str = p.substring(0, s) + "()" + p.substring(s);

                    if(!parens.contains(str)) {
                        parens.add(str);
                    }
                }
            }
        }

        return parens;
    }
}
