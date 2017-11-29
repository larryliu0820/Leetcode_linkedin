import java.util.TreeSet;

/**
 * Created by Larry Liu on 11/28/2017.
 * 730. Count Different Palindromic Subsequences
 */
public class p730 {
    int div=1000000007;
    public int countPalindromicSubsequences(String S) {
        TreeSet<Integer>[] characters = new TreeSet[4];
        int len = S.length();

        for (int i = 0; i < 4; i++) characters[i] = new TreeSet<>();

        for (int i = 0; i < len; ++i) {
            int c = S.charAt(i) - 'a';
            characters[c].add(i);
        }
        Integer[][] dp = new Integer[len+1][len+1];
        return memo(characters,dp, 0, len);
    }

    public int memo(TreeSet<Integer>[] characters,Integer[][] dp,int start,int end){
        if (start >= end) return 0;
        if(dp[start][end]!=null) return dp[start][end];

        long ans = 0;

        for(int i = 0; i < 4; i++) {
            Integer new_start = characters[i].ceiling(start);
            Integer new_end = characters[i].lower(end);
            if (new_start == null || new_end == null || new_start >= end) continue;
            ans++;
            if (!new_start.equals(new_end)) ans++;
            ans+= memo(characters,dp,new_start+1,new_end);

        }
        dp[start][end] = (int)(ans%div);
        return dp[start][end];
    }
}
