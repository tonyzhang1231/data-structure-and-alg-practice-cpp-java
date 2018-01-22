// 108. Convert Sorted Array to Binary Search Tree   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 101270
// Total Submissions: 250851
// Difficulty: Medium
// Contributors: Admin
// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

// Subscribe to see which companies asked this question


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null || nums.length==0) return null;
        return buildtree(nums,0,nums.length-1);
    }
    
    public TreeNode buildtree(int[] A, int start, int end){
        if (start>end) return null;
        int root_index = start + (end - start +1)/2;
        TreeNode root = new TreeNode(A[root_index]); // start + len/2 is the index of root
        root.left = buildtree(A,start, root_index - 1);
        root.right = buildtree(A, root_index + 1,end);
        return root;
    }
}