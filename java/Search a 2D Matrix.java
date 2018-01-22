// 74. Search a 2D Matrix   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 106928
// Total Submissions: 300420
// Difficulty: Medium
// Contributors: Admin
// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
// For example,

// Consider the following matrix:

// [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// Given target = 3, return true.

// Subscribe to see which companies asked this question


public class Solution {
    public boolean searchMatrix(int[][] A, int target) {
        if (A==null || A.length==0 ||A[0].length==0) return false;
        int m = A.length, n = A[0].length;
        int lo = 0, hi = m*n - 1;
        while(lo + 1<hi){
        	int mid = lo + (hi-lo)/2;
        	// i,j => i*n+j
        	int r = mid/n, c = mid%n;
        	if (A[r][c]==target) return true;
        	else if (A[r][c]<target) lo = mid;
        	else hi = mid;
        }
        if (A[lo/n][lo%n]==target) return true;
        if (A[hi/n][hi%n]==target) return true;
        return false;
    }
}

// O(log (mn)) time O(1) space



// 240. Search a 2D Matrix II   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 61870
// Total Submissions: 163062
// Difficulty: Medium
// Contributors: Admin
// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
// For example,

// Consider the following matrix:

// [
//   [1,   4,  7, 11, 15],
//   [2,   5,  8, 12, 19],
//   [3,   6,  9, 16, 22],
//   [10, 13, 14, 17, 24],
//   [18, 21, 23, 26, 30]
// ]
// Given target = 5, return true.

// Given target = 20, return false.

// Subscribe to see which companies asked this question

// Hide Tags Binary Search Divide and Conquer
// Hide Similar Problems (M) Search a 2D Matrix



// O(mlogn) 
// if m is small, n is very big, Binary search very row 
// (check the row first, if largest one < target || smallest one > target, stop)
public class Solution {
    public boolean searchMatrix(int[][] A, int target) {
    	if (A==null || A.length==0 ||A[0].length==0) return false;
    	int m = A.length, n = A[0].length;
        for (int i=0;i<m;i++){
        	if (A[i][0]>=target && A[i][n-1]<=target) 
        		if (binarySearch(A,i,target)) 
        			return true;
        }
    	return false;
    }

    boolean binarySearch(int[][] A, int i,int target){
		int m = A.length, n = A[0].length;
		int lo = 0, hi = n - 1;
	    while(lo + 1<hi){
	    	int mid = lo + (hi-lo)/2;
	    	// i,j => i*n+j
	    	if (A[i][mid]==target) return true;
	    	else if (A[i][mid]<target) lo = mid;
	    	else hi = mid;
	    }
	    if (A[i][lo]==target) return true;
	    if (A[i][hi]==target) return true;
	    return false; 
	}
}


// O(m+n) 
// if m and n differs not too much O(m+n), from the top right element
public class Solution {
public boolean searchMatrix(int[][] matrix, int target) {
    int m=matrix.length, n=matrix[0].length, i=0, j=n-1;
    while (i<m && j>=0) {
        if (matrix[i][j]==target) return true;
        else if (matrix[i][j]<target) i++;
        else j--;
    }
    return false;
}