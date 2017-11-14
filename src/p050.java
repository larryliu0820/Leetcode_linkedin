/**
 * Created by Larry Liu on 11/13/2017.
 * 50. Pow(x, n)
 */
public class p050 {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n == -1) return 1/x;
        double half = myPow(x, n/2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            int res = n % 2;
            return myPow(x, res) * half * half;
        }
    }
}
