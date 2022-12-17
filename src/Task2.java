import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> numsArr = new ArrayList<>(List.of(6, 4, 2, 2, 3, 6, 5, 1, 8, 5));
        Iterator<Integer> iterator = numsArr.iterator();
        while (iterator.hasNext()) {
            int cur = iterator.next();
            if (cur % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(numsArr);
    }
}