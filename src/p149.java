import java.util.*;

/**
 * Created by Larry Liu on 11/14/2017.
 * 149. Max Points on a Line
 */
public class p149 {
    class Point {
        int x;
        int y;
        Point() {x = 0; y = 0;}
        Point(int a, int b) {x = a; y = b;}
    }
    public int maxPoints(Point[] points) {
        Map<Double, Integer> slopes = new HashMap<>();
        int originNum = 0;
        for (Point pt: points) {
            if (pt.x == 0 && pt.y == 0) {
                originNum++;
                continue;
            }

            if (pt.x == 0) {
                slopes.put(Double.MAX_VALUE, slopes.getOrDefault(Double.MAX_VALUE, 0)+1);
            } else {
                slopes.put((double)(pt.y / pt.x), slopes.getOrDefault((double)(pt.y / pt.x), 0)+1);
            }
        }
        if (originNum > 0) {
            if (slopes.isEmpty()) slopes.put(0.0, originNum);
            else for (double key : slopes.keySet()) slopes.put(key, slopes.get(key) + originNum);
        }
        List<Integer> values = new LinkedList<>();
        values.addAll(slopes.values());
        values.sort(Comparator.naturalOrder());
        return values.size() == 0? 0: values.get(values.size()-1);
    }
}
