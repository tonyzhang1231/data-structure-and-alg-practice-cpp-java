// 152. Maximum Product Subarray   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 84268
// Total Submissions: 345122
// Difficulty: Medium
// Contributors: Admin
// Find the contiguous subarray within an array (containing at least one number) which has the largest product.

// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.

// Subscribe to see which companies asked this question

// Hide Tags Array Dynamic Programming
// Hide Similar Problems (M) Maximum Subarray (E) House Robber (M) Product of Array Except Self


// O(1) space
A = [2 3 -1 0 -2 4 3 5 -1]
max = [2 6 -1 0 0  4 12 60 480];
min = [2 3 -6 0 -2 -8 -96 -480 -60];


public class Solution {
    public int maxProduct(int[] A) {
        if (A.length==0) return 0;
        int n = A.length; 
        // int[] max = new int[n];
        // int[] min = new int[n];
        max = A[0];
        min = A[0];
        int result = A[0];
        for (int i=1;i<n;i++){
            int temp = max;
            max = Math.max(Math.max(min*A[i],max*A[i]),A[i]);
            min = Math.min(Math.min(min*A[i],temp*A[i]),A[i]);
            result = Math.max(result,max);
        }
    return result;
    }
}


public class Solution {
    public int maxProduct(int[] A) {
        if (A.length==0) return 0;
        int n = A.length; 
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = A[0];
        min[0] = A[0];
        int result = A[0];
        for (int i=1;i<n;i++){
            max[i] = Math.max(Math.max(min[i-1]*A[i],max[i-1]*A[i]),A[i]);
            min[i] = Math.min(Math.min(min[i-1]*A[i],max[i-1]*A[i]),A[i]);
            result = Math.max(result,max[i]);
        }
    return result;
	}
}


