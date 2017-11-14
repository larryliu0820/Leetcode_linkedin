/**
 * Created by mengwliu on 11/13/17.
 * 245. Shortest Word Distance III
 */
public class p245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        int[] index = new int[]{-1,-1};
        for (int i = 0; i < words.length; i++) {
            if (!word1.equals(word2)) {
                if (word1.equals(words[i])) {
                    index[0] = i;
                } else if (word2.equals(words[i])) {
                    index[1] = i;
                }
            } else {
                if (word1.equals(words[i])) {
                    if (index[0] == -1 || i - index[0] > i - index[1]) index[0] = i;
                    else index[1] = i;
                }
            }
            if (index[0] != -1 && index[1] != -1)
                distance = Math.min(distance, Math.abs(index[0] - index[1]));
        }
        return distance;
    }
}
