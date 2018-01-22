110. Balanced Binary Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 150027
Total Submissions: 414437
Difficulty: Easy
Contributors: Admin
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Subscribe to see which companies asked this question

Hide Tags Tree Depth-first Search
Hide Similar Problems (E) Maximum Depth of Binary Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

      1
   2     3
  4  5     6
 8          7
9
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root)!=-1;
    }

    public int height(TreeNode root){
    	if (root==null) return 0;
    	int left = height(root.left);
    	if (left==-1) return -1; // terminate the recursion earlier, if left is invalid, no need go to the right
    	int right = height(root.right);
    	if (right==-1) return -1;

    	if (Math.abs(left-right)>1) return -1;
    	return Math.max(left,right) +1;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return helper(root)!=-1;
    }
    
    // bottom up
    int helper(TreeNode root){
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1) return -1;
        if (Math.abs(left - right)>1) return -1;
        return Math.max(left, right) + 1;
    }
}