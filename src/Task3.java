import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<Integer> numsArr = new ArrayList<>(List.of(6, 4, 2, 2, 3, 6, 5, 1, 8, 5));

        System.out.println("Минимальное значение: " + Collections.min(numsArr));
        System.out.println("Максимальное значение: " + Collections.max(numsArr));
    }
}