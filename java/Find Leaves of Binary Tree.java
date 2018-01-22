// 366. Find Leaves of Binary Tree   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 10995
// Total Submissions: 19279
// Difficulty: Medium
// Contributors: Admin
// Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

// Example:
// Given binary tree 
//           1
//          / \
//         2   3
//        / \     
//       4   5    
// Returns [4, 5, 3], [2], [1].

// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */


public class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();  // level -> list of tree node values
    int maxlevel = 0;
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root);
        for (int l= 1;l<=maxlevel;l++){
            res.add(map.get(l));
        }
        return res;
    }
    
    public int helper(TreeNode root){
        if (root==null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        
        int level = Math.max(left,right) + 1;
        maxlevel = Math.max(maxlevel,level);
        if (!map.containsKey(level)){
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(root.val);
        return level;
    }
    
    //       1
    //      / \
    //     2   3
    //    / \     
    //   4   5
    
    // map 1 : 4 5 3
        //   2 : 2
            // 3 : 1
           
           
}