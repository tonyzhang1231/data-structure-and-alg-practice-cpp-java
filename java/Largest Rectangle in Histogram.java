// 84. Largest Rectangle in Histogram   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 79138
// Total Submissions: 308598
// Difficulty: Hard
// Contributors: Admin
// Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


// The largest rectangle is shown in the shaded area, which has area = 10 unit.

// For example,
// Given heights = [2,1,5,6,2,3],
// return 10.

// Subscribe to see which companies asked this question

// Hide Tags Array Stack
// Hide Similar Problems (H) Maximal Rectangle


// 以ith bar为中心，向两边搜索，直到搜到第一个 lth bar and rth bar 满足 l<0||h[l]<h[i]   r==n || h[r]<h[i]
// O(n^2) time

public int largestRectangleArea(int[] height) {
    if (height == null || height.length == 0) {
        return 0;
    }
    int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
    int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
    lessFromRight[height.length - 1] = height.length;
    lessFromLeft[0]  = -1;

    for (int i = 1; i < height.length; i++) {
        if (height[i] > height[i - 1]) {
            lessFromLeft[i] = i - 1;
        }
        else  {
            int p = i - 1;
            while (p >= 0 && height[p] >= height[i]) p = lessFromLeft[p];                
            lessFromLeft[i] = p;
        }
    }

    for (int i = height.length - 2; i >= 0; i--) {
        if (height[i] > height[i + 1]) {
            lessFromRight[i] = i + 1;
        }
        else  {
            int p = i + 1;
            while (p < height.length && height[p] >= height[i]) p = lessFromRight[p];                
            lessFromRight[i] = p;
        }
    }

    int maxArea = 0;
    for (int i = 0; i < height.length; i++) {
        maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
    }
    return maxArea;
}