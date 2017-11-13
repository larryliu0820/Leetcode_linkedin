import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by mengwliu on 11/11/17
 * 244. Shortest Word Distance II
 */
public class p244 {
    Map<String, List<Integer>> map;
    public p244(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.putIfAbsent(words[i], new LinkedList<>());
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> index1 = map.get(word1);
        List<Integer> index2 = map.get(word2);

        int i = 0, j = 0, diff = Integer.MAX_VALUE;
        while (i < index1.size() && j < index2.size()) {
            diff = Math.min(Math.abs(index1.get(i) - index2.get(j)), diff);
            if (index1.get(i) < index2.get(j)) i++;
            else j++;
        }
        return diff;
    }
}
