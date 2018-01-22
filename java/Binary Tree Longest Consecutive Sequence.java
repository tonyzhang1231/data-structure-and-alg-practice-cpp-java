// 298. Binary Tree Longest Consecutive Sequence   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 22080
// Total Submissions: 55419
// Difficulty: Medium
// Contributors: Admin
// Given a binary tree, find the length of the longest consecutive sequence path.

// The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

// For example,
//    1
//     \
//      3
//     / \
//    2   4
//         \
//          5
//           \
//            2  (1)
// Longest consecutive sequence path is 3-4-5, so return 3.
//    2
//     \
//      3
//     / 
//    2    
//   / 
//  1
// Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
// Hide Company Tags Google
// Hide Tags Tree
// Hide Similar Problems (H) Longest Consecutive Sequence
// Have you met this question in a real interview? Yes  



// top down (easier to impliment), recommend to use this method
public class Solution {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0, root.val);
        return max;
    }
    
    public void helper(TreeNode root, int len, int target){
        if(root == null) return;
        if(root.val == target) len++;
        else len = 1; // else reset to 1
        max = Math.max(len, max); // update max
        helper(root.left, len, root.val + 1);
        helper(root.right, len, root.val + 1);
    }
}

// O(n) time, O(height) space

// // bottom up
// public class Solution {
//     int max = 0;
//     public int longestConsecutive(TreeNode root) {
//         // bottom up
//         helper(root);
//         return max;
//     }
    
//     public int helper(TreeNode root){
//         if (root == null) return 0;
        
//         int left = helper(root.left);
//         int right = helper(root.right);
        
//         if (root.left!=null && root.left.val != root.val+1) left = 0;
//         if (root.right!=null && root.right.val != root.val+1) right = 0;
        
//         max = Math.max(max, Math.max(left, right) + 1);
        
//         return Math.max(left, right) + 1;
//     }
// }

// top down and bottom up without a global variable
public class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root==null) return 0;
        return Math.max(dfs(root.left, 1, root.val), dfs(root.right, 1, root.val));
    }
    
    // instead of using a globle variable , use a count in each node, pass down the root.val and count, return up the max
    public int dfs(TreeNode root, int count, int parent_val){
        if(root==null) return count;
        count = (root.val - parent_val == 1)?count+1:1;
        int left = dfs(root.left, count, root.val);
        int right = dfs(root.right, count, root.val);
        return Math.max(Math.max(left, right), count);
    }
}




//    1
//   2
