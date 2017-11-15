import java.util.*;

/**
 * Created by Larry Liu on 11/15/2017.
 * 127. Word Ladder
 */
public class p127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        map.put(beginWord, 1);
        q.offer(beginWord);
        while (!q.isEmpty()) {
            String currWord = q.poll();
            int dist = map.get(currWord);
            List<String> neighbors = findNeighbor(wordSet, currWord);
            for (String neighbor: neighbors) {
                if (!map.containsKey(neighbor)) {
                    if (neighbor.equals(endWord)) return dist+1;
                    map.put(neighbor, dist+1);
                    q.offer(neighbor);
                }
            }
        }
        return 0;
    }

    private List<String> findNeighbor(Set<String> wordSet, String word) {
        char[] wordArr = word.toCharArray();
        List<String> neighbors = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            char temp = wordArr[i];
            for (int j = 0; j < 26; j++) {
                wordArr[i] = (char)('a' + j);
                String str = String.valueOf(wordArr);
                if (wordSet.contains(str)) neighbors.add(str);
            }
            wordArr[i] = temp;
        }
        return neighbors;
    }

    public static void main(String[] args) {
        p127 sol = new p127();
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        sol.ladderLength("hit", "cog", wordList);
    }
}
