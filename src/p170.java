import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by mengwliu on 11/12/17
 * 170. Two Sum III - Data structure design
 */
public class p170 {
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public p170() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, 2);
        } else {
            map.put(number, 1);
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int num: map.keySet()) {
            int target = value - num;
            if (map.containsKey(target) && (target != num || map.get(target) == 2)) return true;
        }
        return false;
    }
}
