// 11. Container With Most Water   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 110437
// Total Submissions: 306369
// Difficulty: Medium
// Contributors: Admin
// Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

// Note: You may not slant the container and n is at least 2.

// Subscribe to see which companies asked this question

// Hide Tags Array Two Pointers
// Hide Similar Problems (H) Trapping Rain Water


public class Solution {
    public int maxArea(int[] height) {
        if (height==null || height.length<=1) return 0;

        int max = 0;
        int left = 0, right = height.length-1;
        while(left < right){
        	max = Math.max(max, Math.min(height[left],height[right]) * (right - left) );
        	if (height[left] < height[right]){
        		left++;
        	}else{
        		right--;
        	}
        }
        return max;
    }
}

// O(n)time O(1)space

// 	  |     
// |     |
// |     |
// |     | 
// 0     8