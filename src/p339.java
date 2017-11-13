import java.util.List;
import java.util.Stack;

/**
 * Created by mengwliu on 11/11/17
 * 339. Nested List Weight Sum
 */
public class p339 {
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        for (NestedInteger nestedInteger: nestedList) {
            sum += helper(nestedInteger, 1);
        }
        return sum;

    }

    private int helper(NestedInteger nestedInteger, int depth) {
        int sum = 0;
        if (nestedInteger.isInteger()) return depth * nestedInteger.getInteger();
        else {
            List<NestedInteger> list = nestedInteger.getList();
            for (NestedInteger neighbor : list) sum += helper(neighbor, depth+1);
        }
        return sum;
    }

}
