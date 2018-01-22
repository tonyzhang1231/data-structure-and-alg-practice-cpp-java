// 339. Nested List Weight Sum   
// Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 13508
// Total Submissions: 22701
// Difficulty: Easy
// Contributors: Admin
// Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

// Each element is either an integer, or a list -- whose elements may also be integers or other lists.

// Example 1:
// Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

// Example 2:
// Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 
// 1 + 4*2 + 6*3 = 27)

// Hide Company Tags LinkedIn
// Hide Tags Depth-first Search
// Hide Similar Problems (M) Nested List Weight Sum II
// Have you met this question in a real interview? Yes  

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */


public int depthSum(List<NestedInteger> nestedList) {
    return helper(nestedList, 1);
}

// top down, pass the depth
private int helper(List<NestedInteger> list, int depth)
{
    int ret = 0;
    for (NestedInteger e: list) // if list size is 0, return 0
    {
    	if (e.isInteger){
    		ret += e.getInteger() * depth;
    	}else{
    		ret += helper(e.getList(), depth + 1);
    	}
        // ret += e.isInteger()? e.getInteger() * depth: helper(e.getList(), depth + 1);
    }
    return ret;
}


public int depthSumInverse(List<NestedInteger> nestedList) {
    int unweighted = 0, weighted = 0;
    while (!nestedList.isEmpty()) {
        List<NestedInteger> nextLevel = new ArrayList<>();
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger())
                unweighted += ni.getInteger();
            else
                nextLevel.addAll(ni.getList());
        }
        weighted += unweighted;
        nestedList = nextLevel;
    }
    return weighted;
}




// get the depth first
class Solution {
public int depthSumInverse(List<NestedInteger> nestedList) {
    int depth = getDepth(nestedList);
    return helper(nestedList, depth);
}

private int helper(List<NestedInteger> list, int depth){
    int res = 0;
    for (NestedInteger e:list){
        if (e.isInteger()){
            res += e.getInteger() * depth;
        }else{
            res += helper(e.getList(), depth - 1);
        }
    }
    return res;
}

public int getDepth(List<NestedInteger> list){
    int res = 1;
    for (NestedInteger e: list){
        if (!e.isInteger()){
            res = Math.max(res, getDepth(e.getList()) + 1);
        }
    }
    return res;
}

}