/**
 * Created by Larry Liu on 11/16/2017.
 * 367. Valid Perfect Square
 */
public class p367 {
    public boolean isPerfectSquare(int num) {
        if (num <= 1) return true;
        int lo = 0, hi = num / 2, mid;
        while (lo <= hi) {
            mid = lo / 2 + hi / 2 + (lo % 2 + hi % 2) / 2;
            if (num / mid == mid && mid * mid == num) return true;
            else if (num / mid > mid) lo = mid + 1;
            else hi = mid -1;
        }
        return false;
    }

    public static void main(String[] args) {
        p367 sol = new p367();
        sol.isPerfectSquare(808201);
    }
}
