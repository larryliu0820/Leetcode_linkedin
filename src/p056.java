import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengwliu on 11/14/17.
 * 56. Merge Intervals
 */
public class p056 {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return intervals;
        intervals.sort((a, b)->a.start-b.start);
        List<Interval> res = new LinkedList<>();
        Interval curr = intervals.get(0);
        for (Interval itr : intervals) {
            if (itr.start <= curr.end) {
                curr.end = Math.max(curr.end, itr.end);
            } else {
                res.add(curr);
                curr = itr;
            }
        }
        res.add(curr);
        return res;
    }
}
