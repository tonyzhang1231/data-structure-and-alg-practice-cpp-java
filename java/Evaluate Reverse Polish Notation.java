// 150. Evaluate Reverse Polish Notation   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 82048
// Total Submissions: 317345
// Difficulty: Medium
// Contributors: Admin
// Evaluate the value of an arithmetic expression in Reverse Polish Notation.

// Valid operators are +, -, *, /. Each operand may be an integer or another expression.

// Some examples:
//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
// Subscribe to see which companies asked this question

// Hide Tags Stack
// Hide Similar Problems (H) Basic Calculator (H) Expression Add Operators


public class Solution {
    public int evalRPN(String[] tokens) {
    	if (tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String t:tokens){
        	if (t.equals("+")){
        		int num = stack.pop() + stack.pop() ;
        		stack.push(num);
        	}else if (t.equals("-")){
        		int num1 = stack.pop();
        		int num2 = stack.pop();;
        		stack.push(num2-num1);
        	}else if (t.equals("*")){
        		int num = stack.pop() * stack.pop() ;
        		stack.push(num);
        	}else if (t.equals("/")){
				int num1 = stack.pop();
        		int num2 = stack.pop();;
        		stack.push(num2/num1);
        	}else{ // numbers
        		stack.push(Integer.valueOf(t));
        	}
        }
        return stack.pop();
    }
}

// O(n), O(n) time and space
// 