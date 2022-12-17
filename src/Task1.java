import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        String equation = "2?? + ?6 = ??8".replace(" ", "");

        char[] charArray = equation.toCharArray();
        List<Integer> signIndexes = new ArrayList<>();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '?') {
                signIndexes.add(i);
            }
        }

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '+') {
                charArray[i] = '=';
            }
        }

        List<List<Integer>> variables = new Task1().combination(signIndexes.size(), charArray, signIndexes);
        if (variables.toArray().length == 0) {
            System.out.println("Решений нет");
        }
    }

    List<List<Integer>> ans;

    public List<List<Integer>> combination(int k, char[] charArr, List<Integer> signIndexes) {
        ans = new ArrayList<>();
        helper(new ArrayList<>(), k, charArr, signIndexes);
        return ans;
    }

    public void helper(List<Integer> comb, int k, char[] charArr, List<Integer> signIndexes) {
        if (comb.size() == k) {
            check(comb, charArr, signIndexes);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            comb.add(i);
            helper(comb, k, charArr, signIndexes);
            comb.remove(comb.size() - 1);
        }
    }

    private void check(List<Integer> comb, char[] charArr, List<Integer> signIndexes) {
        for (int i = 0; i < signIndexes.size(); i++) {
            charArr[signIndexes.get(i)] = Character.forDigit(comb.get(i), 10);
        }

        String[] partEquation = String.valueOf(charArr).split("=");
        int a = Integer.parseInt(partEquation[0]);
        int b = Integer.parseInt(partEquation[1]);
        int c = Integer.parseInt(partEquation[2]);
        if (a + b == c) {
            ans.add(new ArrayList<>(comb));
            System.out.printf("%d + %d = %d", a, b, c);
            System.out.println();
        }
    }
}