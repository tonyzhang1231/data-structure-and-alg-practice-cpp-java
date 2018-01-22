// 54. Spiral Matrix   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 84260
// Total Submissions: 343496
// Difficulty: Medium
// Contributors: Admin
// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

// For example,
// Given the following matrix:

// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// You should return [1,2,3,6,9,8,7,4,5].

// Subscribe to see which companies asked this question

// Hide Tags Array
// Hide Similar Problems (M) Spiral Matrix II


public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length==0) return res;
        
        int m = matrix.length, n = matrix[0].length;
        int rowbegin = 0, rowend = m-1, colbegin = 0, colend = n-1;
        
        while (rowbegin<=rowend && colbegin <=colend){
            
        
	        for (int col = colbegin;col<=colend;col++){
	            res.add(matrix[rowbegin][col]);
	        }
	        rowbegin++;
	        
	        for (int row = rowbegin;row<=rowend;row++){
	            res.add(matrix[row][colend]);
	        }
	        colend--;
	        
	        if (rowend>=rowbegin){
	            for (int col = colend;col>=colbegin;col--){
	                res.add(matrix[rowend][col]);
	            }
	            rowend--;
	        }
	        
	        if (colend>=colbegin){
	            for (int row = rowend;row>=rowbegin;row--){
	                res.add(matrix[row][colbegin]);
	            }
	            colbegin++;
	        }
        
        }
        return res;
    }
}



//
59. Spiral Matrix II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 70734
Total Submissions: 186524
Difficulty: Medium
Contributors: Admin
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
Subscribe to see which companies asked this question

public class Solution {
    public int[][] generateMatrix(int n) {
    	int[][] res = new int[n][n];
    	int num = 1;
        int rowbegin = 0, rowend = n-1, colbegin = 0, colend = n-1;

		while (rowbegin<=rowend && colbegin <=colend){
            
        
	        for (int col = colbegin;col<=colend;col++){
	            res[rowbegin][col] = num++;
	        }
	        rowbegin++;
	        
	        for (int row = rowbegin;row<=rowend;row++){
	            res[row][colend] = num++;
	        }
	        colend--;
	        
	        if (rowend>=rowbegin){
	            for (int col = colend;col>=colbegin;col--){
	                res[rowend][col] = num++;
	            }
	            rowend--;
	        }
	        
	        if (colend>=colbegin){
	            for (int row = rowend;row>=rowbegin;row--){
	                res[row][colbegin] = num++;
	            }
	            colbegin++;
	        }
        
        }
		return res;
    }
}