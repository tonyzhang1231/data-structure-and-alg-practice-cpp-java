// 32. Longest Valid Parentheses   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 83133
// Total Submissions: 360325
// Difficulty: Hard
// Contributors: Admin
// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

// For "(()", the longest valid parentheses substring is "()", which has length = 2.

// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

// Subscribe to see which companies asked this question

// Hide Tags Dynamic Programming String
// Hide Similar Problems (E) Valid Parentheses


public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        int left = -1;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='(') stack.push(j);            
            else {
                if (stack.isEmpty()) left=j; // if valid ) occurs, move the left to this pos
                else{
                    stack.pop();
                    if(stack.isEmpty()) max=Math.max(max,j-left);
                    else max=Math.max(max,j-stack.peek());
                }
            }
        }
        return max;
    }
}


// The workflow of the solution is as below.

// Scan the string from beginning to end.
// If current character is '(',
// push its index to the stack. If current character is ')' and the
// character at the index of the top of stack is '(', we just find a
// matching pair so pop from the stack. Otherwise, we push the index of
// ')' to the stack.
// After the scan is done, the stack will only
// contain the indices of characters which cannot be matched. Then
// let's use the opposite side - substring between adjacent indices
// should be valid parentheses.
// If the stack is empty, the whole input
// string is valid. Otherwise, we can scan the stack to get longest
// valid substring as described in step 3.


This is my DP solution, just one pass

V[i] represents number of valid parentheses matches from S[j to i] (j<i)

V[i] = V[i-1] + 2 + previous matches V[i- (V[i-1] + 2) ] if S[i] = ')' and '(' count > 0

public class Solution {
	public int longestValidParentheses(String s) {
	    char[] S = s.toCharArray();
	    int[] V = new int[S.length];
	    int open = 0;
	    int max = 0;
	    for (int i=0; i<S.length; i++) {
	        if (S[i] == '(') open++;
	        if (S[i] == ')' && open > 0) {
	            // matches found
	            V[i] = 2+ V[i-1];
	            // add matches from previous
	            if(i-V[i]>0)
	                V[i] += V[i-V[i]];
	            open--;
	        }
	        if (V[i] > max) max = V[i];
	    }
	    return max;
	}
}