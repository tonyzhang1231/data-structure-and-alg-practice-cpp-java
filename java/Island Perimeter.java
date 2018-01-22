// 463. Island Perimeter   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 16909
// Total Submissions: 29968
// Difficulty: Easy
// Contributors: amankaraj
// You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

// Example:

// [[0,1,0,0],
//  [1,1,1,0],
//  [0,1,0,0],
//  [1,1,0,0]]

// Answer: 16
// Explanation: The perimeter is the 16 yellow stripes in the image below:



O(4nm) time and O(1) space

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int m=grid.length, n =grid[0].length;
        int res = 0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]==1) {
                    res+= helper(grid,i+1,j,m,n);
                    res+= helper(grid,i-1,j,m,n);
                    res+= helper(grid,i,j-1,m,n);
                    res+= helper(grid,i,j+1,m,n);
                }
                    
            }
        }
        return res;
    }
    
    public int helper(int[][] grid, int i,int j, int m, int n){
        if (i<0 || j<0 || i>=m || j>=n || grid[i][j]==0){
            return 1;
        }
        return 0;
        
    }
}