import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Larry Liu on 11/14/2017.
 * 464. Can I Win
 */
public class p464 {
    boolean[] visited;
    Map<Integer, Boolean> map;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        visited = new boolean[maxChoosableInteger+1];
        int sum = (1+maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
        map = new HashMap<>();
        return backtrack(desiredTotal);
    }

    private boolean backtrack(int target) {
        if (target <= 0) return false;
        int key = format(visited);
        if (!map.containsKey(key)) {
            for (int i = 1; i < visited.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    if (!backtrack(target - i)) {
                        map.put(key, true);
                        visited[i] = false;
                        return true;
                    }
                    visited[i] = false;
                }
            }
            map.put(key, false);
        }
        return map.get(key);
    }

    private int format(boolean[] visited) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) res |= mask;
            mask <<= 1;
        }
        return res;
    }
}
