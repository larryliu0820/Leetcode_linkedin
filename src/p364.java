import java.util.*;

/**
 * Created by mengwliu on 11/11/17
 * 364. Nested List Weight Sum II
 */
public class p364 {

    int sum =0;
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0)
        return 0;
        dfs(nestedList, 1);
        return sum;
    }
    
    private void dfs(List<NestedInteger> nestedList , int level)
    {
        for(NestedInteger value:nestedList)
        {
            if(value.isInteger())
            {
                sum += (level * value.getInteger());
            }
            else{
                dfs(value.getList(), level+1);
            }
        }
    }
}
