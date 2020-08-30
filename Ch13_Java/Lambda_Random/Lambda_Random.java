import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Lambda expression to generate a random subset of a list with each subset having equal probability.
 * 
 * @author Gillis Werrebrouck
 */

public class Lambda_Random {
    public static void main(final String args[]) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        System.out.println(getRandomRubset(list));
    }

    public static List<Integer> getRandomRubset(List<Integer> list) {
        return list
            .stream()
            .filter(i -> {
                Random rd = new Random();
                return rd.nextBoolean();
            })
            .collect(Collectors.toList());
    }
}
