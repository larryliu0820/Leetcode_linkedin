import java.util.HashMap;
import java.util.Map;

/**
 * Created by Larry Liu on 11/14/2017.
 * 311. Sparse Matrix Multiplication
 */
public class p311 {
    public int[][] multiply(int[][] A, int[][] B) {
        Map<Integer, Map<Integer, Integer>> mapA = new HashMap<>();
        int M = A.length, N = B[0].length;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 0) continue;
                mapA.putIfAbsent(i, new HashMap<>());
                mapA.get(i).put(j, A[i][j]);
            }
        }

        Map<Integer, Map<Integer, Integer>> mapB = new HashMap<>();
        for (int j = 0; j < B[0].length; j++) {
            for (int i = 0; i < B.length; i++) {
                if (B[i][j] == 0) continue;
                mapB.putIfAbsent(j, new HashMap<>());
                mapB.get(j).put(i, B[i][j]);
            }
        }

        int[][] res = new int[M][N];
        for (int row = 0; row < M; row++) {
            if (!mapA.containsKey(row)) continue;
            for (int col = 0; col < N; col++) {
                if (!mapB.containsKey(col)) continue;
                for (int i = 0; i < B.length; i++) {
                    if (!mapA.get(row).containsKey(i) || !mapB.get(col).containsKey(i)) continue;
                    res[row][col] += mapA.get(row).get(i) * mapB.get(col).get(i);
                }
            }
        }
        return res;
    }
}
