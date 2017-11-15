import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 11/15/2017.
 * 57. Insert Interval
 */
public class p057 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        List<Interval> res = new LinkedList<>();
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i));
            i++;
        }

        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        res.add(newInterval);

        while (i < intervals.size()) {
            res.add(intervals.get(i));
            i++;
        }

        return res;
    }
}
