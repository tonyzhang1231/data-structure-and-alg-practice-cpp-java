// 333. Largest BST Subtree   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 10749
// Total Submissions: 36001
// Difficulty: Medium
// Contributors: Admin
// Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

// Note:
// A subtree must include all of its descendants.
// Here's an example:
//     10
//     / \
//    5  15
//   / \   \ 
//  1   8   7
// The Largest BST Subtree in this case is the highlighted one. 
// The return value is the subtree's size, which is 3.
// Hint:

// You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
// Follow up:
// Can you figure out ways to solve it with O(n) time complexity?

// Hide Company Tags Microsoft
// Hide Tags Tree


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
    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return max;
    }
    
    public int[] helper(TreeNode root){   // return 3 values, number of nodes, leftmost value and rightmost value
        int[] res = new int[3];
        if (root==null) return res;
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        if ( (root.left==null || left[0]!=-1 && left[2]<root.val)   && (root.right==null || right[0]!=-1 && right[1]>root.val) ){
            res[0] = left[0] + right[0] + 1;
            max = Math.max(max, res[0]);
            res[1] = root.left==null?root.val:left[1];
            res[2] = root.right==null?root.val:right[2];
        }else{
            res[0] = -1;
        }
        return res;
    }
    
//      10
//     / \
//    5   15
//   / \   \ 
//  1   8   7
}