// 96. Unique Binary Search Trees   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 106809
// Total Submissions: 268537
// Difficulty: Medium
// Contributors: Admin
// Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

// For example,
// Given n = 3, there are a total of 5 unique BST's.

//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3
// Subscribe to see which companies asked this question



// use a hashmap for memorization, O(n^2) time, O(n^2) space
// only to compute helper(i,j) once,  1<=i,j<=n, => O(n^2) time
public class Solution {
    
    HashMap<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new ArrayList<TreeNode>();
        return helper(1,n,n);
    }
    
    public List<TreeNode> helper(int start, int end, int n){
        List<TreeNode> res = new ArrayList<>();
        
        if (start>end) {
            res.add(null);  // must add a null, otherwise the following 2 for loops would not work
            return res;
        }
        
        int key = (start-1)*n + end-1;
        if (map.containsKey(key)) return map.get(key);
        
        for (int i=start; i<=end; i++){
            List<TreeNode> left = helper(start,i-1,n);
            List<TreeNode> right = helper(i+1,end,n);
            for (TreeNode l:left){
                for (TreeNode r:right){
                    TreeNode t = new TreeNode(i);
                    t.left = l;
                    t.right = r;
                    res.add(t);
                }
            }
        }
        
        map.put(key, res);
        
        return res;
    }
}

public class Solution {
    public int numTrees(int n) {
        // f[n] = \sum f[i] * f[n-1-i]
        if (n<=1) return n;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i=1;i<=n;i++){
            for (int j=0;j<i;j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
    
    // n == 1, dp[1] = 1
    // n = 2, dp[2] = dp[0]*dp[1] + dp[1] *dp[0] = 2;
    
}



// II

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */



// O(exp) time solution
public class Solution {
    
    // HashMap<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new ArrayList<TreeNode>();
        return helper(1,n);
    }
    
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        
        if (start>end) {    // must add a null, 
            res.add(null);
            return res;
        }
        
        // int key = (start-1)*n + end-1;
        // if (map.containsKey(key)) return map.get(key);
        
        for (int i=start;i<=end;i++){
            List<TreeNode> left = helper(start,i-1);
            List<TreeNode> right = helper(i+1,end);
            for (TreeNode l:left){
                for (TreeNode r:right){
                    TreeNode t = new TreeNode(i);
                    t.left = l;
                    t.right = r;
                    res.add(t);
                }
            }
        }
        
        // map.put(key, res);
        
        return res;
    }
}


