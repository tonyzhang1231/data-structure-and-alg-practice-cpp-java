// 338. Counting Bits   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 60437
// Total Submissions: 101668
// Difficulty: Medium
// Contributors: Admin
// Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

// Example:
// For num = 5 you should return [0,1,1,2,1,2].

// Follow up:

// It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
// Space complexity should be O(n).
// Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
// Hint:

// You should make use of what you have produced already.
// Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
// Or does the odd/even status of the number help you in calculating the number of 1s?
// Credits:
// Special thanks to @ syedee for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Dynamic Programming Bit Manipulation
// Hide Similar Problems (E) Number of 1 Bits
// Have you met this question in a real interview? Yes  

public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        int i=0;
        res[0] = 0;
        while(true){
        	int j = (1<<i);
        	int start = (1<<i);
        	while( j < (1<<(i+1)) ){
        		if (j>num) return res;
        		res[j] = 1 + res[j - start];
        		j++;
        	}
        	i++;
        }
    }
}

// O(n) time, O(n) space

// 0 1 2 3 4 5 6 7 

// 0 1 1 2 1 2 2 3 1 2 2 3 2 3 3 4

100
101
110
111


// An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.

public int[] countBits(int num) {
    int[] f = new int[num + 1];
    for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
    return f;
}