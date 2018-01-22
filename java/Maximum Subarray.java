// 53. Maximum Subarray   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 158224
// Total Submissions: 408609
// Difficulty: Medium
// Contributors: Admin
// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

// For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
// the contiguous subarray [4,-1,2,1] has the largest sum = 6.

// click to show more practice.

// Subscribe to see which companies asked this question

// Hide Tags Array Dynamic Programming Divide and Conquer
// Hide Similar Problems (E) Best Time to Buy and Sell Stock (M) Maximum Product Subarray



O(n) time , O(1) space

public class Solution {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int res = nums[0];
        for (int i=1;i<nums.length;i++){
        	if (max<0) max = nums[i];
        	else max += nums[i];
        	res = Math.max(res,max);
        }
        return res;
    }
}

[-2,1,-3,4,-1,2,1,-5,4]

max = -2 1 -2 4

max = -2 1 -2 4  3  5 6  1  5
res = -2 1 1  4  4  5 6  6  6