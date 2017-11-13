import java.util.*;

/**
 * Created by mengwliu on 11/11/17
 * 364. Nested List Weight Sum II
 */
public class p364 {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int res = 0, currSum = 0;
        Queue<NestedInteger> q = new LinkedList<>();
        for (NestedInteger ni: nestedList) q.offer(ni);
        while (!q.isEmpty()) {
            Queue<NestedInteger> temp = new LinkedList<>();
            while (!q.isEmpty()) {
                NestedInteger curr = q.poll();
                if (curr.isInteger()) currSum += curr.getInteger();
                else temp.addAll(curr.getList());
            }
            res += currSum;
            q = temp;
        }
        return res;
    }
}
