/**
 * Created by Larry Liu on 11/15/2017.
 * 647. Palindromic Substrings
 */
public class p647 {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += helper(s, i, i);
            if (i+1 < s.length()) count += helper(s, i, i+1);
        }
        return count;
    }

    private int helper(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i--) == s.charAt(j++)) count++;
            else return count;
        }
        return count;
    }
}
