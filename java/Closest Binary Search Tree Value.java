Closest Binary Search Tree Value

// 270. Closest Binary Search Tree Value   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 26520
// Total Submissions: 69570
// Difficulty: Easy
// Contributors: Admin
// Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

// Note:
// Given target value is a floating point.
// You are guaranteed to have only one unique value in the BST that is closest to the target.

// Microsoft Google Snapchat
// Hide Tags Tree Binary Search
// Hide Similar Problems (M) Count Complete Tree Nodes (H) Closest Binary Search Tree Value II



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
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while(root!=null){
            if (root.val>target){
                root = root.left;
            }else{
                root = root.right;
            }
            
            if (root!=null && Math.abs(root.val -target)< Math.abs(res - target)) 
                    res = root.val;
        }
        return res;
    }
}


public class Solution {
    public int closestValue(TreeNode root, double target) {
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            
            // function, we want to find the first node which value is >= target
            if (root.val>=target){
                if (prev==null) return root.val;
                else{
                    if (root.val - target < target - prev.val) return root.val;
                    return prev.val;
                }
            }
            prev = root;
            root = root.right;
        }
        return prev.val;
    }
}



// Java 5ms iterative, following hint, O(klogn) time and space
// Following the hint, I use a predecessor stack and successor stack. I do a logn traversal to initialize them until I reach the null node. Then I use the getPredecessor and getSuccessor method to pop k closest nodes and update the stacks.

// Time complexity is O(klogn), since k BST traversals are needed and each is bounded by O(logn) time. Note that it is not O(logn + k) which is the time complexity for k closest numbers in a linear array.

// Space complexity is O(klogn), since each traversal brings O(logn) new nodes to the stack.

class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root==null || k==0) return res;
        
        Stack<TreeNode> succ = new Stack<>();
        Stack<TreeNode> pred = new Stack<>();
        
        TreeNode p = root;
        while(p!=null){
            if (target <= p.val){
                succ.push(p);
                p = p.left;
            }else{
                pred.push(p);
                p = p.right;
            }
        }
        
        // p = root;
        while(!succ.isEmpty() || !pred.isEmpty()){
            if (succ.isEmpty()){
                res.add(getPred(pred));k--;
            }else if (pred.isEmpty()){
                res.add(getSucc(succ));k--;
            }else{
                if (target - pred.peek().val < succ.peek().val - target){
                    res.add(getPred(pred));k--;
                }else{
                    res.add(getSucc(succ));k--;
                }
            }
            if (k==0) break;
            
        }
        
        
        return res;
    }
    
    int getSucc(Stack<TreeNode> st){
        TreeNode node = st.pop();
        TreeNode p = node.right;
        while(p!=null){
            st.push(p);
            p = p.left;
        }
        return node.val;
    }
    
    int getPred(Stack<TreeNode> st){
        TreeNode node = st.pop();
        TreeNode p = node.left;
        while(p!=null){
            st.push(p);
            p = p.right;
        }
        return node.val;
    }
}


// 3.4

//             4
//     2             6
// 1       3       5    7

// if (target < p.val){
//     succ.push(p); // 因为4 > 3.4, succ 下一个要push的值一定比4 小， 比3.4 大
//     p = p.left;
// }else{
//     pred.push(p); // 第一个push 2 第二个 push 3
//     p = p.right;  
// }
// // 当然这个只是push了从root 到leaf的一条路径上每个node， 比如说当succ的某个被pop出来后，要加上之后所有的left

// if (succ.peek().val - target < target - pred.peek().val){
//     TreeNode node = succ.pop();
//     TreeNode p = node.right;
//     while(p!=null){
//         stack.push(p);
//         p = p.left;
//     }
// }

// // 相反，pred side
// else{
//     TreeNode node = pred.pop();
//     TreeNode p = node.left;
//     while(p!=null){
//         stack.push(p);
//         p = p.right;
//     }
// }


