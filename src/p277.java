/**
 * Created by mengwliu on 11/14/17.
 * 277. Find the Celebrity
 */
public class p277 {
    boolean knows(int a, int b) {return true;}
    public int findCelebrity(int n) {
        int x = 0;
        for (int i = 0; i < n; i++) if (knows(x, i)) x = i;
        for (int i = 0; i < n; i++) if (i != x && (!knows(i, x) || knows(x, i))) return -1;
        return x;
    }
}
