// 250. Count Univalue Subtrees   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 12212
// Total Submissions: 30254
// Difficulty: Medium
// Contributors: Admin
// Given a binary tree, count the number of uni-value subtrees.

// A Uni-value subtree means all nodes of the subtree have the same value.

// For example:
// Given binary tree,
//               5
//              / \
//             1   5
//            / \   \
//           5   5   5
// return 4.

// Hide Tags Tree


public class Solution {
	int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return count;
    }
    
    private boolean helper(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean left = helper(node.left);
        boolean right = helper(node.right);
        if (left && right) {
            if (node.left != null && node.val != node.left.val) {
                return false;
            }
            if (node.right != null && node.val != node.right.val) {
                return false;
            }
            count++;
            return true;
        }
        return false;
    }
}