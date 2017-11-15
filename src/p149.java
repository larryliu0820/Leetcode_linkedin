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
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int x = points[i].x, y = points[i].y;
            int origins = 1;
            int currMax = 0;
            for (int j = i+1; j < points.length; j++) {
                if (points[j].x == x && points[j].y == y) {
                    origins++;
                    continue;
                }
                int gcd = gcd(y - points[j].y, x - points[j].x);
                int dy = (y - points[j].y) / gcd, dx = (x - points[j].x) / gcd;
                map.putIfAbsent(dx, new HashMap<>());
                map.get(dx).put(dy, map.get(dx).getOrDefault(dy, 0)+1);
                currMax = Math.max(currMax, map.get(dx).get(dy));
            }
            max = Math.max(max, currMax+origins);
        }
        return max;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}
