/**
 * Created by mengwliu on 11/11/17
 * 243. Shortest Word Distance
 */
public class p243 {
    public int shortestDistance(String[] words, String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        int[] index = new int[]{-1,-1};
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                index[0] = i;
            }
            if (word2.equals(words[i])) {
                index[1] = i;
            }
            if (index[0] != -1 && index[1] != -1)
                distance = Math.min(distance, Math.abs(index[0] - index[1]));
        }
        return distance;
    }
}
