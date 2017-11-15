import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mengwliu on 11/14/17.
 * 187. Repeated DNA Sequences
 */
public class p187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> memo = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i = 0; i < s.length()-9; i++) {
            String seq = s.substring(i, i+10);
            if (memo.contains(seq)) {
                res.add(seq);
            }
            memo.add(seq);
        }
        return new ArrayList<>(res);
    }
}
