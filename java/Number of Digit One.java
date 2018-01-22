// 233. Number of Digit One   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 25789
// Total Submissions: 94479
// Difficulty: Hard
// Contributors: Admin
// Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

// For example:
// Given n = 13,
// Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

// Hint:

// Beware of overflow.
// Subscribe to see which companies asked this question


public class Solution {
    public int countDigitOne(int n) {
    	int res = 0;
    	for (long i=1; i<=n; i = i*10){
	        long pre = n/i;
	        long tail = n%i;
	        long target = pre%10;
	        res+= pre/10*i;
	        if (target>=2) res+=i;
	        else if(target==1) res+=tail+1;
    	}

        return res;
    }
}

// O(number of digit) time O(1) space

123?37
? >=2 123*100 + 100
? ==1 123*100 + 37+1
? ==0 123*100 + 0 



