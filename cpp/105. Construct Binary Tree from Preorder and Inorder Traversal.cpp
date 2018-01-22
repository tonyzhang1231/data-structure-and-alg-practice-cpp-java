/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return helper(preorder, inorder, 0, 0, inorder.size()-1);
    }
    
    TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int preStart, int inStart, int inEnd){
        if (inStart > inEnd) return nullptr;
        
        TreeNode* root = new TreeNode(preorder[preStart]);
        int index = inStart;
        for (int i=inStart;i<=inEnd;i++){
            if (inorder[i]==preorder[preStart]){
                index = i;
                break;
            }
        }
        
        
        root->left = helper(preorder, inorder, preStart+1, inStart, index - 1);
        root->right = helper(preorder, inorder, preStart+1 + (index-inStart), index+1, inEnd);
        
        return root;
    }
};