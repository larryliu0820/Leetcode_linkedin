/**
 * Created by Larry Liu on 11/14/2017.
 * 76. Minimum Window Substring
 */
public class p076 {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c: t.toCharArray()) map[c]++;
        int head = 0, tail = 0, count = t.length();
        int minLen = Integer.MAX_VALUE;
        String res = "";
        while (head < s.length()) {
            if (map[s.charAt(head)] > 0) {
                count--;
            }
            map[s.charAt(head)]--;
            head++;
            while (count == 0) {
                if (head - tail < minLen) {
                    minLen = head - tail;
                    res = s.substring(tail, head);
                }
                if (map[s.charAt(tail)] == 0) {
                    count++;
                }
                map[s.charAt(tail)]++;
                tail++;
            }
        }
        return res;
    }
}
