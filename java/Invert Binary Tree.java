// 226. Invert Binary Tree   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 144424
// Total Submissions: 290375
// Difficulty: Easy
// Contributors: Admin
// Invert a binary tree.

//      4
//    /   \
//   2     7
//  / \   / \
// 1   3 6   9
// to
//      4
//    /   \
//   7     2
//  / \   / \
// 9   6 3   1
// Trivia:
// This problem was inspired by this original tweet by Max Howell:
// Google: 90% of our engineers use the software you wrote (Homebrew), 
// but you can’t invert a binary tree on a whiteboard so fuck off.
// Subscribe to see which companies asked this question

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

// recursive dfs (bottom up)
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        return helper(root);
    }

    public TreeNode helper(TreeNode root){
    	if (root == null) return null;
    	TreeNode left = helper(root.left);
    	TreeNode right = helper(root.right);
    	root.right = left;
    	root.left = right;
    	return root;
    }

}

// recursive dfs (bottom up) O(h) space + O(n) time
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
        
    }
}




// iterative dfs
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if (root == null) {
            return null;
        }

        final Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        
        // like preorder traveral
        while(!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }
}

// O(h) space, O(n) time


//bfs
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}

// O(n) time and O(n) space