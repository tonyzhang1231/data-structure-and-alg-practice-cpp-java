// 73. Set Matrix Zeroes   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 88355
// Total Submissions: 251543
// Difficulty: Medium
// Contributors: Admin
// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

// click to show follow up.

// Follow up:
// Did you use extra space?
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?

// Subscribe to see which companies asked this question


// much easier to read
public class Solution {
	public void setZeroes(int[][] matrix) {
	    boolean fr = false,fc = false;
	    for(int i = 0; i < matrix.length; i++) {
	        for(int j = 0; j < matrix[0].length; j++) {
	            if(matrix[i][j] == 0) {
	                if(i == 0) fr = true;
	                if(j == 0) fc = true;
	                matrix[0][j] = 0;
	                matrix[i][0] = 0;
	            }
	        }
	    }
	    for(int i = 1; i < matrix.length; i++) {
	        for(int j = 1; j < matrix[0].length; j++) {
	            if(matrix[i][0] == 0 || matrix[0][j] == 0) {
	                matrix[i][j] = 0;
	            }
	        }
	    }
	    if(fr) {
	        for(int j = 0; j < matrix[0].length; j++) {
	            matrix[0][j] = 0;
	        }
	    }
	    if(fc) {
	        for(int i = 0; i < matrix.length; i++) {
	            matrix[i][0] = 0;
	        }
	    } 
	}
}



// short but harder to understand
// public class Solution {
//     public void setZeroes(int[][] matrix) {
//         int col0 = 1, rows = matrix.length, cols = matrix[0].length;

// 	    for (int i = 0; i < rows; i++) {
// 	        if (matrix[i][0] == 0) col0 = 0;
// 	        for (int j = 1; j < cols; j++)
// 	            if (matrix[i][j] == 0)
// 	                matrix[i][0] = matrix[0][j] = 0;
// 	    }

// 	    for (int i = rows - 1; i >= 0; i--) {
// 	        for (int j = cols - 1; j >= 1; j--)
// 	            if (matrix[i][0] == 0 || matrix[0][j] == 0)
// 	                matrix[i][j] = 0;
// 	        if (col0 == 0) matrix[i][0] = 0;
// 	    }
//     }
// }