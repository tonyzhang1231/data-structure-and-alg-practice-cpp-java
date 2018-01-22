// 222. Count Complete Tree Nodes   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 51634
// Total Submissions: 191780
// Difficulty: Medium
// Contributors: Admin
// Given a complete binary tree, count the number of nodes.

// Definition of a complete binary tree from Wikipedia:
// In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

// Subscribe to see which companies asked this question

// Hide Tags Tree Binary Search
// Hide Similar Problems (E) Closest Binary Search Tree Value


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
    // if height == 1, node 1, height is 2, 3 => 2^height - 1
    
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int left_h = height(root.left);
        int right_h = height(root.right);
        if (left_h == right_h){
            return (1<<left_h) + countNodes(root.right); //  2^height - 1 + 1(root) + rightside
        }else{ // left_h == right_h + 1;
            return (1<<right_h) + countNodes(root.left); //  2^height - 1 + 1(root) + leftside
        }
    }
    
    int height(TreeNode root){
        if(root==null) return 0;
        int h = 0;
        while(root!=null){
            root = root.left;
            h++;
        }
        return h;
    }
}

// O(log (number of nodes)) time, O(h) space