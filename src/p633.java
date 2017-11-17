import java.util.HashSet;
import java.util.Set;

/**
 * Created by Larry Liu on 11/15/2017.
 * 633. Sum of Square Numbers
 */
public class p633 {
    public boolean judgeSquareSum(int c) {
        if (c <= 1) return true;
        Set<Integer> memo = new HashSet<>();
        for (int i = 0; i <= Math.sqrt(c); i++) {
            int square = i*i;
            memo.add(square);
            if (memo.contains(c-square)) return true;

        }
        return false;
    }
}
