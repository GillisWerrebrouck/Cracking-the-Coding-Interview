/**
 * Algorithm to search in a sparse array.
 * 
 * @author Gillis Werrebrouck
 */

public class Sparse_Search {
    public static void main(final String args[]) {
        String[] sparse_arr = new String[]{ "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" };
        String value = "ball";
        int index = sparse_binary_search(sparse_arr, value);

        if (0 <= index) {
            System.out.println("index " + index + " holds the value " + value);
        } else {
            System.out.println("value " + value + " not found");
        }
    }

    public static int sparse_binary_search(String[] array, String value) {
        if (value.isEmpty() || value == null || array == null) {
            return -1;
        }
        return sparse_binary_search(array, value, 0, array.length - 1);
    }

    public static int sparse_binary_search(String[] array, String value, int l, int r) {
        if(l > r) {
            return -1;
        }

        int m = l + ((r - l) / 2);
        int m_adjusted = m;

        if (array[m].isEmpty()) {
            int lm = m - 1;
            int rm = m + 1;
            while (true) {
                if (lm < l && r < rm) {
                    return -1;
                }
                if (!array[lm].isEmpty()) {
                    m_adjusted = lm;
                    break;
                } else if (!array[rm].isEmpty()) {
                    m_adjusted = rm;
                    break;
                }
                lm--;
                rm++;
            }
        }
        System.out.println(array[m_adjusted]);

        if (array[m_adjusted].equals(value)) {
            return m_adjusted;
        } else if (array[m_adjusted].compareTo(value) < 0) {
            return sparse_binary_search(array, value, m_adjusted+1, r);
        }
        return sparse_binary_search(array, value, l, m_adjusted-1);
    }
}
