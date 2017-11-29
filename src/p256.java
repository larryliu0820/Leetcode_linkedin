/**
 * Created by mengwliu on 11/11/17
 * 256. Paint House
 */
public class p256 {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int[] min = new int[2];
        min[0] = Integer.MAX_VALUE;
        int minInd = -1;
        for (int i = 0; i < 3; i++) {
            if (costs[0][i] <= min[0]) {
                min[1] = min[0];
                min[0] = costs[0][i];
                minInd = i;
            } else if (costs[0][i] <= min[1]) {
                min[1] = costs[0][i];
            }
        }

        for (int i = 1; i < costs.length; i++) {
            int minVal = min[0], second = min[1], ind = minInd;
            min = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
            for (int j = 0; j < 3; j++) {
                if (j != ind) {
                    costs[i][j] += minVal;
                } else {
                    costs[i][j] += second;
                }
                if (costs[i][j] <= min[0]) {
                    min[1] = min[0];
                    min[0] = costs[i][j];
                    minInd = j;
                } else if (costs[i][j] <= min[1]) {
                    min[1] = costs[i][j];
                }
            }
        }
        return min[0];
    }

    public int minCost2(int[][] costs) {
        if(costs==null||costs.length==0){
            return 0;
        }
        for(int i=1; i<costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
        }
        int n = costs.length-1;
        return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
    }
}
