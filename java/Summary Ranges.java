// 228. Summary Ranges   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 67261
// Total Submissions: 240043
// Difficulty: Medium
// Contributors: Admin
// Given a sorted integer array without duplicates, return the summary of its ranges.

// For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

//  Array
// Hide Similar Problems (M) Missing Ranges (H) Data Stream as Disjoint Intervals


public class Solution {
    public List<String> summaryRanges(int[] A) {
    	List<String> res = new ArrayList<>();
    	if (A.length==0) return res;

        int cur = A[0];
        int i=1;
        while(i<A.length){
        	if (A[i]!=A[i-1]+1){
        		if (A[i-1]==cur) res.add(cur +"");
        		else res.add(cur +"->"+A[i-1]);
        		cur = A[i];
        	}
        	i++;
        }
        if (A[i-1]==cur) res.add(cur +"");
        else res.add(cur +"->"+A[i-1]);

        return res;
    }
}