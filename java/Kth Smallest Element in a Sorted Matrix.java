// 378. Kth Smallest Element in a Sorted Matrix   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 24561
// Total Submissions: 56677
// Difficulty: Medium
// Contributors: Admin
// Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

// Note that it is the kth smallest element in the sorted order, not the kth distinct element.

// Example:

// matrix = [
//    [ 1,  5,  9],
//    [10, 11, 13],
//    [12, 13, 15]
// ],
// k = 8,

// return 13.
// Note: 
// You may assume k is always valid, 1 ≤ k ≤ n2.

// Subscribe to see which companies asked this question

public class Solution {
    public int kthSmallest(int[][] A, int k) {
        if (A.length==0 || A[0].length==0) return 0;
        PriorityQueue<int[]> q = new PriorityQueue<>( (a,b)->a[2]-b[2]); // int[3]  row, col, val
        int m = A.length, n = A[0].length;
        if (m*n<=k) return A[m-1][n-1];
        
        for (int i=0;i<m;i++){
            q.offer(new int[]{i,0,A[i][0]}); 
        }
        
        while(--k>0){
            int[] t = q.poll();
            int x = t[0], y = t[1], v= t[2];
            if (y<n-1){
                q.offer(new int[]{x,y+1,A[x][y+1]}); // push its right element to the q
            }
            
        }
        int[] t = q.poll();
        return t[2];
    }
}