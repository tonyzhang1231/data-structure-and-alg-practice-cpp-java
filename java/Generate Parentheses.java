// 22. Generate Parentheses   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 123508
// Total Submissions: 295581
// Difficulty: Medium
// Contributors: Admin
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]
// Subscribe to see which companies asked this question

// Hide Tags Backtracking String
// Hide Similar Problems (M) Letter Combinations of a Phone Number (E) Valid Parentheses


public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), n,n);
        return res;
    }
    
    public void dfs(List<String> res, StringBuilder path, int left, int right){
        if (left==0 && right ==0){
            res.add(path.toString());
        }
        
        // left: # of remaining (, right : # );
        int length = path.length();
        if (left>0){
            path.append('(');
            dfs(res,path,left-1,right);
            path.setLength(length);
        }
        
        if (left< right){
            path.append(')');
            dfs(res,path,left,right-1);
            path.setLength(length);
        }
        
    }
}