// 373. Find K Pairs with Smallest Sums   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 19660
// Total Submissions: 65969
// Difficulty: Medium
// Contributors: Admin
// You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

// Define a pair (u,v) which consists of one element from the first array and one element from the second array.

// Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

// Example 1:
// Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

// Return: [1,2],[1,4],[1,6]

// The first 3 pairs are returned from the sequence:
// [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// Example 2:
// Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

// Return: [1,1],[1,1]

// The first 2 pairs are returned from the sequence:
// [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// Example 3:
// Given nums1 = [1,2], nums2 = [3],  k = 3 

// Return: [1,3],[2,3]

// All possible pairs are returned from the sequence:
// [1,3],[2,3]
// Credits:
// Special thanks to @elmirap and @StefanPochmann for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Heap
// Hide Similar Problems (M) Kth Smallest Element in a Sorted Matrix

public class Solution {
    public List<int[]> kSmallestPairs(int[] A, int[] B, int k) {
        List<int[]> res = new ArrayList<>();
        if (A.length==0 || B.length==0) return res;
        
        int m = A.length, n = B.length;
        PriorityQueue<int[]> q = new PriorityQueue<>( (a,b)->a[2]-b[2] );   // int[]: A_index, B_index, sum
        
        for (int i=0;i<m;i++){
            q.offer(new int[]{i,0,A[i]+B[0]}); // offer (A[i], B[0]);
        }
        
        while(!q.isEmpty() && k-->0) {  // do k times
            int[] t = q.poll();
            int a_i = t[0], b_i = t[1];
            res.add(new int[]{A[a_i],B[b_i]});
            if (b_i<n-1){ // b_i is not the last one
                q.offer(new int[]{a_i,b_i+1,A[a_i]+B[b_i+1]});
            }
        }
        
        return res;
    }
}


/*
(0,0) ,...... (0,n)
(1,0) ,.......(1,n)


(n,0) ........(n,n)

一开始吧第一行加进去, 拿出最小的那个, 把第二行对应的那个加进去, 一次类推,  有点类似merge K sort list

*/
