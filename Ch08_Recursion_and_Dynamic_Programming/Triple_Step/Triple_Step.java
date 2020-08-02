import java.util.HashMap;

/**
 * Algorithm to compute the number of ways to run up a staircase with n steps when the possibilities are 1, 2 or 3 steps at a time.
 * 
 * @author Gillis Werrebrouck
 */

public class Triple_Step {
    public static void main(final String args[]) {
        System.out.println(calculatePossibleWays(1000, new HashMap<Integer, Long>()));
    }


    public static Long calculatePossibleWays(int n, HashMap<Integer, Long> memo) {
        Long m = memo.get(n);
        if (m != null) {
            return m;
        } else if (n == 0) {
            return Long.valueOf(1);
        } else if (n < 0) {
            return Long.valueOf(0);
        }

        memo.put(n-1, calculatePossibleWays(n-1, memo));
        memo.put(n-2, calculatePossibleWays(n-2, memo));
        memo.put(n-3, calculatePossibleWays(n-3, memo));
        return memo.get(n-1) + memo.get(n-2) + memo.get(n-3);
    }
}
