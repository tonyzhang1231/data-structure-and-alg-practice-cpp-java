/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// 连接完的时候走向root left， 断开完的时候走向root right

public class Solution {
	public void recoverTree(TreeNode root) {
        TreeNode pre = null;
        TreeNode first = null, second = null;
        // Morris Traversal
        TreeNode temp = null;
        int count = 0;
		while(root!=null){
			if(root.left!=null){   // if root has left child
				// connect threading for root
				temp = root.left;

				while(temp.right!=null && temp.right != root){
					temp = temp.right;
				}
					
				if(temp.right != null) // temp.right == root, means the threading already exists
				{
					// add function here
				    if( pre!=null && pre.val > root.val ){
				        if(first==null){first = pre;second = root;}
				        else{second = root;}
				        count++;
				    }
				    pre = root; // if pre == null, which means root.val is the smallest one
				    // function end

					temp.right = null; // remove the threading, we don't want to change the tree except recover two nodes
					root = root.right; // 断开完的时候走向root right
				}
				else  // construct the threading
				{
					temp.right = root;
					root = root.left;  // 连接完的时候走向root left
				}
			}
			else  // if root doesn't have a left child
			{
				// add function here
				if(pre!=null && pre.val > root.val){
				    if(first==null){first = pre;second = root;}
				    else{second = root;}
				    count++;
				}
				pre = root;
				// function end

				root = root.right;
			}
			if (count==2) break;
		}
		// swap two node values;
		if(first!= null && second != null){
		    int t = first.val;
		    first.val = second.val;
		    second.val = t;
		}
    }
}