105. Construct Binary Tree from Preorder and Inorder Traversal



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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0 || inorder.length==0) return null;
        return helper(preorder, inorder, 0, 0,inorder.length-1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd){
        if (preStart>=preorder.length || inStart  > inEnd)  return null;
        
        TreeNode t = new TreeNode(preorder[preStart]);
        
        int index = inStart;
        for (int i = inStart;i<=inEnd;i++){
            if (inorder[i] == preorder[preStart]){
                index = i;
                break;
            }
        }
        
        int len = index - inStart;
        
        t.left = helper(preorder, inorder, preStart + 1, inStart, index - 1);
        t.right = helper(preorder, inorder, preStart + len + 1, index + 1, inEnd);
        return t;
    }
}

// find the leaves of binary search tree from its preorder 
public List<Integer> findleaves(int[] preorder){
    List<Integer> res = new ArrayList<>();
    helper(preorder, res, 0, preorder.length-1);
    return res;
}

public void helper(int[] preorder, List<Integer> res, int start, int end){
    if (start>end) return;
    if (start==end){ // a leaf
        res.add(preorder[start]);
        return;
    }

    int root = preorder[start];
    int right_index = start + 1;
    for (int i = start+1;i<=end;i++){
        if (root<preorder[i]){
            right_index = i;
            break;
        }
    }

    helper(preorder, res, start+1, right_index-1);
    helper(preorder, res, right_index, end);

}

