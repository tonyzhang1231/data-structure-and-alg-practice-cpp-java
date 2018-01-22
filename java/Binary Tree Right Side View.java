// 199. Binary Tree Right Side View   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 65766
// Total Submissions: 170042
// Difficulty: Medium
// Contributors: Admin
// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// For example:
// Given the following binary tree,
//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---
// You should return [1, 3, 4].

// Credits:
// Special thanks to @amrsaqr for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

//  Tree Depth-first Search Breadth-first Search
// Hide Similar Problems (M) Populating Next Right Pointers in Each Node



public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    // topdown method, void , pass parameters
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){  // result.size() serves as the global depth
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }
}